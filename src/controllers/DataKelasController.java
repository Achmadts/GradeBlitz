package controllers;

import models.DataKelasModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;
import TataUsaha.Update.UpdateDataKelas;
import javax.swing.JOptionPane;

public class DataKelasController {

    private DataKelasModel model;
    private int userId;
    private String userName;

    public DataKelasController(int userId, String userName) {
        this.model = new DataKelasModel();
        this.userId = userId;
        this.userName = this.userName;
    }

    public void loadDataKelas(JTable DataKelasTable) {
        DefaultTableModel tableModel = model.loadDataKelas();
        DataKelasTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int idKelas = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                String namaKelas = tableModel.getValueAt(row, 1).toString();
                String jurusan = tableModel.getValueAt(row, 2).toString();
                int gen = Integer.parseInt(tableModel.getValueAt(row, 3).toString());
                
                UpdateDataKelas updateDataKelasForm = new UpdateDataKelas(idKelas, gen, namaKelas, jurusan, gen);
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

    public void searchDataKelas(String searchText, JTable DataKelasTable) {
        DefaultTableModel tableModel = model.searchKelas(searchText);
        DataKelasTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int idKelas = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                String namaKelas = tableModel.getValueAt(row, 1).toString();
                String jurusan = tableModel.getValueAt(row, 2).toString();
                int gen = Integer.parseInt(tableModel.getValueAt(row, 3).toString());

                UpdateDataKelas updateDataKelasForm = new UpdateDataKelas(idKelas, gen, namaKelas, jurusan, gen);
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
