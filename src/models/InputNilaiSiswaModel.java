package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import koneksi.koneksi;

public class InputNilaiSiswaModel {

    public String getGuruMapel(int userId) {
        String guruMapel = null;
        String queryMapel = "SELECT guruMapel FROM users WHERE nip = ?";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatementMapel = conn.prepareStatement(queryMapel)) {
            preparedStatementMapel.setInt(1, userId);
            ResultSet resultSetMapel = preparedStatementMapel.executeQuery();

            if (resultSetMapel.next()) {
                guruMapel = resultSetMapel.getString("guruMapel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guruMapel;
    }

    public int getMapelId(String namaMapel) {
        String query = "SELECT id FROM mapel WHERE nama_mapel = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaMapel);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean insertNilai(String nisSiswa, int mapelId, int userId, String nilai) {
        String selectQuery = "SELECT murid_id FROM nilai WHERE murid_id = ? AND mapel_id = ?";
        String insertQuery = "INSERT INTO nilai (murid_id, mapel_id, user_id, nilai, tanggal) VALUES (?, ?, ?, ?, ?)";
        String updateQuery = "UPDATE nilai SET user_id = ?, nilai = ?, tanggal = ? WHERE murid_id = ? AND mapel_id = ?";

        try (Connection conn = koneksi.koneksiDB()) {
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setInt(1, Integer.parseInt(nisSiswa));
            selectStmt.setInt(2, mapelId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Nilai untuk siswa dengan id '" + nisSiswa + "' sudah ada, apakah Anda ingin mengupdate nilai siswa tersebut?",
                        "Konfirmasi Update",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setInt(1, userId);
                        updateStmt.setString(2, nilai);
                        updateStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                        updateStmt.setInt(4, Integer.parseInt(nisSiswa));
                        updateStmt.setInt(5, mapelId);

                        int rowsUpdated = updateStmt.executeUpdate();
                        return rowsUpdated > 0;
                    }
                } else {
                    return false;
                }
            } else {
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, Integer.parseInt(nisSiswa));
                    insertStmt.setInt(2, mapelId);
                    insertStmt.setInt(3, userId);
                    insertStmt.setString(4, nilai);
                    insertStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

                    int rowsInserted = insertStmt.executeUpdate();
                    return rowsInserted > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
