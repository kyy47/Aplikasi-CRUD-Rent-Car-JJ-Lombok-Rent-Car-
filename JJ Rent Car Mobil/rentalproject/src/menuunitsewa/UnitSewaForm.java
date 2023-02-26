/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuunitsewa;

import connection.MySQLConnection;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.FormLogin;
import login.Session;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRPrintXmlLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RIZKY
 */
public class UnitSewaForm extends javax.swing.JFrame {
    private DefaultTableModel tabModeSewa, tabModePelanggan;
    private ResultSet hasilDataSewa, hasilDataPelanggan;
    MySQLConnection con = new MySQLConnection();
    UnitSewa yo = new UnitSewa();
    File reportFile = new File(".");
    String dir = "";
    Statement stat;
    Connection CRUDkoneksi;
    // private boolean nilai = true;
    public UnitSewaForm() {
        if (Session.getStatusLogin() == "AKTIF") {
            initComponents();
            tampil_data_sewa();
            tampil_data_pelanggan();
            try {
                MySQLConnection  Connection = new MySQLConnection();
                CRUDkoneksi = Connection.getKoneksi();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }else{
            dispose();
            FormLogin form = new FormLogin();
            form.setVisible(true);
        }
        
    }
    
    public void tampil_data_sewa() {
        Object[] baris = {"id_transaksi", "id_mobil", "nama_mobil", "id_pelanggan","tgl_ambil",
            "tgl_kembali","waktu","keterangan","total_harga","ket_pembayaran"};
        tabModeSewa = new DefaultTableModel(null, baris);
        table_unit_sewa.setModel(tabModeSewa);
        try {
            hasilDataSewa = yo.tampilDataSewa();
            while (hasilDataSewa.next()) {
                yo.setId(hasilDataSewa.getString("id_transaksi"));
                yo.setIdMobil(hasilDataSewa.getString("id_mobil"));
                yo.setNamaMobil(hasilDataSewa.getString("nama_mobil"));
                yo.setIdPelanggan(hasilDataSewa.getString("id_pelanggan"));
                yo.setTglAmbil(hasilDataSewa.getString("tgl_ambil"));
                yo.setTglKembali(hasilDataSewa.getString("tgl_kembali"));
                yo.setWaktu(hasilDataSewa.getString("waktu"));
                yo.setKeterangan(hasilDataSewa.getString("keterangan"));
                yo.setTotalHarga(hasilDataSewa.getString("total_harga"));
                yo.setKetPembayaran(hasilDataSewa.getString("ket_pembayaran"));
                String[] data = {yo.getId(), yo.getIdMobil(), yo.getNamaMobil(),
                                yo.getIdPelanggan(),yo.getTglAmbil(), yo.getTglKembali(),
                                yo.getWaktu(), yo.getKeterangan(), yo.getTotalHarga(),
                                yo.getKetPembayaran()};
                tabModeSewa.addRow(data);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void tampil_data_pelanggan() {
        Object[] baris = {"id_pelanggan", "nama_pelanggan", "no_ktp", "alamat","no_hp"};
        tabModePelanggan = new DefaultTableModel(null, baris);
        table_pelanggan.setModel(tabModePelanggan);
        try {
            hasilDataPelanggan = yo.tampilDataPelanggan();
            while (hasilDataPelanggan.next()) {
                yo.setIdPelanggan(hasilDataPelanggan.getString("id_pelanggan"));
                yo.setNamaPelanggan(hasilDataPelanggan.getString("nama_pelanggan"));
                yo.setNoKtp(hasilDataPelanggan.getString("no_ktp"));
                yo.setAlamat(hasilDataPelanggan.getString("alamat"));
                yo.setNoHp(hasilDataPelanggan.getString("no_hp"));
                String[] data = {yo.getIdPelanggan(), yo.getNamaPelanggan(), yo.getNoKtp(),
                                yo.getAlamat(),yo.getNoHp()};
                tabModePelanggan.addRow(data);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error : " + e);
        }
    }
    public void cari_database() {
        Object[] baris = {"id", "id_mobil", "nama_mobil", "id_pelanggan","tgl_ambil",
            "tgl_kembali","waktu","keterangan","total_harga","ket_pembayaran"};
        tabModeSewa = new DefaultTableModel(null, baris);
        table_unit_sewa.setModel(tabModeSewa);
        try {
            hasilDataSewa = yo.cariData(tf_cari.getText());
            while (hasilDataSewa.next()) {
                yo.setId(hasilDataSewa.getString("id_transaksi"));
                yo.setIdMobil(hasilDataSewa.getString("id_mobil"));
                yo.setNamaMobil(hasilDataSewa.getString("nama_mobil"));
                yo.setIdPelanggan(hasilDataSewa.getString("id_pelanggan"));
                yo.setTglAmbil(hasilDataSewa.getString("tgl_ambil"));
                yo.setTglKembali(hasilDataSewa.getString("tgl_kembali"));
                yo.setWaktu(hasilDataSewa.getString("waktu"));
                yo.setKeterangan(hasilDataSewa.getString("keterangan"));
                yo.setTotalHarga(hasilDataSewa.getString("total_harga"));
                yo.setKetPembayaran(hasilDataSewa.getString("ket_pembayaran"));
                String[] data = {yo.getId(), yo.getIdMobil(), yo.getNamaMobil(),
                                yo.getIdPelanggan(),yo.getTglAmbil(), yo.getTglKembali(),
                                yo.getWaktu(), yo.getKeterangan(), yo.getTotalHarga(),
                                yo.getKetPembayaran()};
                tabModeSewa.addRow(data);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
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
        table_unit_sewa = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cb_unit_kembali = new javax.swing.JCheckBox();
        cb_lunas = new javax.swing.JCheckBox();
        tf_cari = new javax.swing.JTextField();
        btn_accept = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pelanggan = new javax.swing.JTable();
        btn_cetak_laporan = new javax.swing.JButton();
        tf_cari_pelanggan = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1400, 1000));

        table_unit_sewa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table_unit_sewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "id mobil", "nama mobil", "id pelanggan", "tgl ambil", "tgl kembali", "waktu", "keterangan", "total harga", "ket pembayaran"
            }
        ));
        table_unit_sewa.setRowHeight(20);
        table_unit_sewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_unit_sewaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_unit_sewa);

        btn_back.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_back.setText("back to menu");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("id tr : ");

        cb_unit_kembali.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cb_unit_kembali.setText("Unit Kembali");

        cb_lunas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cb_lunas.setText("Lunas");

        tf_cari.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cariActionPerformed(evt);
            }
        });
        tf_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cariKeyReleased(evt);
            }
        });

        btn_accept.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_accept.setText("accept");
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_batal.setText("cancel sewa");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        table_pelanggan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id pelanggan", "nama pelangan", "no ktp", "alamat", "no hp"
            }
        ));
        table_pelanggan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_pelanggan.setRowHeight(20);
        jScrollPane2.setViewportView(table_pelanggan);

        btn_cetak_laporan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_cetak_laporan.setText("Cetak Laporan");
        btn_cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak_laporanActionPerformed(evt);
            }
        });

        tf_cari_pelanggan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_cari_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cari_pelangganActionPerformed(evt);
            }
        });
        tf_cari_pelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cari_pelangganKeyReleased(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rent-a-car.png"))); // NOI18N
        jLabel1.setText("Unit Sewa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cb_unit_kembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(cb_lunas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_id)
                        .addGap(209, 209, 209)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tf_cari_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_accept, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btn_cetak_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(328, 328, 328))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(493, 493, 493))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_cari_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_unit_kembali)
                            .addComponent(cb_lunas)
                            .addComponent(btn_batal))))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(btn_cetak_laporan)
                    .addComponent(btn_accept))
                .addGap(275, 275, 275))
        );

        setSize(new java.awt.Dimension(1500, 1000));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        if ((!cb_unit_kembali.isSelected()) && (!cb_lunas.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Maaf, Anda Belum Check List Salah Satu Pilihan!");
        }else{
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengupdate data ini? ","Warning", 2)
            == JOptionPane.YES_OPTION) {
                try {
                    yo.setId(txt_id.getText());
                    if (cb_unit_kembali.isSelected()) {
                        yo.setKeterangan("Kembali");
                    }
                    if(cb_lunas.isSelected()){
                        yo.setKetPembayaran("Lunas");
                    }
                    yo.updateDataSewa(yo.getId(), yo.getKeterangan(), yo.getKetPembayaran());
                    JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE);
                    tampil_data_sewa();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_btn_acceptActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Cancel Sewa ini? ","Warning", 2)
            == JOptionPane.YES_OPTION) {
            try {
                yo.setId(txt_id.getText());
                yo.setKeterangan("Cancel");
                yo.setKetPembayaran("-");
                yo.updateDataSewa(yo.getId(), yo.getKeterangan(), yo.getKetPembayaran());
                JOptionPane.showMessageDialog(null, "Penyewaan Berhasil di Batalkan!", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
                tampil_data_sewa();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Penyewaan Tidak Berhasil di Batalkan!", "Informasi", 
                JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_batalActionPerformed

    private void table_unit_sewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_unit_sewaMouseClicked
        // TODO add your handling code here:
        try {
            int row = table_unit_sewa.rowAtPoint(evt.getPoint());
            String id = table_unit_sewa.getValueAt(row, 0).toString();
            txt_id.setText(id);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }//GEN-LAST:event_table_unit_sewaMouseClicked

    private void btn_cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak_laporanActionPerformed
         MySQLConnection connection = new MySQLConnection();
        try {
           Connection koneksi = connection.getKoneksi();
            try {
           String sql = "SELECT * FROM detail_sewa";
            dir = reportFile.getCanonicalPath() + "./src/laporan/";
            JasperDesign design = JRXmlLoader.load(dir + "Laporan.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(design);
            stat = koneksi.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs); 
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), rsDataSource);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            System.out.println(e);
        }
        } catch (Exception e) {
            System.out.println("koneksi error");
        }
    
              
           
       
    }//GEN-LAST:event_btn_cetak_laporanActionPerformed

    private void tf_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cariActionPerformed

    private void tf_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariKeyReleased
         try{
            stat = CRUDkoneksi.createStatement();
            tabModeSewa.getDataVector().removeAllElements();
            tabModeSewa.fireTableDataChanged();
            ResultSet rs = stat.executeQuery("SELECT * FROM detail_sewa WHERE  id_transaksi like '%" + tf_cari.getText() 
                    + "%' or id_mobil like '%" + tf_cari.getText() + "%' or nama_mobil like '%" + tf_cari.getText() 
                    + "%' or id_pelanggan like '%" + tf_cari.getText() + "%' " + "or tgl_ambil like '%" + tf_cari.getText() 
                    + "%' or tgl_kembali like '%" + tf_cari.getText() + "%' or waktu like '%" + tf_cari.getText() 
                    + "%' or keterangan like '%" + tf_cari.getText() + "%' or total_harga like '%" + tf_cari.getText() +
                    "%' or ket_pembayaran like '%" + tf_cari.getText()+"%'");
            while(rs.next()){
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
                };
                tabModeSewa.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tf_cariKeyReleased

    private void tf_cari_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cari_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cari_pelangganActionPerformed

    private void tf_cari_pelangganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cari_pelangganKeyReleased
        // TODO add your handling code here:
        try{
            stat = CRUDkoneksi.createStatement();
            tabModePelanggan.getDataVector().removeAllElements();
            tabModePelanggan.fireTableDataChanged();
            ResultSet rs = stat.executeQuery("SELECT * FROM pelanggan WHERE  id_pelanggan like '%" + tf_cari_pelanggan.getText() 
                    + "%' or nama_pelanggan like '%" + tf_cari_pelanggan.getText() + "%' or no_ktp like '%" + tf_cari_pelanggan.getText() 
                    + "%' or alamat like '%" + tf_cari_pelanggan.getText() + "%' " + "or no_hp like '%" + tf_cari_pelanggan.getText() + "%'");
            while(rs.next()){
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                };
                tabModePelanggan.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tf_cari_pelangganKeyReleased

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idKeyReleased

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
            java.util.logging.Logger.getLogger(UnitSewaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnitSewaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnitSewaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnitSewaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnitSewaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cetak_laporan;
    private javax.swing.JCheckBox cb_lunas;
    private javax.swing.JCheckBox cb_unit_kembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_pelanggan;
    private javax.swing.JTable table_unit_sewa;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_cari_pelanggan;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
