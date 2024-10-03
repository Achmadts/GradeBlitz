/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TataUsaha.Update;

import controllers.updateDataGuruController;
import models.updateDataGuruModel;

/**
 *
 * @author Achmad
 */
public class UpdateDataGuru extends javax.swing.JFrame {

    private updateDataGuruController controller;
    private updateDataGuruModel guru;

    public UpdateDataGuru(String nip, int userId, String full_name, String email, String password, String guruMapel) {
        guru = new updateDataGuruModel(nip, full_name, email, password, guruMapel);
        controller = new updateDataGuruController();
        initComponents();

        nipGuru.setText(nip);
        namaGuru.setText(full_name);
        emailGuru.setText(email);
        passwordGuru.setText(password);
        mapelGuru.setSelectedItem(guruMapel);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nipGuru = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        namaGuru = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailGuru = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordGuru = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        mapelGuru = new javax.swing.JComboBox<>();
        btnKirimDataGuru = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UPDATE DATA GURU");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("UPDATE DATA GURU");

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NIP");

        nipGuru.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        nipGuru.setForeground(new java.awt.Color(153, 153, 153));
        nipGuru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nipGuruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nipGuruFocusLost(evt);
            }
        });
        nipGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nipGuruActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NAMA");

        namaGuru.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        namaGuru.setForeground(new java.awt.Color(153, 153, 153));
        namaGuru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namaGuruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaGuruFocusLost(evt);
            }
        });
        namaGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaGuruActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("EMAIL");

        emailGuru.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        emailGuru.setForeground(new java.awt.Color(153, 153, 153));
        emailGuru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailGuruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailGuruFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("PASSWORD");

        passwordGuru.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        passwordGuru.setForeground(new java.awt.Color(153, 153, 153));
        passwordGuru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordGuruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordGuruFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("GURU MAPEL");

        mapelGuru.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        mapelGuru.setForeground(new java.awt.Color(153, 153, 153));
        mapelGuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PBT", "PPB", "PWB", "BSD" }));

        btnKirimDataGuru.setBackground(new java.awt.Color(204, 51, 255));
        btnKirimDataGuru.setForeground(new java.awt.Color(255, 255, 255));
        btnKirimDataGuru.setText("SUBMIT");
        btnKirimDataGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimDataGuruActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(204, 51, 255));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nipGuru, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namaGuru, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailGuru, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordGuru, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mapelGuru, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnKirimDataGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack)
                                .addGap(0, 199, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nipGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(namaGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailGuru, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapelGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirimDataGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void namaGuruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaGuruFocusGained

    }//GEN-LAST:event_namaGuruFocusGained

    private void namaGuruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaGuruFocusLost

    }//GEN-LAST:event_namaGuruFocusLost

    private void namaGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaGuruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaGuruActionPerformed

    private void emailGuruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailGuruFocusGained

    }//GEN-LAST:event_emailGuruFocusGained

    private void emailGuruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailGuruFocusLost

    }//GEN-LAST:event_emailGuruFocusLost

    private void passwordGuruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordGuruFocusGained

    }//GEN-LAST:event_passwordGuruFocusGained

    private void passwordGuruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordGuruFocusLost

    }//GEN-LAST:event_passwordGuruFocusLost

    private void btnKirimDataGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimDataGuruActionPerformed
        guru.setFullName(namaGuru.getText());
        guru.setEmail(emailGuru.getText());
        guru.setPassword(passwordGuru.getText());
        guru.setGuruMapel((String) mapelGuru.getSelectedItem());

        controller.updateDataGuru(guru);    }//GEN-LAST:event_btnKirimDataGuruActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
     }//GEN-LAST:event_btnBackActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        nipGuru.setEditable(false);
    }//GEN-LAST:event_formComponentShown

    private void nipGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nipGuruActionPerformed
        //
    }//GEN-LAST:event_nipGuruActionPerformed

    private void nipGuruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nipGuruFocusLost

    }//GEN-LAST:event_nipGuruFocusLost

    private void nipGuruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nipGuruFocusGained

    }//GEN-LAST:event_nipGuruFocusGained

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
            java.util.logging.Logger.getLogger(UpdateDataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new UpdateDataGuru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnKirimDataGuru;
    private javax.swing.JTextField emailGuru;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> mapelGuru;
    private javax.swing.JTextField namaGuru;
    private javax.swing.JTextField nipGuru;
    private javax.swing.JPasswordField passwordGuru;
    // End of variables declaration//GEN-END:variables
}
