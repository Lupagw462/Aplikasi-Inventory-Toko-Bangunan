/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import koneksi.koneksi;
/**
 *
 * @author Yuki
 */
public class formbarangkeluar extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
DefaultTableModel tabmode;
    public int getDefaultCloseOperation() {
        return super.getDefaultCloseOperation(); //To change body of generated methods, choose Tools | Templates.
    }
Icon iconsukses = new javax.swing.ImageIcon(getClass().getResource("/icon/Checkmark.png"));
Icon iconfailed = new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel.png"));
String Tanggal;
    /**
     * Creates new form formbarangmasuk
     */
    public formbarangkeluar() {
        initComponents();
        setTitle("Tambah Barang Keluar");
        setLocationRelativeTo(null);
        nmbarang.requestFocus(true);
        autonumber();
        
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Subtotal");
        
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        ttanggal.setText(s.format(date));
    }
    
    public void clear2() {
     tsubtotal.setText("");
        txtTampilan.setText("Rp. 0,00");
    }
    private void autonumber() {
    String sql = "SELECT * FROM barangkeluar ORDER BY NoFaktur DESC";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        if (hasil.next()) {
            String NoFaktur = hasil.getString("NoFaktur").substring(2);  // Menghilangkan awalan "BK"

            int newNumber = Integer.parseInt(NoFaktur) + 1;
            String BK = String.valueOf(newNumber);

            String Nol = "";
            switch (BK.length()) {
                case 1:
                    Nol = "000";
                    break;
                case 2:
                    Nol = "00";
                    break;
                case 3:
                    Nol = "0";
                    break;
                case 4:
                    Nol = "";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid NoFaktur length");
            }

            ttransaksi.setText("BK" + Nol + BK);
        } else {
            ttransaksi.setText("BK0001");
        }
    } catch (NumberFormatException e) {
        System.out.println("Error parsing NoFaktur to number: " + e.getMessage());
        ttransaksi.setText("BK0001");
    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
        ttransaksi.setText("BK0001");
    } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
        ttransaksi.setText("BK0001");
    }
}



public void setKodeBarang (String kodebarang) {
    kdbarang.setText(kodebarang);
}
public void setNamaBarang(String barang) {
    nmbarang.setText(barang);
}
public void setJenis(String jenis) {
    tjenis.setText(jenis);
}
public void setSatuan(String satuan) {
    tsatuan.setText(satuan);
}
public void setHarga(String harga) {
    tharga.setText(harga);
}


public void updateTotalBayar() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    double total = 0;

    // Iterasi melalui semua baris
    for (int i = 0; i < model.getRowCount(); i++) {
        // Ambil nilai dari kolom kelima (indeks 5) sebagai String terlebih dahulu
        String rowTotalStr = model.getValueAt(i, 5).toString();
        
        // Parse String menjadi Double
        double rowTotal = Double.parseDouble(rowTotalStr);

        // Tambahkan ke total
        total += rowTotal;
    }

    // Format dan tampilkan hasil
    if (total == Math.floor(total)) {
        // Jika total adalah bilangan bulat, tampilkan tanpa desimal
        tsubtotal.setText(String.format("%.0f", total));
        txtTampilan.setText(String.format("Rp.%.0f", total));
    } else {
        // Jika ada angka desimal, tampilkan dengan dua angka desimal
        tsubtotal.setText(String.format("%.2f", total));
        txtTampilan.setText(String.format("Rp.%.2f", total));
    }
}



private void clearTable() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
}

public void clear () {
    kdbarang.setText("");
    tjenis.setText("");
    nmbarang.setText("");
    tsatuan.setText("");
    tharga.setText("");
    tjumlah.setText("");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ttransaksi = new javax.swing.JTextField();
        ttanggal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kdbarang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nmbarang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tjumlah = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tsubtotal = new javax.swing.JTextField();
        tsatuan = new javax.swing.JTextField();
        tjenis = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bcari = new javax.swing.JButton();
        btambah = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTampilan = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Tambah Barang Keluar");

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No Transaksi");

        ttransaksi.setBackground(new java.awt.Color(204, 204, 255));
        ttransaksi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        ttanggal.setBackground(new java.awt.Color(204, 204, 255));
        ttanggal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ttransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addComponent(ttanggal))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Barang");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel7)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Kode Barang");

        jLabel9.setText("Nama Barang");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Satuan");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("Harga");

        tharga.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("Jumlah");

        tjumlah.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setText("Subtotal");

        tsubtotal.setBackground(new java.awt.Color(153, 204, 255));
        tsubtotal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        tsatuan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel14.setText("Jenis Barang");

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon_Search-removebg-preview.png"))); // NOI18N
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tjenis)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kdbarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nmbarang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tharga, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tjumlah, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tsubtotal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tsatuan, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(54, 54, 54)
                                .addComponent(bcari))
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel14)
                .addGap(8, 8, 8)
                .addComponent(tjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        btambah.setBackground(new java.awt.Color(51, 51, 255));
        btambah.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btambah.setForeground(new java.awt.Color(255, 255, 255));
        btambah.setText("Tambah Barang");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(51, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTampilan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtTampilan.setText("Rp.0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTampilan)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtTampilan)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        bhapus.setBackground(new java.awt.Color(51, 51, 255));
        bhapus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bhapus.setForeground(new java.awt.Color(255, 255, 255));
        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bsimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bbatal)
                                .addGap(117, 117, 117)
                                .addComponent(bkembali))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(363, 363, 363)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 545, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bkembali, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsimpan)
                            .addComponent(bbatal))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        String sql = "select * from databarang where Nama_Barang like '%" + nmbarang.getText() + "%'";
System.out.println(sql); // Debugging: Print SQL query
try {
    java.sql.Statement stat = conn.createStatement();   
    ResultSet hasil = stat.executeQuery(sql);
    
    if (hasil.isBeforeFirst()) { // Check if the result set has any rows
        while (hasil.next()) {
            String a = hasil.getString("Kode_Barang");
            String b = hasil.getString("Nama_Jenis");
            String c = hasil.getString("Nama_Barang");
            String d = hasil.getString("Satuan");
            String e = hasil.getString("Harga");

            kdbarang.setText(a);
            tjenis.setText(b);
            nmbarang.setText(c);
            tsatuan.setText(d);
            tharga.setText(e);
            nmbarang.setEnabled(true);
            System.out.println("Data populated"); // Debugging: Confirm data is populated
        }
    } else {
        System.out.println("No data found"); // Debugging: No rows in result set
    }
} catch (Exception e) {
    e.printStackTrace(); // Print error details if any
}
    }//GEN-LAST:event_bcariActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
String noTransaksi = ttransaksi.getText();
String idBarang = kdbarang.getText();
String namaBarang = nmbarang.getText();
String hargaStr = tharga.getText();
String jumlahStr = tjumlah.getText();

// Cek apakah harga dan jumlah tidak kosong atau null sebelum konversi
if (hargaStr.isEmpty() || jumlahStr.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Harga atau jumlah tidak boleh kosong!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
    return;  // Batalkan proses jika ada nilai yang kosong
}

try {
    // Lakukan parsing hanya jika hargaStr dan jumlahStr tidak kosong
    double harga = Double.parseDouble(hargaStr);
    int jumlah = Integer.parseInt(jumlahStr);
    double total = harga * jumlah;

    // Format angka untuk menghilangkan .0 jika angkanya bulat
    DecimalFormat df = new DecimalFormat("#.##");  // Menampilkan dua desimal jika ada
    String hargaFormatted = df.format(harga);
    String totalFormatted = df.format(total);

    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[]{noTransaksi, idBarang, namaBarang, jumlah, hargaFormatted, totalFormatted});

    updateTotalBayar();
    nmbarang.requestFocus();
    clear();
} catch (NumberFormatException e) {
    // Tampilkan pesan kesalahan jika ada masalah dalam parsing angka
    JOptionPane.showMessageDialog(null, "Input harga atau jumlah tidak valid!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) table.getModel();
    int selectedRow = table.getSelectedRow();
    
    if (selectedRow != -1) {  // Periksa apakah ada baris yang dipilih
        model.removeRow(selectedRow);  // Hapus baris yang dipilih
        updateTotalBayar();  // Perbarui total setelah penghapusan
    } else {
        JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
    }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        this.toBack();
        BarangKeluar mainmenu = new BarangKeluar();
        mainmenu.setVisible(true);
        mainmenu.toFront();
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
 String noFaktur = ttransaksi.getText();  // NoFaktur
String tanggal = ttanggal.getText();     // Tanggal
String totalStr = tsubtotal.getText();   // Total in String format

// Clean and convert total to double
String totalCleaned = totalStr.replace("Rp", "").replace(".", "").replace(",", ".");
double total = Double.parseDouble(totalCleaned);

String sql = "INSERT INTO barangkeluar(NoFaktur, Tanggal, Total) VALUES(?, ?, ?)";

try {
    // Start transaction
    conn.setAutoCommit(false);

    // Insert into barangmasuk
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, noFaktur);
    stat.setString(2, tanggal);
    stat.setDouble(3, total);

    int result = stat.executeUpdate();
    if (result > 0) {
        JOptionPane.showMessageDialog(null, "Barang Keluar Berhasil Disimpan", "Notice!!!", WIDTH, iconsukses);
    } else {
        JOptionPane.showMessageDialog(null, "Barang Keluar Gagal Disimpan", "Notice!!!", WIDTH, iconfailed);
        conn.rollback();
        return;
    }

    // Insert into detailbarangmasuk
    int baris = table.getRowCount();
    int kolom = table.getColumnCount();  // Get the number of columns in the table

    // Ensure the table has at least 6 columns before accessing
    if (kolom < 6) {
        JOptionPane.showMessageDialog(null, "Tabel tidak memiliki kolom yang cukup. Pastikan terdapat minimal 6 kolom.");
        conn.rollback(); // Rollback the transaction
        return;
    }

    sql = "INSERT INTO detailbarangkeluar(NoFaktur, Kode_Barang, Nama_Barang, Jumlah, Harga, Subtotal) VALUES(?, ?, ?, ?, ?, ?)";
    PreparedStatement statDetail = conn.prepareStatement(sql);

    for (int i = 0; i < baris; i++) {
        try {
            statDetail.setString(1, noFaktur); // NoFaktur
            statDetail.setString(2, table.getValueAt(i, 1).toString()); // Kode_Barang
            statDetail.setString(3, table.getValueAt(i, 2).toString()); // Nama_Barang
            statDetail.setString(4, table.getValueAt(i, 3).toString()); // Jumlah
            statDetail.setDouble(5, Double.parseDouble(table.getValueAt(i, 4).toString())); // Harga
            statDetail.setString(6, table.getValueAt(i, 5).toString()); // Subtotal

            int detailResult = statDetail.executeUpdate();
            if (detailResult == 0) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan untuk baris " + (i + 1));
                conn.rollback();
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan pada baris " + (i + 1) + ": " + ex.getMessage());
            conn.rollback(); // Rollback if there is an exception
            return;
        }
    }

    // Commit transaction if everything is fine
    conn.commit();
    
    // Clear form and reset NoFaktur
    clear2();
    autonumber();

    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);  // This will clear all rows in the table

    
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
    e.printStackTrace();
    try {
        conn.rollback(); // Rollback if SQLException occurs
    } catch (SQLException rollbackEx) {
        rollbackEx.printStackTrace();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
    e.printStackTrace();
} finally {
    try {
        conn.setAutoCommit(true); // Set autocommit back to true
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_bsimpanActionPerformed

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
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formbarangkeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkembali;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kdbarang;
    private javax.swing.JTextField nmbarang;
    private javax.swing.JTable table;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tjenis;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField tsatuan;
    private javax.swing.JTextField tsubtotal;
    private javax.swing.JTextField ttanggal;
    private javax.swing.JTextField ttransaksi;
    private javax.swing.JLabel txtTampilan;
    // End of variables declaration//GEN-END:variables
}
