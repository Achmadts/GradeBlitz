package models;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class TataUsahaModel {

    private int userId;

    public TataUsahaModel(int userId) {
        this.userId = userId;
    }

    public DefaultTableModel getJadwalData(String hari) {
        String query = "SELECT jp.id, u.full_name, m.nama_mapel, jp.hari, jp.jam, jp.ruang, jp.user_id, u.nip "
                + "FROM jadwal_pelajaran jp "
                + "JOIN users u ON jp.user_id = u.nip "
                + "JOIN mapel m ON jp.mapel_id = m.id "
                + "WHERE jp.hari = ? "
                + "ORDER BY jp.jam ASC";

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "JAM KE", "JAM", "NIP", "NAMA", "MAPEL", "RUANG", "HARI", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, hari);
            ResultSet resultSet = preparedStatement.executeQuery();

            int jamKe = 1;
            while (resultSet.next() && jamKe <= 10) {
                String jam = resultSet.getString("jam");
                String nip = resultSet.getString("nip");
                String fullName = resultSet.getString("full_name");
                String namaMapel = resultSet.getString("nama_mapel");
                String ruang = resultSet.getString("ruang");
                String idJadwal = resultSet.getString("id");

                model.addRow(new Object[]{jamKe, jam, nip, fullName, namaMapel, ruang, hari, idJadwal});
                jamKe++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return model;
    }

    public DefaultComboBoxModel<Integer> getMapelComboBoxModel() {
        DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
        String query = "SELECT id FROM mapel";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                model.addElement(id); // Menambahkan ID mapel ke model
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data mapel.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return model;
    }

    public int getMapelIdByName(String mapelName) {
        String query = "SELECT id FROM mapel WHERE nama_mapel = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, mapelName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
