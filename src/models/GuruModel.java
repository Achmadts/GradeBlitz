/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import koneksi.koneksi;

/**
 *
 * @author Achmad
 */
public class GuruModel {

    private int userId;

    public GuruModel(int userId) {
        this.userId = userId;
    }

    public DefaultTableModel getJadwalData(String hari) {
        String query = "SELECT jp.id, u.full_name, m.nama_mapel, jp.hari, jp.jam, jp.ruang, jp.user_id "
                + "FROM jadwal_pelajaran jp "
                + "JOIN users u ON jp.user_id = u.nip "
                + "JOIN mapel m ON jp.mapel_id = m.id "
                + "WHERE jp.hari = ? "
                + "ORDER BY jp.jam ASC";

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "JAM KE", "JAM", "MAPEL", "NAMA GURU", "RUANG", "NIP"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, hari);
            ResultSet resultSet = preparedStatement.executeQuery();

            int jamKe = 1;
            while (resultSet.next() && jamKe <= 10) {
                String jam = resultSet.getString("jam");
                String namaMapel = resultSet.getString("nama_mapel");
                String fullName = resultSet.getString("full_name");
                String ruang = resultSet.getString("ruang");
                int rowUserId = resultSet.getInt("user_id");

                model.addRow(new Object[]{jamKe, jam, namaMapel, fullName, ruang, rowUserId});
                jamKe++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }

    public void setJadwalTableRenderer(JTable jadwalTable, DefaultTableModel model) {
        jadwalTable.setModel(model);

        jadwalTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int rowUserId = (int) model.getValueAt(row, 5);

                if (rowUserId == userId) {
                    c.setBackground(new Color(204, 51, 255));
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }

                return c;
            }
        });
        jadwalTable.getColumnModel().removeColumn(jadwalTable.getColumnModel().getColumn(5));
    }
}
