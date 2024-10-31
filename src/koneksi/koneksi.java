package koneksi;

import java.sql.*;

import javax.swing.JOptionPane;

public class koneksi {

    private static Connection KoneksiDatabse;

    public static Connection koneksiDB() throws SQLException {
        try {
            String DB = "jdbc:mysql://localhost:3306/gradeblitz";
            String user = "root";
            String pass = "";
            KoneksiDatabse = DriverManager.getConnection(DB, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return KoneksiDatabse;
    }
}
