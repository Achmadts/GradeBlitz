/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TataUsaha.Input;

import TataUsaha.HomeTataUsaha;
import koneksi.koneksi;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad
 */
public class InputDataSiswa extends javax.swing.JFrame {

    /**
     * Creates new form InputDataSiswa
     */
    private HomeTataUsaha homeFrame;

    public InputDataSiswa(HomeTataUsaha homeFrame, String userName, int userId) {
        initComponents();
        this.homeFrame = homeFrame;
        this.userName = userName;
        this.userId = userId;
        user.setText(userName);
        loadComboBoxes();
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

    private void loadComboBoxes() {
        loadKelasComboBox();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nisSiswa = new javax.swing.JTextField();
        noWaSiswa = new javax.swing.JTextField();
        namaSIswa = new javax.swing.JTextField();
        kelasSiswa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatSiswa = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        btnKirimDataSiswa = new javax.swing.JButton();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INPUT DATA SISWA");

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT DATA SISWA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel2.setText("NIS");

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel4.setText("KELAS");

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel6.setText("NO WA");

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel7.setText("ALAMAT");

        nisSiswa.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        nisSiswa.setForeground(new java.awt.Color(153, 153, 153));
        nisSiswa.setText("Masukkan NIS Siswa");
        nisSiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nisSiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nisSiswaFocusLost(evt);
            }
        });

        noWaSiswa.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        noWaSiswa.setForeground(new java.awt.Color(153, 153, 153));
        noWaSiswa.setText("Masukkan no wa siswa");
        noWaSiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noWaSiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noWaSiswaFocusLost(evt);
            }
        });
        noWaSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noWaSiswaActionPerformed(evt);
            }
        });

        namaSIswa.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        namaSIswa.setForeground(new java.awt.Color(153, 153, 153));
        namaSIswa.setText("Masukkan Nama Siswa");
        namaSIswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namaSIswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaSIswaFocusLost(evt);
            }
        });

        kelasSiswa.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        kelasSiswa.setForeground(new java.awt.Color(153, 153, 153));
        kelasSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasSiswaActionPerformed(evt);
            }
        });

        alamatSiswa.setColumns(20);
        alamatSiswa.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        alamatSiswa.setForeground(new java.awt.Color(153, 153, 153));
        alamatSiswa.setRows(5);
        alamatSiswa.setText("Masukkan Alamat Siswa");
        alamatSiswa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamatSiswaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                alamatSiswaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(alamatSiswa);

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnKirimDataSiswa.setBackground(new java.awt.Color(0, 102, 102));
        btnKirimDataSiswa.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        btnKirimDataSiswa.setForeground(new java.awt.Color(255, 255, 255));
        btnKirimDataSiswa.setText("SUBMIT");
        btnKirimDataSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimDataSiswaActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        user.setText("name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnKirimDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(kelasSiswa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(namaSIswa, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                    .addComponent(nisSiswa, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(noWaSiswa, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(80, 80, 80)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(user)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nisSiswa)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaSIswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kelasSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noWaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirimDataSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void alamatSiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatSiswaFocusLost
        if (alamatSiswa.getText().equals("")) {
            alamatSiswa.setText("Masukkan Alamat Siswa");
            alamatSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_alamatSiswaFocusLost

    private void alamatSiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatSiswaFocusGained
        if (alamatSiswa.getText().equals("Masukkan Alamat Siswa")) {
            alamatSiswa.setText("");
            alamatSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_alamatSiswaFocusGained

    private void kelasSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasSiswaActionPerformed
        String selectedKelas = (String) kelasSiswa.getSelectedItem();
        if (selectedKelas != null) {
            String[] parts = selectedKelas.split(" - ");
            String kelasId = parts[0];
        }
    }//GEN-LAST:event_kelasSiswaActionPerformed

    private void namaSIswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaSIswaFocusLost
        if (namaSIswa.getText().equals("")) {
            namaSIswa.setText("Masukkan Nama Siswa");
            namaSIswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_namaSIswaFocusLost

    private void namaSIswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaSIswaFocusGained
        if (namaSIswa.getText().equals("Masukkan Nama Siswa")) {
            namaSIswa.setText("");
            namaSIswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_namaSIswaFocusGained

    private void noWaSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noWaSiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noWaSiswaActionPerformed

    private void noWaSiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noWaSiswaFocusLost
        if (noWaSiswa.getText().equals("")) {
            noWaSiswa.setText("Masukkan no wa siswa");
            noWaSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_noWaSiswaFocusLost

    private void noWaSiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noWaSiswaFocusGained
        if (noWaSiswa.getText().equals("Masukkan no wa siswa")) {
            noWaSiswa.setText("");
            noWaSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_noWaSiswaFocusGained

    private void nisSiswaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nisSiswaFocusLost
        if (nisSiswa.getText().equals("")) {
            nisSiswa.setText("Masukkan NIS Siswa");
            nisSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nisSiswaFocusLost

    private void nisSiswaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nisSiswaFocusGained
        if (nisSiswa.getText().equals("Masukkan NIS Siswa")) {
            nisSiswa.setText("");
            nisSiswa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nisSiswaFocusGained

    public void insertDataSiswa() {
        String nis = nisSiswa.getText();
        String nama = namaSIswa.getText();
        String noWa = noWaSiswa.getText();
        String alamat = alamatSiswa.getText();

        String selectedKelas = (String) kelasSiswa.getSelectedItem();
        String kelasId = selectedKelas.split(" - ")[0];

        String query = "INSERT INTO murid (nis, nama, kelas_id, no_wa, alamat) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = (Connection) koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, nis);
            preparedStatement.setString(2, nama);
            preparedStatement.setInt(3, Integer.parseInt(kelasId));
            preparedStatement.setString(4, noWa);
            preparedStatement.setString(5, alamat);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE);
                nisSiswa.setText("");
                namaSIswa.setText("");
                kelasSiswa.setSelectedIndex(-1);
                alamatSiswa.setText("");
                noWaSiswa.setText("");
            }

        } catch (SQLException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Gagal menambahkan data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        String hariDiPilih = homeFrame.getComboBoxHari().getSelectedItem().toString();
        homeFrame.setVisible(true);
        homeFrame.loadJadwalData(hariDiPilih);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnKirimDataSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimDataSiswaActionPerformed
        insertDataSiswa();
    }//GEN-LAST:event_btnKirimDataSiswaActionPerformed

    private void loadKelasComboBox() {
        String url = "jdbc:mysql://localhost:3306/pelaporan_hasil_belajar_siswa";
        String user = "root";
        String password = "";

        String query = "SELECT k.id, k.nama_kelas, t.gen "
                + "FROM kelas k "
                + "JOIN tahun_ajaran t ON k.gen_id = t.id";

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            kelasSiswa.removeAllItems();
            while (resultSet.next()) {
                String kelasId = resultSet.getString("id");
                String namaKelas = resultSet.getString("nama_kelas");
                String gen = resultSet.getString("gen");
                kelasSiswa.addItem(kelasId + " - " + namaKelas + " - " + gen);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal memuat data kelas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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
            java.util.logging.Logger.getLogger(InputDataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputDataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputDataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputDataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                HomeTataUsaha homeFrame = new HomeTataUsaha();
//                String userName = "NamaPenggunaTest";
//                int userId = 1;
//                new InputDataSiswa(homeFrame, userName, userId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatSiswa;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnKirimDataSiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kelasSiswa;
    private javax.swing.JTextField namaSIswa;
    private javax.swing.JTextField nisSiswa;
    private javax.swing.JTextField noWaSiswa;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
