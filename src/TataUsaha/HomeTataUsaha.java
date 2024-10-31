package TataUsaha;

import TataUsaha.Input.InputDataGuru;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import TataUsaha.Input.InputDataJadwal;
import TataUsaha.Input.InputDataKelas;
import TataUsaha.Input.InputDataMapel;
import TataUsaha.Input.InputDataSiswa;
import TataUsaha.Input.InputTahunAjaran;
import TataUsaha.Update.UpdateDataJadwal;
import javax.swing.JTable;
import loginandsignup.Login;
import models.TataUsahaModel;
import java.sql.PreparedStatement;
import java.sql.Connection;
import koneksi.koneksi;
import java.sql.SQLException;
import pelaporan.cell.TableActionCellEditor;
import pelaporan.cell.TableActionCellRender;
import pelaporan.cell.TableActionEvent;

public class HomeTataUsaha extends javax.swing.JFrame {

    private int userId;
    private String username;
    private TataUsahaModel tataUsahaModel;

    public HomeTataUsaha(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.tataUsahaModel = new TataUsahaModel(userId);
        initComponents();
        this.user.setText(username);
        String hariDiPilih = comboBoxHari.getSelectedItem().toString();
        loadJadwalData(hariDiPilih);
        comboBoxHari.addActionListener(e -> loadJadwalData(comboBoxHari.getSelectedItem().toString()));
        LogOutBtn.addActionListener(e -> logOut());
    }

    public void loadJadwalData(String hari) {
        DefaultTableModel jadwalModel = tataUsahaModel.getJadwalData(hari);
        jadwalTableTataUsaha.setModel(jadwalModel);

        DefaultTableModel tableModel = tataUsahaModel.getJadwalData(hari);
        jadwalTableTataUsaha.setModel(tableModel);

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int jadwalId = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                String jam = tableModel.getValueAt(row, 1).toString();
                String nip = tableModel.getValueAt(row, 2).toString();
                String mapel = tableModel.getValueAt(row, 4).toString();
                String ruang = tableModel.getValueAt(row, 5).toString();
                String hari = tableModel.getValueAt(row, 6).toString();

                UpdateDataJadwal updateForm = new UpdateDataJadwal(jadwalId, nip, mapel, hari, jam, ruang);
                updateForm.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (jadwalTableTataUsaha.isEditing()) {
                    jadwalTableTataUsaha.getCellEditor().stopCellEditing();
                }

                DefaultTableModel model = (DefaultTableModel) jadwalTableTataUsaha.getModel();
                int jadwalId = Integer.parseInt(model.getValueAt(row, 0).toString());

                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus jadwal dengan ID: " + jadwalId + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String query = "DELETE FROM jadwal_pelajaran WHERE id = ?";

                    try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                        preparedStatement.setInt(1, jadwalId);
                        int affectedRows = preparedStatement.executeUpdate();

                        if (affectedRows > 0) {
                            model.removeRow(row);
                            JOptionPane.showMessageDialog(null, "Jadwal berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Jadwal gagal dihapus dari database.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus jadwal.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        };

        jadwalTableTataUsaha.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        jadwalTableTataUsaha.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
    }

    private void logOut() {
        int response = JOptionPane.showConfirmDialog(this, "Yakin mau Logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }

    public JTable getJadwalTable() {
        return jadwalTableTataUsaha;
    }

    public JComboBox<String> getComboBoxHari() {
        return comboBoxHari;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        String hariDiPilih = comboBoxHari.getSelectedItem().toString();
        loadJadwalData(hariDiPilih);
    }

    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setUser(String name) {
        user.setText(name);
    }

//    public void setRole(String roleText) {
//        role.setText(roleText);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LogOutBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jadwalTableTataUsaha = new javax.swing.JTable();
        user = new java.awt.Label();
        comboBoxHari = new javax.swing.JComboBox<>();
        jMenuBar2 = new javax.swing.JMenuBar();
        input = new javax.swing.JMenu();
        InputDataSiswa = new javax.swing.JMenu();
        InputDataGuru = new javax.swing.JMenu();
        InputDataJadwal = new javax.swing.JMenu();
        InputDataKelas = new javax.swing.JMenu();
        inputDataMapel = new javax.swing.JMenu();
        inputDataTahunAjaran = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        DataGuru = new javax.swing.JMenu();
        DataSiswa = new javax.swing.JMenu();
        DataKelas = new javax.swing.JMenu();
        DataMapel = new javax.swing.JMenu();
        DataTA = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tata Usaha");

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        LogOutBtn.setBackground(new java.awt.Color(0, 102, 102));
        LogOutBtn.setFont(new java.awt.Font("Segoe UI Historic", 1, 13)); // NOI18N
        LogOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogOutBtn.setText("LOGOUT");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        jadwalTableTataUsaha.setBackground(new java.awt.Color(0, 255, 153));
        jadwalTableTataUsaha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JAM KE", "JAM", "NIP", "NAMA", "MAPEL", "RUANG", "HARI", "ACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jadwalTableTataUsaha.setRowHeight(40);
        jScrollPane1.setViewportView(jadwalTableTataUsaha);

        user.setAlignment(java.awt.Label.RIGHT);
        user.setFont(new java.awt.Font("Segoe UI Historic", 1, 13)); // NOI18N
        user.setForeground(new java.awt.Color(0, 0, 0));
        user.setText("Name");

        comboBoxHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SENIN", "SELASA", "RABU", "KAMIS", "JUMAT" }));
        comboBoxHari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHariActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LogOutBtn)
                                .addGap(0, 787, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBoxHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        input.setText("Input");
        input.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                inputMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        input.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputMousePressed(evt);
            }
        });
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        InputDataSiswa.setText("Input Data SIswa");
        InputDataSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputDataSiswaMousePressed(evt);
            }
        });
        input.add(InputDataSiswa);

        InputDataGuru.setText("Input Data Guru");
        InputDataGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputDataGuruMousePressed(evt);
            }
        });
        InputDataGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputDataGuruActionPerformed(evt);
            }
        });
        input.add(InputDataGuru);

        InputDataJadwal.setText("Input Data Jadwal");
        InputDataJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputDataJadwalMousePressed(evt);
            }
        });
        InputDataJadwal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InputDataJadwalKeyPressed(evt);
            }
        });
        input.add(InputDataJadwal);

        InputDataKelas.setText("Input Data Kelas");
        InputDataKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InputDataKelasMousePressed(evt);
            }
        });
        input.add(InputDataKelas);

        inputDataMapel.setText("Input Data Mapel");
        inputDataMapel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputDataMapelMousePressed(evt);
            }
        });
        input.add(inputDataMapel);

        inputDataTahunAjaran.setText("Input Data Tahun Ajaran");
        inputDataTahunAjaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputDataTahunAjaranMousePressed(evt);
            }
        });
        input.add(inputDataTahunAjaran);

        jMenuBar2.add(input);

        jMenu3.setText("Data");

        DataGuru.setText("Data Guru");
        DataGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DataGuruMousePressed(evt);
            }
        });
        DataGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataGuruActionPerformed(evt);
            }
        });
        jMenu3.add(DataGuru);

        DataSiswa.setText("Data Siswa");
        DataSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DataSiswaMousePressed(evt);
            }
        });
        DataSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataSiswaActionPerformed(evt);
            }
        });
        jMenu3.add(DataSiswa);

        DataKelas.setText("Data Kelas");
        DataKelas.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                DataKelasMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        DataKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DataKelasMousePressed(evt);
            }
        });
        DataKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataKelasActionPerformed(evt);
            }
        });
        jMenu3.add(DataKelas);

        DataMapel.setText("Data Mata Pelajaran");
        DataMapel.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                DataMapelMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        DataMapel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DataMapelMousePressed(evt);
            }
        });
        DataMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataMapelActionPerformed(evt);
            }
        });
        jMenu3.add(DataMapel);

        DataTA.setText("Data Tahun Ajaran");
        DataTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DataTAMousePressed(evt);
            }
        });
        DataTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataTAActionPerformed(evt);
            }
        });
        jMenu3.add(DataTA);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        String hariDiPilih = (String) comboBoxHari.getSelectedItem();
     }//GEN-LAST:event_LogOutBtnActionPerformed

    private void comboBoxHariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHariActionPerformed
        String hariDiPilih = (String) comboBoxHari.getSelectedItem();
        loadJadwalData(hariDiPilih);    }//GEN-LAST:event_comboBoxHariActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
//        
    }//GEN-LAST:event_inputActionPerformed

    private void inputMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_inputMenuKeyPressed
//        
    }//GEN-LAST:event_inputMenuKeyPressed

    private void inputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMousePressed

    }//GEN-LAST:event_inputMousePressed

    private void InputDataSiswaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputDataSiswaMousePressed
        String fname = user.getText();
        InputDataSiswa InputDataSiswaFrame = new InputDataSiswa(this, fname, userId);
        InputDataSiswaFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InputDataSiswaMousePressed

    private void InputDataGuruMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputDataGuruMousePressed
        String fname = user.getText();
        InputDataGuru InputDataGuruFrame = new InputDataGuru(this, fname, userId);
        InputDataGuruFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InputDataGuruMousePressed

    private void InputDataJadwalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputDataJadwalMousePressed
//        String fname = user.getText();
        InputDataJadwal InputDataJadwalFrame = new InputDataJadwal();
        InputDataJadwalFrame.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_InputDataJadwalMousePressed

    private void InputDataJadwalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputDataJadwalKeyPressed

    }//GEN-LAST:event_InputDataJadwalKeyPressed

    private void InputDataKelasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputDataKelasMousePressed
        String fname = user.getText();
        InputDataKelas InputDataKelasFrame = new InputDataKelas(this, fname, userId);
        InputDataKelasFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InputDataKelasMousePressed

    private void inputDataMapelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputDataMapelMousePressed
        String fname = user.getText();
        InputDataMapel InputDataMapelFrame = new InputDataMapel(this, fname, userId);
        InputDataMapelFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_inputDataMapelMousePressed

    private void inputDataTahunAjaranMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputDataTahunAjaranMousePressed
        String fname = user.getText();
        InputTahunAjaran InputTahunAjaranFrame = new InputTahunAjaran(this, fname, userId);
        InputTahunAjaranFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_inputDataTahunAjaranMousePressed

    private void DataSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataSiswaActionPerformed

    }//GEN-LAST:event_DataSiswaActionPerformed

    private void DataSiswaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataSiswaMousePressed
        String fname = user.getText();
        DataMurid DataMuridFrame = new DataMurid(this, fname, userId);
        DataMuridFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DataSiswaMousePressed

    private void InputDataGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputDataGuruActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_InputDataGuruActionPerformed

    private void DataGuruMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataGuruMousePressed
        String fname = user.getText();
        DataGuru DataGuruFrame = new DataGuru(this, fname, userId);
        DataGuruFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DataGuruMousePressed

    private void DataGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataGuruActionPerformed

    }//GEN-LAST:event_DataGuruActionPerformed

    private void DataKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataKelasActionPerformed

    private void DataMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataMapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataMapelActionPerformed

    private void DataTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataTAActionPerformed

    private void DataKelasMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_DataKelasMenuKeyPressed

    }//GEN-LAST:event_DataKelasMenuKeyPressed

    private void DataKelasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataKelasMousePressed
        String fname = user.getText();
        DataKelas DataKelasFrame = new DataKelas(this, fname, userId);
        DataKelasFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DataKelasMousePressed

    private void DataMapelMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_DataMapelMenuKeyPressed

    }//GEN-LAST:event_DataMapelMenuKeyPressed

    private void DataMapelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataMapelMousePressed
        String fname = user.getText();
        DataMapel DataMapelFrame = new DataMapel(this, fname, userId);
        DataMapelFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DataMapelMousePressed

    private void DataTAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTAMousePressed
        String fname = user.getText();
        DataTahunAjaran DataTahunAjaranFrame = new DataTahunAjaran(this, fname, userId);
        DataTahunAjaranFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DataTAMousePressed

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
            java.util.logging.Logger.getLogger(HomeTataUsaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeTataUsaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeTataUsaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeTataUsaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new HomeTataUsaha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DataGuru;
    private javax.swing.JMenu DataKelas;
    private javax.swing.JMenu DataMapel;
    private javax.swing.JMenu DataSiswa;
    private javax.swing.JMenu DataTA;
    private javax.swing.JMenu InputDataGuru;
    private javax.swing.JMenu InputDataJadwal;
    private javax.swing.JMenu InputDataKelas;
    private javax.swing.JMenu InputDataSiswa;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JComboBox<String> comboBoxHari;
    private javax.swing.JMenu input;
    private javax.swing.JMenu inputDataMapel;
    private javax.swing.JMenu inputDataTahunAjaran;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jadwalTableTataUsaha;
    private java.awt.Label user;
    // End of variables declaration//GEN-END:variables
}
