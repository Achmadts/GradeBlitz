/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TataUsaha;

import TataUsaha.Update.UpdateDataSiswa;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.table.TableRowSorter;
import koneksi.koneksi;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;

/**
 *
 * @author Achmad
 */
public class DataMurid extends javax.swing.JFrame {

    /**
     * Creates new form DataSiswa
     */
    private HomeTataUsaha homeFrame;
    private String gen;
    private String namaKelas;

    public DataMurid(HomeTataUsaha homeFrame, String userName, int userId) {
        initComponents();
        this.homeFrame = homeFrame;
        this.userName = userName;
        this.userId = userId;
        user.setText(userName);
        this.gen = "";
        this.namaKelas = "";
        loadDataSiswa();
    }

    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    //    BARU 1
    private int userId;
    private String userName;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void loadDataSiswa() {
        String query = "SELECT m.nis, m.nama, k.nama_kelas, ta.gen, m.no_wa, m.alamat "
                + "FROM murid m "
                + "JOIN kelas k ON m.kelas_id = k.id "
                + "JOIN tahun_ajaran ta ON k.gen_id = ta.id";

        DefaultTableModel model = new DefaultTableModel(new String[]{
            "NIS", "NAMA", "KELAS", "GEN", "NO WA", "ALAMAT", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String nis = resultSet.getString("nis");
                    String nama = resultSet.getString("nama");
                    String namaKelas = resultSet.getString("nama_kelas");
                    String gen = resultSet.getString("gen");
                    String no_wa = resultSet.getString("no_wa");
                    String alamat = resultSet.getString("alamat");

                    model.addRow(new Object[]{nis, nama, namaKelas, gen, no_wa, alamat, null});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        DataSiswaTable.setModel(model);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (DataSiswaTable.isEditing()) {
                    DataSiswaTable.getCellEditor().stopCellEditing();
                }

                String nis = model.getValueAt(row, 0).toString();
//            System.out.println("Debug: userId saat onEdit: " + userId);

                UpdateDataSiswa UpdateDataSiswaForm = new UpdateDataSiswa(nis, userId, userName);
                UpdateDataSiswaForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (DataSiswaTable.isEditing()) {
                    DataSiswaTable.getCellEditor().stopCellEditing();
                }

                DefaultTableModel model = (DefaultTableModel) DataSiswaTable.getModel();
                String nis = model.getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan NIS: " + nis + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String deleteRelatedQuery = "DELETE FROM hasil_pelaporan WHERE murid_id = ?";
                    String deleteQuery = "DELETE FROM murid WHERE nis = ?";

                    try (Connection conn = koneksi.koneksiDB()) {
                        // Hapus data terkait di tabel hasil_pelaporan
                        try (PreparedStatement deleteRelatedStmt = conn.prepareStatement(deleteRelatedQuery)) {
                            deleteRelatedStmt.setString(1, nis);
                            deleteRelatedStmt.executeUpdate();
                        }

                        // Hapus data dari tabel murid
                        try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
                            preparedStatement.setString(1, nis);
                            int affectedRows = preparedStatement.executeUpdate();

                            if (affectedRows > 0) {
                                model.removeRow(row);
                                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Data gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLIntegrityConstraintViolationException e) {
                        JOptionPane.showMessageDialog(null, "Data tidak dapat dihapus karena ada referensi di tabel lain.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };

        DataSiswaTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        DataSiswaTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataSiswaTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        user = new java.awt.Label();
        searchDataSiswa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DataSiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "NAMA", "KELAS", "GEN", "NO WA", "ALAMAT", "ACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataSiswaTable.setRowHeight(40);
        DataSiswaTable.setSelectionBackground(new java.awt.Color(187, 187, 187));
        jScrollPane1.setViewportView(DataSiswaTable);

        btnBack.setBackground(new java.awt.Color(204, 51, 255));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        user.setAlignment(java.awt.Label.RIGHT);
        user.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        user.setForeground(new java.awt.Color(204, 51, 255));
        user.setText("Name");

        searchDataSiswa.setText("Cari Nama atau NIS siswa");
        searchDataSiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchDataSiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchDataSiswaFocusLost(evt);
            }
        });
        searchDataSiswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchDataSiswaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        HomeTataUsaha HomeTataUsahaFrame = new HomeTataUsaha();
        HomeTataUsahaFrame.setVisible(true);
        HomeTataUsahaFrame.pack();
        HomeTataUsahaFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void searchDataSiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchDataSiswaFocusGained
        if (searchDataSiswa.getText().equals("Cari Nama atau NIS siswa")) {
            searchDataSiswa.setText("");
            searchDataSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchDataSiswaFocusGained

    private void searchDataSiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchDataSiswaFocusLost
        if (searchDataSiswa.getText().equals("")) {
            searchDataSiswa.setText("Cari Nama atau NIS siswa");
            searchDataSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchDataSiswaFocusLost

    private void searchDataSiswaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDataSiswaKeyReleased
        String searchText = searchDataSiswa.getText();

        String query = "SELECT m.nis, m.nama, k.nama_kelas, ta.gen, m.no_wa, m.alamat "
                + "FROM murid m "
                + "JOIN kelas k ON m.kelas_id = k.id "
                + "JOIN tahun_ajaran ta ON k.gen_id = ta.id "
                + "WHERE (m.nis LIKE ? OR m.nama LIKE ?)";

        // Buat model tabel
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "NIS", "NAMA", "KELAS", "GEN", "NO WA", "ALAMAT", "ACTION"
        }, 0);

        try (Connection conn = koneksi.koneksiDB(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + searchText + "%");
            pstmt.setString(2, "%" + searchText + "%");

            try (ResultSet resultSet = pstmt.executeQuery()) {

                model.setRowCount(0);

                while (resultSet.next()) {
                    String nis = resultSet.getString("nis");
                    String nama = resultSet.getString("nama");
                    String namaKelas = resultSet.getString("nama_kelas");
                    String gen = resultSet.getString("gen");
                    String no_wa = resultSet.getString("no_wa");
                    String alamat = resultSet.getString("alamat");

                    model.addRow(new Object[]{nis, nama, namaKelas, gen, no_wa, alamat});
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Data gagal dimuat", "Error", JOptionPane.ERROR_MESSAGE);
        }

        DataSiswaTable.setModel(model);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if (DataSiswaTable.isEditing()) {
                    DataSiswaTable.getCellEditor().stopCellEditing();
                }

                String nis = model.getValueAt(row, 0).toString();
                String nama = model.getValueAt(row, 1).toString();
                String namaKelas = model.getValueAt(row, 2).toString();
                String gen = model.getValueAt(row, 3).toString();
                String no_wa = model.getValueAt(row, 4).toString();
                String alamat = model.getValueAt(row, 5).toString();

                UpdateDataSiswa UpdateDataSiswaForm = new UpdateDataSiswa(nis, userId, userName);
                UpdateDataSiswaForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (DataSiswaTable.isEditing()) {
                    DataSiswaTable.getCellEditor().stopCellEditing();
                }

                DefaultTableModel model = (DefaultTableModel) DataSiswaTable.getModel();
                String nis = model.getValueAt(row, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data dengan NIS: " + nis + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String query = "DELETE FROM murid WHERE nis = ?";

                    try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                        preparedStatement.setString(1, nis);
                        int affectedRows = preparedStatement.executeUpdate();

                        if (affectedRows > 0) {
                            model.removeRow(row);
                            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Data gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };

        DataSiswaTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        DataSiswaTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }//GEN-LAST:event_searchDataSiswaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataMurid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMurid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMurid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMurid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeTataUsaha homeFrame = new HomeTataUsaha();
                String userName = "NamaPenggunaTest";
                int userId = 1;
                new DataMurid(homeFrame, userName, userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataSiswaTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchDataSiswa;
    private java.awt.Label user;
    // End of variables declaration//GEN-END:variables
}
