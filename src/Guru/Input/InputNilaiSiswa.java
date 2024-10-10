package Guru.Input;

import controllers.InputNilaiSiswaController;
import java.awt.Color;

import javax.swing.*;
import java.sql.Timestamp;

public class InputNilaiSiswa extends javax.swing.JFrame {

    private String nis;
    private String nama;
    private int userId;
    private String userName;
    private InputNilaiSiswaController controller;

    public InputNilaiSiswa(String nis, int userId, String userName) {
        this.nis = nis;
        this.userId = userId;
        this.userName = userName;
        this.controller = new InputNilaiSiswaController();
        initComponents();

        nisSiswa.setText(nis);
        namaGuru.setText(userName != null ? userName : "No Name Provided");

        String guruMapel = controller.getGuruMapel(userId);
        nama_mapel.setText(guruMapel != null ? guruMapel : "Tidak ada data");
    }

    private void insertNilai() {
        String namaMapel = nama_mapel.getText();
        String nilaiSiswa = nilai.getText();

        boolean isSaved = controller.saveNilaiSiswa(nisSiswa.getText(), namaMapel, userId, nilaiSiswa);

        if (isSaved) {
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.", "Success", JOptionPane.INFORMATION_MESSAGE);
            nisSiswa.setText("");
            nama_mapel.setText("");
            namaGuru.setText("");
            nilai.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnKirimDataJadwal2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        nilai = new javax.swing.JTextField();
        nisSiswa = new javax.swing.JTextField();
        nama_mapel = new javax.swing.JTextField();
        namaGuru = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INPUT NILAI SISWA");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel3.setName(""); // NOI18N
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 51, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("INPUT NILAI SISWA");

        jLabel14.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("NIS & NAMA SISWA");

        jLabel15.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("MATA PELAJARAN");

        jLabel16.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("NAMA GURU");

        btnKirimDataJadwal2.setBackground(new java.awt.Color(204, 51, 255));
        btnKirimDataJadwal2.setForeground(new java.awt.Color(255, 255, 255));
        btnKirimDataJadwal2.setText("SUBMIT");
        btnKirimDataJadwal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimDataJadwal2ActionPerformed(evt);
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

        jLabel19.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("NILAI");

        nilai.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        nilai.setForeground(new java.awt.Color(153, 153, 153));
        nilai.setText("Contoh: 100, 90, 80");
        nilai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nilaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nilaiFocusLost(evt);
            }
        });
        nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilaiActionPerformed(evt);
            }
        });
        nilai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nilaiKeyTyped(evt);
            }
        });

        nisSiswa.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        nisSiswa.setForeground(new java.awt.Color(153, 153, 153));
        nisSiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nisSiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nisSiswaFocusLost(evt);
            }
        });
        nisSiswa.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                nisSiswaComponentShown(evt);
            }
        });
        nisSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisSiswaActionPerformed(evt);
            }
        });

        nama_mapel.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        nama_mapel.setForeground(new java.awt.Color(153, 153, 153));
        nama_mapel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nama_mapelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nama_mapelFocusLost(evt);
            }
        });
        nama_mapel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                nama_mapelComponentShown(evt);
            }
        });
        nama_mapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_mapelActionPerformed(evt);
            }
        });

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
        namaGuru.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                namaGuruComponentShown(evt);
            }
        });
        namaGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaGuruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nilai, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                            .addComponent(nisSiswa)
                            .addComponent(nama_mapel)
                            .addComponent(namaGuru)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnKirimDataJadwal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(nisSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nama_mapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(namaGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirimDataJadwal2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKirimDataJadwal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimDataJadwal2ActionPerformed
        insertNilai();
    }//GEN-LAST:event_btnKirimDataJadwal2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilaiActionPerformed

    }//GEN-LAST:event_nilaiActionPerformed

    private void nisSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisSiswaActionPerformed
        nisSiswa.setEditable(false);
    }//GEN-LAST:event_nisSiswaActionPerformed

    private void nisSiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nisSiswaFocusGained
        if (nisSiswa.getText().equals("Contoh: 22231755")) {
            nisSiswa.setText("");
            nisSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nisSiswaFocusGained

    private void nisSiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nisSiswaFocusLost
        if (nisSiswa.getText().equals("")) {
            nisSiswa.setText("Contoh: 22231755");
            nisSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nisSiswaFocusLost

    private void nisSiswaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_nisSiswaComponentShown
    }//GEN-LAST:event_nisSiswaComponentShown

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown

    }//GEN-LAST:event_jPanel3ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        nisSiswa.setEditable(false);
        nama_mapel.setEditable(false);
        namaGuru.setEditable(false);
    }//GEN-LAST:event_formComponentShown

    private void nama_mapelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nama_mapelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mapelFocusGained

    private void nama_mapelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nama_mapelFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mapelFocusLost

    private void nama_mapelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_nama_mapelComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mapelComponentShown

    private void nama_mapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_mapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_mapelActionPerformed

    private void namaGuruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaGuruFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_namaGuruFocusGained

    private void namaGuruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaGuruFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_namaGuruFocusLost

    private void namaGuruComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_namaGuruComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_namaGuruComponentShown

    private void namaGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaGuruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaGuruActionPerformed

    private void nilaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nilaiFocusGained
        if (nilai.getText().equals("Contoh: 100, 90, 80")) {
            nilai.setText("");
            nilai.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nilaiFocusGained

    private void nilaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nilaiFocusLost
        if (nilai.getText().equals("")) {
            nilai.setText("Contoh: 100, 90, 80");
            nilai.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nilaiFocusLost

    private void nilaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nilaiKeyTyped
        char c = evt.getKeyChar();
        String currentText = nilai.getText();
        if (!Character.isDigit(c)) {
            evt.consume();
            return;
        }
        String newText = currentText + c;
        try {
            int newValue = Integer.parseInt(newText);
            if (newValue > 100) {
                evt.consume();
            }

        } catch (NumberFormatException e) {
            evt.consume();
        }
        if (currentText.length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_nilaiKeyTyped

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
            java.util.logging.Logger.getLogger(InputNilaiSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputNilaiSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputNilaiSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputNilaiSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new InputNilaiSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnKirimDataJadwal2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField namaGuru;
    private javax.swing.JTextField nama_mapel;
    private javax.swing.JTextField nilai;
    private javax.swing.JTextField nisSiswa;
    // End of variables declaration//GEN-END:variables
}
