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
public class DataMapelModel {

    public DefaultTableModel loadDataMapel() {
        String query = "SELECT * FROM mapel";
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "NAMA MAPEL", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                String idMapel = resultSet.getString("id");
                String namaMapel = resultSet.getString("nama_mapel");
                model.addRow(new Object[]{idMapel, namaMapel});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }

    public boolean deleteMapel(String id) {
        String query = "DELETE FROM mapel WHERE id = ?";
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

    public DefaultTableModel searchMapel(String searchText) {
        String query = "SELECT * FROM mapel WHERE nama_mapel LIKE ?";
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID", "NAMA MAPEL", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + searchText + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                model.setRowCount(0);
                while (resultSet.next()) {
                    String idMapel = resultSet.getString("id");
                    String namaMapel = resultSet.getString("nama_mapel");
                    model.addRow(new Object[]{idMapel, namaMapel});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }
}
