/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.DataMapelModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;
import TataUsaha.Update.UpdateDataMapel;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad
 */
public class DataMapelController {

    private DataMapelModel model;
    private int userId;

    public DataMapelController(int userId) {
        this.model = new DataMapelModel();
        this.userId = userId;
    }

    public void loadDataMapel(JTable DataMapelTable) {
        DefaultTableModel tableModel = model.loadDataMapel();
        DataMapelTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String idMapel = tableModel.getValueAt(row, 0).toString();
                String namaMapel = tableModel.getValueAt(row, 1).toString();

                UpdateDataMapel updateDataMapelForm = new UpdateDataMapel(userId, idMapel, namaMapel);
                updateDataMapelForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan ID: " + id + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && model.deleteMapel(id)) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        DataMapelTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        DataMapelTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(event));
    }

    public void searchMapel(String searchText, JTable DataMapelTable) {
        DefaultTableModel tableModel = model.searchMapel(searchText);
        DataMapelTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String idMapel = tableModel.getValueAt(row, 0).toString();
                String namaMapel = tableModel.getValueAt(row, 1).toString();

                UpdateDataMapel updateDataMapelForm = new UpdateDataMapel(userId, idMapel, namaMapel);
                updateDataMapelForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan ID: " + id + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && model.deleteMapel(id)) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        DataMapelTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        DataMapelTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(event));
    }
}
