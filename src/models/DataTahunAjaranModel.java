/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author Achmad
 */
public class DataTahunAjaranModel {

    public DefaultTableModel loadDataTahunAjaran() {
        String query = "SELECT * FROM tahun_ajaran";
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "TAHUN AJARAN", "GEN", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                String idTA = resultSet.getString("id");
                String tahunAjaran = resultSet.getString("tahun_ajaran");
                String gen = resultSet.getString("gen");
                model.addRow(new Object[]{idTA, tahunAjaran, gen});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }

    public boolean deleteTahunAjaran(String id) {
        String query = "DELETE FROM tahun_ajaran WHERE id = ?";
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

    public DefaultTableModel searchDataTahunAjaran(String searchText) {
        String query = "SELECT * FROM tahun_ajaran WHERE tahun_ajaran LIKE ? OR gen LIKE ?";
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "TAHUN AJARAN", "GEN", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + searchText + "%");
            pstmt.setString(2, "%" + searchText + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                model.setRowCount(0);
                while (resultSet.next()) {
                    String idTA = resultSet.getString("id");
                    String tahunAjaran = resultSet.getString("tahun_ajaran");
                    String gen = resultSet.getString("gen");
                    model.addRow(new Object[]{idTA, tahunAjaran, gen});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }
}
