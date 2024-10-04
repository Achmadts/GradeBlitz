package controllers;

import models.updateDataJadwalModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;

public class updateDataJadwalController {

    public void updateDataJadwal(updateDataJadwalModel jadwal, String userId, String mapelId) {
        String query = "UPDATE jadwal_pelajaran SET user_id = ?, mapel_id = ?, hari = ?, jam = ?, ruang = ? WHERE id = ?";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, mapelId);
            preparedStatement.setString(3, jadwal.getHari());
            preparedStatement.setString(4, jadwal.getJam());
            preparedStatement.setString(5, jadwal.getRuang());
            preparedStatement.setInt(6, jadwal.getJadwalId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data jadwal berhasil diperbarui.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data jadwal. ID jadwal tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memperbarui data jadwal.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
