/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menusewa;

import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.FormLogin;
import login.Session;
import pelanggan.ListPelanggan;

/**
 *
 * @author RIZKY
 */
public class SewaForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tabmode;
    private ResultSet hasil, hasilDataPelanggan;
    Connection CRUDkoneksi;
    private PreparedStatement CRUDsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
//    String tampilan = "yyyy-MM-dd";
    Sewa yo = new Sewa();
//    SimpleDateFormat fm = new SimpleDateFormat(tampilan);

    /**
     * Creates new form SewaForm
     */
    public SewaForm() {
        if (Session.getStatusLogin() == "AKTIF") {
            initComponents();
            try {
                MySQLConnection Connection = new MySQLConnection();
                CRUDkoneksi = Connection.getKoneksi();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            tampil_database();
            autoNoTransaksi();
            autoIdPelanggan();

        } else {
            dispose();
            FormLogin form = new FormLogin();
            form.setVisible(true);
        }
    }

    public void tampil_database() {
        Object[] baris = {"id_mobil", "nama_mobil", "harga"};
        tabmode = new DefaultTableModel(null, baris);
        table_unit.setModel(tabmode);
        try {
            hasil = yo.tampilData();
            while (hasil.next()) {
                yo.setIdMobil(hasil.getString("id_mobil"));
                yo.setNamaMobil(hasil.getString("nama_mobil"));
                yo.setHarga(hasil.getInt("harga"));
                String[] data = {yo.getIdMobil(), yo.getNamaMobil(), String.valueOf(yo.getHarga())};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void reset_text() {
        tf_alamat.setText("");
        tf_harga_perhari.setText("");
        tf_id_mobil.setText("");
        tf_nama_mobil.setText("");
        tf_nama_pelanggan.setText("");
        tf_no_hp.setText("");
        tf_no_ktp.setText("");
        tgl_ambil.setDateFormatString("");
        tgl_kembali.setDateFormatString("");
        tf_waktu.setText("");

    }

    public void autoIdPelanggan() {
        String CRUDquery = "select id_pelanggan from pelanggan ORDER BY id_pelanggan DESC LIMIT 1";
        try {
            Statement CRUDstat = CRUDkoneksi.createStatement();
            ResultSet CRUDhasil = CRUDstat.executeQuery(CRUDquery);
            if (CRUDhasil.next()) {
                String a = String.valueOf((CRUDhasil.getInt(1)) + 1);
                txt_id_pelanggan.setText(a);
            }
        } catch (Exception e) {
            System.out.println("Query select Error : " + e);
        }
    }

    public void autoNoTransaksi() {
        try {
            Statement stt = CRUDkoneksi.createStatement();
            String sql = "SELECT * FROM detail_sewa ORDER BY id_transaksi DESC";
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String id = rs.getString("id_transaksi").substring(1);
                String AN = "" + (Integer.parseInt(id) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
                txt_no_transaksi.setText("B" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txt_no_transaksi.setText("B0001");//sesuaikan dengan variable namenya
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
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
        table_unit = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_nama_pelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_no_ktp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_alamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_no_hp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_id_mobil = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_nama_mobil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_sewa = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_total_harga = new javax.swing.JLabel();
        btn_check_harga = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_waktu = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tf_harga_perhari = new javax.swing.JTextField();
        tgl_ambil = new com.toedter.calendar.JDateChooser();
        tgl_kembali = new com.toedter.calendar.JDateChooser();
        btn_cari = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_no_transaksi = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_id_pelanggan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 1000));

        table_unit.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        table_unit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_mobil", "nama_mobil", "harga"
            }
        ));
        table_unit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_unitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_unit);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("nama pelanggan");

        tf_nama_pelanggan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("no ktp");

        tf_no_ktp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("alamat");

        tf_alamat.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("no hp");

        tf_no_hp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("id_mobil");

        tf_id_mobil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("nama_mobil");

        tf_nama_mobil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("ambil :");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("kembali : ");

        btn_sewa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_sewa.setText("Sewa");
        btn_sewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sewaActionPerformed(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setText("Total Harga : ");

        txt_total_harga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_total_harga.setText("Rp.");

        btn_check_harga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_check_harga.setText("check harga");
        btn_check_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_check_hargaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("pilih Unit Pada Table Berikut untuk mempermudah mengisi ");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("id mobil dan nama mobil !");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel17.setText("waktu");

        tf_waktu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jLabel20.setText("hari");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setText("harga_perhari");

        tf_harga_perhari.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        tgl_ambil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        tgl_kembali.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btn_cari.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_cari.setText("cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setText("No Transaksi");

        txt_no_transaksi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setText("kode pelanggan");

        txt_id_pelanggan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/saving.png"))); // NOI18N
        jLabel1.setText("Sewa Unit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tf_nama_pelanggan)
                        .addComponent(tf_no_ktp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_no_hp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_alamat, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tgl_ambil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_no_transaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txt_id_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btn_cari)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(btn_check_harga)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sewa)
                        .addGap(18, 18, 18)
                        .addComponent(btn_reset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel21))
                                    .addGap(49, 49, 49))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(108, 108, 108)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tf_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel20))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_nama_mobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_id_mobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_harga_perhari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_total_harga))))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(367, 367, 367)
                                .addComponent(jLabel8)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2)
                                .addGap(145, 145, 145)
                                .addComponent(jLabel4)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_no_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(tf_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(tf_no_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(tf_no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(tgl_ambil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(tgl_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(tf_harga_perhari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tf_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txt_total_harga))
                            .addComponent(btn_check_harga))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sewa)
                            .addComponent(btn_reset))))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1200, 1000);
    }// </editor-fold>//GEN-END:initComponents

    private void table_unitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_unitMouseClicked
        // TODO add your handling code here:
        try {
            int row = table_unit.rowAtPoint(evt.getPoint());

            String id_mobil = table_unit.getValueAt(row, 0).toString();
            String nama_mobil = table_unit.getValueAt(row, 1).toString();
            String harga = table_unit.getValueAt(row, 2).toString();

            tf_id_mobil.setText(String.valueOf(id_mobil));
            tf_nama_mobil.setText(String.valueOf(nama_mobil));
            tf_harga_perhari.setText(String.valueOf(harga));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }//GEN-LAST:event_table_unitMouseClicked

    private void btn_check_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_check_hargaActionPerformed
        // TODO add your handling code here:
        int hasil_harga = yo.totalHarga(Integer.valueOf(tf_harga_perhari.getText()), Integer.valueOf(tf_waktu.getText()));
        txt_total_harga.setText("Rp. " + String.valueOf(hasil_harga));
    }//GEN-LAST:event_btn_check_hargaActionPerformed

    private void btn_sewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sewaActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ? ", "Warning", 2)
                == JOptionPane.YES_OPTION) {
            if (tf_nama_pelanggan.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Nama Pelanggan belum diisi!");
                tf_nama_pelanggan.requestFocus();
            } else if (tf_no_ktp.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, No KTP belum diisi!");
                tf_no_ktp.requestFocus();
            } else if (tf_alamat.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Alamat belum diisi!");
                tf_alamat.requestFocus();
            } else if (tf_no_hp.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, NO HP belum diisi!");
                tf_no_hp.requestFocus();
            } else if (tf_id_mobil.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Alamat belum diisi!");
                tf_id_mobil.requestFocus();
            } else if (tf_nama_mobil.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Nama Mobil belum diisi!");
                tf_nama_mobil.requestFocus();
            } else if (tf_harga_perhari.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, harga perhari belum diisi!");
                tf_harga_perhari.requestFocus();
            } else if (tf_waktu.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Waktu belum diisi!");
                tf_waktu.requestFocus();
            } else {
                try {
                    yo.setNoTransaksi(txt_no_transaksi.getText());
                    yo.setIdPelanggan(Integer.valueOf(txt_id_pelanggan.getText()));
                    yo.setNamaPelanggan(tf_nama_pelanggan.getText());
                    yo.setNoKtp(tf_no_ktp.getText());
                    yo.setAlamat(tf_alamat.getText());
                    yo.setNoHp(tf_no_hp.getText());
                    yo.setIdMobil(tf_id_mobil.getText());
                    yo.setNamaMobil(tf_nama_mobil.getText());
                    yo.setHarga(Integer.valueOf(tf_harga_perhari.getText()));
                    yo.setWaktu(Integer.valueOf(tf_waktu.getText()));
                    yo.setTglAmbil(new SimpleDateFormat("yyyy-MM-dd").format(tgl_ambil.getDate()));
                    yo.setTglKembali(new SimpleDateFormat("yyyy-MM-dd").format(tgl_kembali.getDate()));
                    yo.tambahDataPelanggan(yo.getIdPelanggan(), yo.getNamaPelanggan(), yo.getNoKtp(), yo.getAlamat(), yo.getNoHp());

                    yo.setTotalHarga(yo.totalHarga(yo.getHarga(), yo.getWaktu()));
                    yo.tambahDataDetailSewa(yo.getNoTransaksi(), yo.getIdMobil(), yo.getNamaMobil(), yo.getIdPelanggan(), yo.getTglAmbil(), yo.getTglKembali(), yo.getWaktu(), yo.getTotalHarga());
                    CRUDquery = "update unit set keterangan='Tidak Tersedia'  where id_mobil=?";
                    try {
                        CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
                        CRUDsmt.setString(1, tf_id_mobil.getText());
                        CRUDsmt.executeUpdate();
                        CRUDsmt.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                    reset_text();
                    tampil_database();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(e);
                }
            }
        }
        tampil_database();
        autoIdPelanggan();
        autoNoTransaksi();
    }//GEN-LAST:event_btn_sewaActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset_text();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        ListPelanggan form = new ListPelanggan();
        form.setVisible(true);
    }//GEN-LAST:event_btn_cariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_check_harga;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_unit;
    public static javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_harga_perhari;
    private javax.swing.JTextField tf_id_mobil;
    private javax.swing.JTextField tf_nama_mobil;
    public static javax.swing.JTextField tf_nama_pelanggan;
    public static javax.swing.JTextField tf_no_hp;
    public static javax.swing.JTextField tf_no_ktp;
    private javax.swing.JTextField tf_waktu;
    private com.toedter.calendar.JDateChooser tgl_ambil;
    private com.toedter.calendar.JDateChooser tgl_kembali;
    public static javax.swing.JLabel txt_id_pelanggan;
    private javax.swing.JLabel txt_no_transaksi;
    private javax.swing.JLabel txt_total_harga;
    // End of variables declaration//GEN-END:variables
}
