/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.Icon;
import koneksi.koneksi;
/**
 *
 * @author Yuki
 */
public class formbarang extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
Icon iconsukses = new javax.swing.ImageIcon(getClass().getResource("/icon/Checkmark.png"));
Icon iconfailed = new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel.png"));
    /**
     * Creates new form formbarang
     */
    public formbarang() {
        initComponents();
        setTitle("Tambah Data Barang");
        setLocationRelativeTo(null);
    }
public void setKodeJenisBarang(String kode) {
    kd_jbarang.setText(kode);
}

public void setNamaJenisBarang(String nama) {
    nama_jbarang.setText(nama);
}

public void setKodeBarang (String kodebarang) {
    kd_barang.setText(kodebarang);
}
public void clear () {
    kd_barang.setText("");
    kd_jbarang.setText("");
    nama_jbarang.setText("");
    nm_barang.setText("");
    tharga.setText("");
    tstock.setText("");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        kd_barang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kd_jbarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama_jbarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nm_barang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbsatuan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tstock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bsimpan = new javax.swing.JToggleButton();
        bbatal = new javax.swing.JToggleButton();
        bkdjbarang = new javax.swing.JButton();
        bkembali = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Kode Barang");

        kd_barang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Kode Jenis Barang");

        kd_jbarang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama Jenis Barang");

        nama_jbarang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nama Barang");

        nm_barang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Satuan");

        cbsatuan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbsatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Pilih Salah Satu----", "Pcs", "Kg", "Sak", "meter" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Harga");

        tharga.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Stock");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel8.setText("Tambah Data Barang");

        bsimpan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon_Save-removebg-preview.png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbatal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon_clear-removebg-preview.png"))); // NOI18N
        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkdjbarang.setText("....");
        bkdjbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkdjbarangActionPerformed(evt);
            }
        });

        bkembali.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Back To.png"))); // NOI18N
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(bbatal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(kd_barang)
                            .addComponent(jLabel2)
                            .addComponent(kd_jbarang)
                            .addComponent(jLabel3)
                            .addComponent(nama_jbarang)
                            .addComponent(jLabel4)
                            .addComponent(nm_barang)
                            .addComponent(jLabel5)
                            .addComponent(cbsatuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(tharga)
                            .addComponent(jLabel7)
                            .addComponent(tstock, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addComponent(bkdjbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bkembali)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bbatal))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(bkembali))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(kd_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kd_jbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bkdjbarang))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nama_jbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nm_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        String sql = "insert into databarang values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kd_barang.getText());
            stat.setString(2, kd_jbarang.getText());
            stat.setString(3, nama_jbarang.getText());
            stat.setString(4, nm_barang.getText());
            stat.setString(5, cbsatuan.getSelectedItem().toString());
            stat.setString(6, tharga.getText());
            stat.setString(7, tstock.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Disimpan", "Notice!!!", WIDTH, iconsukses);
            nm_barang.requestFocus();
            clear();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Gagal Disimpan", "Notice!!!", WIDTH, iconfailed);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bkdjbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkdjbarangActionPerformed
        // TODO add your handling code here:
         listdatajenisbarang a = new listdatajenisbarang();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_bkdjbarangActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        this.toBack();
        DataBarang mainmenu = new DataBarang();
        mainmenu.setVisible(true);
        mainmenu.toFront();
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
        clear();
        
    }//GEN-LAST:event_bbatalActionPerformed

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
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bbatal;
    private javax.swing.JButton bkdjbarang;
    private javax.swing.JToggleButton bkembali;
    private javax.swing.JToggleButton bsimpan;
    private javax.swing.JComboBox<String> cbsatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField kd_barang;
    private javax.swing.JTextField kd_jbarang;
    private javax.swing.JTextField nama_jbarang;
    private javax.swing.JTextField nm_barang;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tstock;
    // End of variables declaration//GEN-END:variables
}
