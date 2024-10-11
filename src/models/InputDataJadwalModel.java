package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import koneksi.koneksi;

public class InputDataJadwalModel {

    public List<String> getAvailableJam(String selectedHari) {
        String query = "SELECT jam FROM jadwal_pelajaran WHERE hari = ?";
        Set<String> allJam = new HashSet<>(Arrays.asList(
                "08:00 - 08:40", "08:40 - 09:20", "09:35 - 10:15", "10:15 - 10:55",
                "10:55 - 11:35", "11:35 - 12:15", "13:00 - 13:45", "13:45 - 14:30",
                "14:30 - 15:15", "15:15 - 16:00"
        ));

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, selectedHari);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                allJam.remove(resultSet.getString("jam"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data jam", "Error", JOptionPane.ERROR_MESSAGE);
        }

        List<String> sortedJam = new ArrayList<>(allJam);
        Collections.sort(sortedJam);
        return sortedJam;
    }

    public List<String> getGuruList() {
        List<String> guruList = new ArrayList<>();
        String query = "SELECT nip, full_name FROM users WHERE role_id = 2";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String guruId = resultSet.getString("nip");
                String nama = resultSet.getString("full_name");
                guruList.add(guruId + " - " + nama);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data guru", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return guruList;
    }

    public List<String> getMapelList() {
        List<String> mapelList = new ArrayList<>();
        String query = "SELECT id, nama_mapel FROM mapel";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String mapelId = resultSet.getString("id");
                String namaMapel = resultSet.getString("nama_mapel");
                mapelList.add(mapelId + " - " + namaMapel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data Mata Pelajaran", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return mapelList;
    }

    public boolean insertDataJadwal(int guruId, int mapelId, String hari, String jam, String ruang) {
        String query = "INSERT INTO jadwal_pelajaran (user_id, mapel_id, hari, jam, ruang) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, guruId);
            preparedStatement.setInt(2, mapelId);
            preparedStatement.setString(3, hari);
            preparedStatement.setString(4, jam);
            preparedStatement.setString(5, ruang);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
