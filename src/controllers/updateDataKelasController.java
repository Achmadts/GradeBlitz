package controllers;

import models.updateDataKelasModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.util.ArrayList;
import java.util.List;

public class updateDataKelasController {

    // Method to get the 'id' from 'tahun_ajaran' table using 'gen'
    public int getIdFromGen(int gen) {
        String query = "SELECT id FROM tahun_ajaran WHERE gen = ?";
        int id = -1;

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, gen);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id; // Return the 'id' from 'tahun_ajaran'
    }

    // Method to update class data
    public void updateDataKelas(updateDataKelasModel kelas) {
        String query = "UPDATE kelas SET nama_kelas = ?, jurusan = ?, gen_id = (SELECT id FROM tahun_ajaran WHERE tahun_ajaran = ?) WHERE id = ?";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            String namaKelas = kelas.getNamaKelas();
            String jurusan = kelas.getJurusan();
            String tahunAjaran = "2022-2023";  // Misal, tahun ajaran yang diambil

            // Validasi input yang sesuai dengan tipe data
            if (tahunAjaran == null || tahunAjaran.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tahun Ajaran tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            preparedStatement.setString(1, namaKelas);
            preparedStatement.setString(2, jurusan);
            preparedStatement.setString(3, tahunAjaran); // Sesuaikan dengan tipe VARCHAR
            preparedStatement.setInt(4, kelas.getKelasId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data kelas berhasil diperbarui.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data kelas. ID kelas tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memperbarui data kelas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to fetch the list of class names
    public List<String> getKelasList() {
        List<String> kelasList = new ArrayList<>();
        String query = "SELECT nama_kelas FROM kelas";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                kelasList.add(resultSet.getString("nama_kelas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kelasList;
    }

    // Method to fetch the list of majors
    public List<String> getJurusanList() {
        List<String> jurusanList = new ArrayList<>();
        String query = "SELECT jurusan FROM kelas";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                jurusanList.add(resultSet.getString("jurusan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jurusanList;
    }

    // Method to fill a JComboBox with class names and gen_ids
    public void isiComboBoxKelas(javax.swing.JComboBox<String> comboBox) {
        String query = "SELECT nama_kelas, gen_id FROM kelas";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            comboBox.removeAllItems();

            while (resultSet.next()) {
                String namaKelas = resultSet.getString("nama_kelas");
                int genId = resultSet.getInt("gen_id");
                String item = namaKelas + " (" + genId + ")";
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
