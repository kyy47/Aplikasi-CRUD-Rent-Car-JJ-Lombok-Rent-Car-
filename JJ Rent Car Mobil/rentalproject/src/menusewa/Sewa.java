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

/**
 *
 * @author RIZKY
 */
public class Sewa {

    
  private String noTransaksi, namaPelanggan, noKtp, alamat, noHp, idMobil, namaMobil, tglAmbil, tglKembali;
  private int harga, totalHarga, waktu, idPelanggan;
    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(String idMobil) {
        this.idMobil = idMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
  
  
  private Connection CRUDkoneksi;
  private PreparedStatement CRUDsmt;    
  private Statement CRUDstat;
  private ResultSet CRUDhasil;
  private String CRUDquery;


    public Sewa(){
        try {
            MySQLConnection  Connection = new MySQLConnection();
            CRUDkoneksi = Connection.getKoneksi();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String getTglAmbil() {
        return tglAmbil;
    }

    public void setTglAmbil(String tglAmbil) {
        this.tglAmbil = tglAmbil;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }
   
    public ResultSet tampilData(){
        CRUDquery = "select id_mobil, nama_mobil, harga from unit WHERE keterangan = 'Tersedia'";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    public void tambahDataPelanggan(int idPelanggan, String nama_pelanggan, String no_ktp, String alamat,String no_hp){
        CRUDquery = "select id_pelanggan from pelanggan where nama_pelanggan='"+nama_pelanggan+"' AND no_ktp='"+no_ktp+"' AND alamat='"+alamat+"' AND no_hp='"+no_hp+"' LIMIT 1";
            try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
            if(CRUDhasil.next()){
            
            }else{
                CRUDquery = "insert into pelanggan(id_pelanggan, nama_pelanggan, no_ktp, alamat, no_hp) values(?,?,?,?,?)";
                try {
                    CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
                    CRUDsmt.setInt(1, idPelanggan);
                    CRUDsmt.setString(2, nama_pelanggan);
                    CRUDsmt.setString(3, no_ktp);
                    CRUDsmt.setString(4, alamat);
                    CRUDsmt.setString(5, no_hp);
                    CRUDsmt.executeUpdate();
                    CRUDsmt.close();
                } catch (Exception e) {
                    System.out.println("Query insert Error" + e);
                }
            }
            }catch (Exception e) {
            System.out.println("Query select Error");
            }
        
    }
    public void tambahDataDetailSewa(String no_transaksi, String id_mobil, String nama_mobil, int id_pelanggan,String tgl_ambil ,String tgl_kembali
            ,int waktu, int total_harga){
        CRUDquery = "insert into detail_sewa(id_transaksi, id_mobil, nama_mobil, id_pelanggan, "
                + "tgl_ambil, tgl_kembali, waktu, keterangan, total_harga, ket_pembayaran) "
                + "values(?,?,?,?,?,?,?,'Belum Kembali',?,'Belum Lunas')";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            
            CRUDsmt.setString(1, no_transaksi);
            CRUDsmt.setString(2, id_mobil);
            CRUDsmt.setString(3, nama_mobil);
            CRUDsmt.setInt(4, id_pelanggan);
            CRUDsmt.setString(5, tgl_ambil);
            CRUDsmt.setString(6, tgl_kembali);
            String waktuHari = String.valueOf(waktu) + " hari";
            CRUDsmt.setString(7, waktuHari);
            CRUDsmt.setInt(8, total_harga);
            CRUDsmt.executeUpdate(); 
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        public int totalHarga(int harga, int hari){
            int total = harga * hari;
            return total;
        }
        public String gabungkanWaktu(String tanggal, String bulan, String tahun){
            String gabung = tahun+"-"+bulan+"-"+tanggal;
            return  gabung;
        }
    
}
