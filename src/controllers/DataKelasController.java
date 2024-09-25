/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.DataKelasModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;
import TataUsaha.Update.UpdateDataKelas;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad
 */
public class DataKelasController {

    private DataKelasModel model;
    private int userId;

    public DataKelasController(int userId) {
        this.model = new DataKelasModel();
        this.userId = userId;
    }

    public void loadDataKelas(JTable DataKelasTable) {
        DefaultTableModel tableModel = model.loadDataKelas();
        DataKelasTable.setModel(tableModel);

        // Add table actions (edit and delete)
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int idKelas = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                String namaKelas = tableModel.getValueAt(row, 1).toString();
                String jurusan = tableModel.getValueAt(row, 2).toString();
                String gen = tableModel.getValueAt(row, 3).toString();

                UpdateDataKelas updateDataKelasForm = new UpdateDataKelas(userId, idKelas, namaKelas, jurusan, gen);
                updateDataKelasForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan id: " + id + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && model.deleteKelas(id)) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        DataKelasTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        DataKelasTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }

    // Search for kelas data based on searchText and set to table
    public void searchDataKelas(String searchText, JTable DataKelasTable) {
        DefaultTableModel tableModel = model.searchKelas(searchText);
        DataKelasTable.setModel(tableModel);

        // Add table actions (edit and delete)
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int idKelas = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                String namaKelas = tableModel.getValueAt(row, 1).toString();
                String jurusan = tableModel.getValueAt(row, 2).toString();
                String gen = tableModel.getValueAt(row, 3).toString();

                UpdateDataKelas updateDataKelasForm = new UpdateDataKelas(userId, idKelas, namaKelas, jurusan, gen);
                updateDataKelasForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan id: " + id + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && model.deleteKelas(id)) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        DataKelasTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        DataKelasTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }
}
