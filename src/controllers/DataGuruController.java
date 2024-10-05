/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.DataGuruModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;
import TataUsaha.Update.UpdateDataGuru;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.koneksi;

/**
 *
 * @author Achmad
 */
public class DataGuruController {

    private DataGuruModel model;
    private int userId;
    private String userName;

    public DataGuruController(int userId, String userName) {
        this.model = new DataGuruModel();
        this.userId = userId;
        this.userName = userName;
    }

    public void loadDataGuru(JTable DataGuruTable) {
        DefaultTableModel tableModel = model.loadDataGuru();
        DataGuruTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String nip = tableModel.getValueAt(row, 0).toString();
                String fullName = tableModel.getValueAt(row, 1).toString();
                String email_guru = tableModel.getValueAt(row, 2).toString();
                String password = tableModel.getValueAt(row, 3).toString();
                String mapel_guru = tableModel.getValueAt(row, 4).toString();

                UpdateDataGuru updateDataGuruForm = new UpdateDataGuru(nip, userId, fullName, email_guru, password, mapel_guru);
                updateDataGuruForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String nip = tableModel.getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Apakah Anda yakin ingin menghapus data Guru dengan NIP: " + nip + "?",
                        "Konfirmasi Penghapusan",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (model.deleteGuru(nip)) {
                        tableModel.removeRow(row);
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        };

        DataGuruTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        DataGuruTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }

    public void searchDataGuru(String searchText, JTable DataGuruTable) {
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "NIP", "NAMA GURU", "EMAIL", "PASSWORD", "MAPEL", "ACTION"
        }, 0);

        String query = "SELECT nip, full_name, email, password, guruMapel FROM users WHERE role_id = 2 AND (nip LIKE ? OR full_name LIKE ?)";

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + searchText + "%");
            pstmt.setString(2, "%" + searchText + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    String nip = resultSet.getString("nip");
                    String fullName = resultSet.getString("full_name");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String guruMapel = resultSet.getString("guruMapel");

                    model.addRow(new Object[]{nip, fullName, email, password, guruMapel});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        DataGuruTable.setModel(model);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String nip = model.getValueAt(row, 0).toString();
                String fullName = model.getValueAt(row, 1).toString();
                String email_guru = model.getValueAt(row, 2).toString();
                String password = model.getValueAt(row, 3).toString();
                String mapel_guru = model.getValueAt(row, 4).toString();

                UpdateDataGuru updateDataGuruForm = new UpdateDataGuru(nip, userId, fullName, email_guru, password, mapel_guru);
                updateDataGuruForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (DataGuruTable.isEditing()) {
                    DataGuruTable.getCellEditor().stopCellEditing();
                }

                DefaultTableModel model = (DefaultTableModel) DataGuruTable.getModel();
                String nip = model.getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data guru dengan NIP: " + nip + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String query = "DELETE FROM users WHERE nip = ? AND role_id = 2";

                    try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                        preparedStatement.setString(1, nip);
                        int affectedRows = preparedStatement.executeUpdate();

                        if (affectedRows > 0) {
                            model.removeRow(row);
                            JOptionPane.showMessageDialog(null, "Data guru berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data guru gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data guru.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };

        DataGuruTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        DataGuruTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
}
