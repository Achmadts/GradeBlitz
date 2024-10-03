/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.updateDataGuruModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 *
 * @author Achmad
 */
public class updateDataGuruController {

    public void updateDataGuru(updateDataGuruModel guru) {
        String query = "UPDATE users SET full_name = ?, email = ?, password = ?, guruMapel = ? WHERE nip = ?";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, guru.getFullName());
            preparedStatement.setString(2, guru.getEmail());
            preparedStatement.setString(3, guru.getPassword());
            preparedStatement.setString(4, guru.getGuruMapel());
            preparedStatement.setString(5, guru.getNip());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data guru berhasil diperbarui.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data guru. ID tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memperbarui data guru.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
