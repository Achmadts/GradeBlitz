package controllers;

import TataUsaha.Update.UpdateDataSiswa;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.sql.PreparedStatement;
import models.MuridModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;

public class MuridController {

    private final MuridModel model;
    private int userId;
    private String userName;

    public MuridController(int userId, String userName) {
        this.model = new MuridModel();
        this.userId = userId;
        this.userName = userName;
    }

    public void loadDataMurid(String gen, String namaKelas, JTable DataMuridTable) {
        DefaultTableModel tableModel = model.loadDataMurid();
        DataMuridTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (DataMuridTable.isEditing()) {
                    DataMuridTable.getCellEditor().stopCellEditing();
                }

                String nis = tableModel.getValueAt(row, 0).toString();
                UpdateDataSiswa UpdateDataSiswaForm = new UpdateDataSiswa(nis, userId, userName);
                UpdateDataSiswaForm.setVisible(true);                
            }

            @Override
            public void onDelete(int row) {
                if (DataMuridTable.isEditing()) {
                    DataMuridTable.getCellEditor().stopCellEditing();
                }

                String nis = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan NIS: " + nis + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    boolean success = model.deleteSiswa(nis);
                    if (success) {
                        ((DefaultTableModel) DataMuridTable.getModel()).removeRow(row);
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };

        DataMuridTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        DataMuridTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }
}
