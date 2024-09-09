/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 *
 * @author Achmad
 */
public class koneksi {

    private static Connection KoneksiDatabse;

    public static Connection koneksiDB() throws SQLException {
        try {
            String DB = "jdbc:mysql://localhost:3306/pelaporan_hasil_belajar_siswa";
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
