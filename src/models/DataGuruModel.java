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
public class DataGuruModel {

    public DefaultTableModel loadDataGuru() {
        String query = "SELECT nip, full_name, email, password, guruMapel FROM users WHERE role_id = 2";
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "NIP", "NAMA GURU", "EMAIL", "PASSWORD", "MAPEL", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement st = conn.prepareStatement(query); ResultSet resultSet = st.executeQuery()) {

            while (resultSet.next()) {
                String nip = resultSet.getString("nip");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String guruMapel = resultSet.getString("guruMapel");

                model.addRow(new Object[]{nip, fullName, email, password, guruMapel});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }
    
    public boolean deleteGuru(String nip) {
        String query = "DELETE FROM users WHERE nip = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, nip);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
