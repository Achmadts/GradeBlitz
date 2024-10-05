package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

public class DataKelasModel {

    public DefaultTableModel loadDataKelas() {
        String query = "SELECT k.id, k.nama_kelas, k.jurusan, ta.gen "
                + "FROM kelas k "
                + "JOIN tahun_ajaran ta ON k.gen_id = ta.id";

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "NAMA KELAS", "JURUSAN", "ANGKATAN", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet resultSet = pstmt.executeQuery()) {

            model.setRowCount(0);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String namaKelas = resultSet.getString("nama_kelas");
                String jurusan = resultSet.getString("jurusan");
                String gen = resultSet.getString("gen");

                model.addRow(new Object[]{id, namaKelas, jurusan, gen});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }

    public boolean deleteKelas(String id) {
        String query = "DELETE FROM kelas WHERE id = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public DefaultTableModel searchKelas(String searchText) {
        String query = "SELECT k.id, k.nama_kelas, k.jurusan, ta.gen "
                + "FROM kelas k "
                + "JOIN tahun_ajaran ta ON k.gen_id = ta.id "
                + "WHERE (k.nama_kelas LIKE ? OR k.jurusan LIKE ?)";

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "NAMA KELAS", "JURUSAN", "ANGKATAN", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + searchText + "%");
            pstmt.setString(2, "%" + searchText + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                model.setRowCount(0);
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String namaKelas = resultSet.getString("nama_kelas");
                    String jurusan = resultSet.getString("jurusan");
                    String gen = resultSet.getString("gen");

                    model.addRow(new Object[]{id, namaKelas, jurusan, gen});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return model;
    }
}
