/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.DataTahunAjaranModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;
import TataUsaha.Update.UpdateDataTahunAjaran;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad
 */
public class DataTahunAjaranController {

    private DataTahunAjaranModel model;
    private int userId;

    public DataTahunAjaranController(int userId) {
        this.model = new DataTahunAjaranModel();
        this.userId = userId;
    }

    public void loadDataTahunAjaran(JTable DataTahunAjaranTable) {
        DefaultTableModel tableModel = model.loadDataTahunAjaran();
        DataTahunAjaranTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String idTA = tableModel.getValueAt(row, 0).toString();
                String tahunAjaran = tableModel.getValueAt(row, 1).toString();
                String gen = tableModel.getValueAt(row, 2).toString();

                UpdateDataTahunAjaran updateDataForm = new UpdateDataTahunAjaran(userId, idTA, tahunAjaran, gen);
                updateDataForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan ID: " + id + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && model.deleteTahunAjaran(id)) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        DataTahunAjaranTable.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        DataTahunAjaranTable.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
    }

    public void searchDataTahunAjaran(String searchText, JTable DataTahunAjaranTable) {
        DefaultTableModel tableModel = model.searchDataTahunAjaran(searchText);
        DataTahunAjaranTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String idTA = tableModel.getValueAt(row, 0).toString();
                String tahunAjaran = tableModel.getValueAt(row, 1).toString();
                String gen = tableModel.getValueAt(row, 2).toString();

                UpdateDataTahunAjaran updateDataForm = new UpdateDataTahunAjaran(userId, idTA, tahunAjaran, gen);
                updateDataForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan ID: " + id + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && model.deleteTahunAjaran(id)) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        DataTahunAjaranTable.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        DataTahunAjaranTable.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
    }
}
