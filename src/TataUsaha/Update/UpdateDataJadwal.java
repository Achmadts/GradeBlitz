package TataUsaha.Update;

import controllers.updateDataJadwalController;
import models.updateDataJadwalModel;
import javax.swing.DefaultComboBoxModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.koneksi;

public class UpdateDataJadwal extends javax.swing.JFrame {

    private updateDataJadwalController controller;
    private updateDataJadwalModel jadwal;

    public UpdateDataJadwal(int id, String nip, String mapel, String hari, String jam, String ruang) {
        jadwal = new updateDataJadwalModel(id, nip, mapel, hari, jam, ruang);
        controller = new updateDataJadwalController();
        initComponents();
        populateComboBoxes();
        updateFormFields(nip, mapel, hari, jam, ruang);
    }

    private void populateComboBoxes() {
        populateComboBox(namaGuru, "SELECT nip, full_name FROM users WHERE role_id = 2");
        populateComboBox(namaMapel, "SELECT id, nama_mapel FROM mapel");
    }

    private void populateComboBox(javax.swing.JComboBox<String> comboBox, String query) {
        try (Connection conn = koneksi.koneksiDB(); PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
            model.removeAllElements();
            ArrayList<String> values = new ArrayList<>();

            while (resultSet.next()) {
                String value = resultSet.getString(1);
                String displayValue = resultSet.getString(2);
                model.addElement(displayValue);
                values.add(value);
            }

            comboBox.putClientProperty("values", values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateFormFields(String nip, String mapelId, String hari, String jam, String ruang) {
        setComboBoxValue(namaGuru, nip);
        setComboBoxValue(namaMapel, mapelId);
        setComboBoxValue(hariComboBox, hari);
        setComboBoxValue(jamComboBox, jam);
        setComboBoxValue(ruangComboBox, ruang);
    }

    private void setComboBoxValue(javax.swing.JComboBox<String> comboBox, String value) {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBox.getModel();
        ArrayList<String> values = (ArrayList<String>) comboBox.getClientProperty("values");

//        System.out.println("ComboBox Values: " + values);
//        System.out.println("Value to Set: " + value);

        if (values != null) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i).equals(value)) {
                    comboBox.setSelectedIndex(i);
                    return;
                }
            }
        }
        comboBox.setSelectedItem(value);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnKirimDataJadwal = new javax.swing.JButton();
        namaGuru = new javax.swing.JComboBox<>();
        namaMapel = new javax.swing.JComboBox<>();
        hariComboBox = new javax.swing.JComboBox<>();
        jamComboBox = new javax.swing.JComboBox<>();
        ruangComboBox = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UPDATE DATA JADWAL");

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel2.setText("GURU");

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel3.setText("MATA PELAJARAN");

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel4.setText("HARI");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel5.setText("JAM");

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel7.setText("RUANG");

        btnKirimDataJadwal.setBackground(new java.awt.Color(0, 102, 102));
        btnKirimDataJadwal.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        btnKirimDataJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnKirimDataJadwal.setText("SUBMIT");
        btnKirimDataJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimDataJadwalActionPerformed(evt);
            }
        });

        hariComboBox.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        hariComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SENIN", "SELASA", "RABU", "KAMIS", "JUMAT" }));

        jamComboBox.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jamComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00 - 08:40", "08:40 - 09:20", "09:35 - 10:15", "10:15 - 10:55", "10:55 - 11:35", "11:35 - 12:15", "13:00 - 13:45", "13:45 - 14:30", "14:30 - 15:15", "15:15 - 16:00" }));

        ruangComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LAB 1", "LAB 2", "LAB 3", "LAB 4", "LAB 5", "R 44", "AWS" }));

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKirimDataJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(114, 114, 114))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(109, 109, 109))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(119, 119, 119))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(96, 96, 96)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaGuru, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaMapel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hariComboBox, 0, 400, Short.MAX_VALUE)
                            .addComponent(jamComboBox, 0, 400, Short.MAX_VALUE)
                            .addComponent(ruangComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hariComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ruangComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKirimDataJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
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

    private void btnKirimDataJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimDataJadwalActionPerformed
        jadwal.setGuru(namaGuru.getSelectedItem().toString());
        jadwal.setMapel(namaMapel.getSelectedItem().toString());
        jadwal.setHari(hariComboBox.getSelectedItem().toString());
        jadwal.setJam(jamComboBox.getSelectedItem().toString());
        jadwal.setRuang(ruangComboBox.getSelectedItem().toString());

        String selectedGuruId = getSelectedComboBoxId(namaGuru);
        String selectedMapelId = getSelectedComboBoxId(namaMapel);

        controller.updateDataJadwal(jadwal, selectedGuruId, selectedMapelId);
    }//GEN-LAST:event_btnKirimDataJadwalActionPerformed

    private String getSelectedComboBoxId(javax.swing.JComboBox<String> comboBox) {
        ArrayList<String> values = (ArrayList<String>) comboBox.getClientProperty("values");
        int selectedIndex = comboBox.getSelectedIndex();
        if (values != null && selectedIndex >= 0 && selectedIndex < values.size()) {
            return values.get(selectedIndex);
        }
        return null;
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateDataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new UpdateDataJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnKirimDataJadwal;
    private javax.swing.JComboBox<String> hariComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jamComboBox;
    private javax.swing.JComboBox<String> namaGuru;
    private javax.swing.JComboBox<String> namaMapel;
    private javax.swing.JComboBox<String> ruangComboBox;
    // End of variables declaration//GEN-END:variables
}
