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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author Achmad
 */
public class MuridModel {

    private int userId;
    private String gen;
    private String namaKelas;

    public DefaultTableModel loadDataSiswa(String gen, String namaKelas) {
        String query = "SELECT m.nis, m.nama, k.nama_kelas, ta.gen, m.no_wa, m.alamat "
                + "FROM murid m "
                + "JOIN kelas k ON m.kelas_id = k.id "
                + "JOIN tahun_ajaran ta ON k.gen_id = ta.id "
                + "WHERE ta.id = ? AND k.nama_kelas = ?";

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "NIS", "NAMA", "KELAS", "GEN", "NO WA", "ALAMAT", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, gen);
            preparedStatement.setString(2, namaKelas);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String nis = resultSet.getString("nis");
                    String nama = resultSet.getString("nama");
                    String namaKelasResult = resultSet.getString("nama_kelas");
                    String genResult = resultSet.getString("gen");
                    String no_wa = resultSet.getString("no_wa");
                    String alamat = resultSet.getString("alamat");

                    model.addRow(new Object[]{nis, nama, namaKelasResult, genResult, no_wa, alamat, null});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return model;
    }

    public boolean deleteSiswa(String nis) {
        String query = "DELETE FROM murid WHERE nis = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, nis);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
