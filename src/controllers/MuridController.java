/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.MuridModel;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;
import Guru.Input.InputNilaiSiswa;

/**
 *
 * @author Achmad
 */
public class MuridController {

    private final MuridModel model;
    private int userId;
    private String userName;

    public MuridController(int userId, String userName) {
        this.model = new MuridModel();
        this.userId = userId;
        this.userName = userName;
    }

    public void loadDataSiswa(String gen, String namaKelas, JTable DataSiswaTable) {
        DefaultTableModel tableModel = model.loadDataSiswa(gen, namaKelas);
        DataSiswaTable.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (DataSiswaTable.isEditing()) {
                    DataSiswaTable.getCellEditor().stopCellEditing();
                }

                String nis = tableModel.getValueAt(row, 0).toString();
                InputNilaiSiswa inputNilaiForm = new InputNilaiSiswa(nis, userId, userName);
                inputNilaiForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (DataSiswaTable.isEditing()) {
                    DataSiswaTable.getCellEditor().stopCellEditing();
                }

                String nis = tableModel.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan NIS: " + nis + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    boolean success = model.deleteSiswa(nis);
                    if (success) {
                        ((DefaultTableModel) DataSiswaTable.getModel()).removeRow(row);
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };

        DataSiswaTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        DataSiswaTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }
}
