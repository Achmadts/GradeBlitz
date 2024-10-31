/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TataUsaha;

import controllers.DataTahunAjaranController;
import java.awt.Color;

/**
 *
 * @author Achmad
 */
public class DataTahunAjaran extends javax.swing.JFrame {

    /**
     * Creates new form DataTahunAjaran
     */
    private DataTahunAjaranController controller;
    private HomeTataUsaha homeFrame;

    public DataTahunAjaran(HomeTataUsaha homeFrame, String userName, int userId) {
        initComponents();
        this.homeFrame = homeFrame;
        this.controller = new DataTahunAjaranController(userId);
        user.setText(userName);
        controller.loadDataTahunAjaran(DataTahunAjaranTable);
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
        DataTahunAjaranTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        user = new java.awt.Label();
        searchDataTA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        DataTahunAjaranTable.setBackground(new java.awt.Color(0, 255, 153));
        DataTahunAjaranTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TAHUN AJARAN", "GEN", "ACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTahunAjaranTable.setRowHeight(40);
        DataTahunAjaranTable.setSelectionBackground(new java.awt.Color(187, 187, 187));
        jScrollPane1.setViewportView(DataTahunAjaranTable);

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        user.setAlignment(java.awt.Label.RIGHT);
        user.setFont(new java.awt.Font("Segoe UI Historic", 1, 13)); // NOI18N
        user.setForeground(new java.awt.Color(0, 0, 0));
        user.setText("Name");

        searchDataTA.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        searchDataTA.setText("Cari Tahun Ajaran");
        searchDataTA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchDataTAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchDataTAFocusLost(evt);
            }
        });
        searchDataTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchDataTAKeyReleased(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchDataTA, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(searchDataTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        String hariDipilih = homeFrame.getComboBoxHari().getSelectedItem().toString();
        homeFrame.setVisible(true);
        homeFrame.loadJadwalData(hariDipilih);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void searchDataTAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchDataTAFocusGained
        if (searchDataTA.getText().equals("Cari Tahun Ajaran")) {
            searchDataTA.setText("");
            searchDataTA.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchDataTAFocusGained

    private void searchDataTAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchDataTAFocusLost
        if (searchDataTA.getText().equals("")) {
            searchDataTA.setText("Cari Tahun Ajaran");
            searchDataTA.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchDataTAFocusLost

    private void searchDataTAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchDataTAKeyReleased
        String searchText = searchDataTA.getText();
        controller.searchDataTahunAjaran(searchText, DataTahunAjaranTable);
    }//GEN-LAST:event_searchDataTAKeyReleased

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
            java.util.logging.Logger.getLogger(DataTahunAjaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataTahunAjaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataTahunAjaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataTahunAjaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int userId = 1;
                String username = "NamaPenggunaTest";
                HomeTataUsaha homeFrame = new HomeTataUsaha(userId, username);
                new DataTahunAjaran(homeFrame, username, userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataTahunAjaranTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchDataTA;
    private java.awt.Label user;
    // End of variables declaration//GEN-END:variables
}
