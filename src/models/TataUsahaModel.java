package models;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import koneksi.koneksi;

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
            "JAM KE", "JAM", "NIP", "NAMA", "MAPEL", "RUANG"
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

                model.addRow(new Object[]{jamKe, jam, nip, fullName, namaMapel, ruang});
                jamKe++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }
}
