package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksi;

public class UpdateDataMapelModel {

    public boolean updateDataMapel(String idMapel, String namaMapel) {
        String query = "UPDATE mapel SET nama_mapel = ? WHERE id = ?";
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(2, idMapel);
            preparedStatement.setString(1, namaMapel);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
