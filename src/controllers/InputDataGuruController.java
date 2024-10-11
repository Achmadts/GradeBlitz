package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import models.InputDataGuruModel;

public class InputDataGuruController {

    public boolean insertDataGuru(InputDataGuruModel guru) {
        String checkQuery = "SELECT COUNT(*) FROM users WHERE full_name = ? OR email = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement checkStatement = conn.prepareStatement(checkQuery)) {

            checkStatement.setString(1, guru.getNama());
            checkStatement.setString(2, guru.getEmail());

            ResultSet rs = checkStatement.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Nama atau email sudah ada", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                String query = "INSERT INTO users (nip, full_name, email, password, guruMapel, role_id) VALUES (?, ?, ?, ?, ?, 2)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setString(1, guru.getNip());
                    preparedStatement.setString(2, guru.getNama());
                    preparedStatement.setString(3, guru.getEmail());
                    preparedStatement.setString(4, guru.getPassword());
                    preparedStatement.setString(5, guru.getGuruMapel());

                    int rowsInserted = preparedStatement.executeUpdate();
                    return rowsInserted > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}