/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuunitsewa;

import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author RIZKY
 */
public class UnitSewa {
    private String id, idMobil, namaMobil, idPelanggan, tglAmbil, tglKembali, waktu, keterangan, totalHarga, ketPembayaran, namaPelanggan;
    private String noKtp, alamat, noHp;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getKetPembayaran() {
        return ketPembayaran;
    }

    public void setKetPembayaran(String ketPembayaran) {
        this.ketPembayaran = ketPembayaran;
    }
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;

    public UnitSewa(){
        try {
            MySQLConnection  Connection = new MySQLConnection();
            CRUDkoneksi = Connection.getKoneksi();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public ResultSet tampilDataSewa(){
        CRUDquery = "select * from detail_sewa";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    public ResultSet tampilDataPelanggan(){
        CRUDquery = "select * from pelanggan";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    public ResultSet cariData(String keyword){
        CRUDquery = "select * from detail_sewa where id_transaksi LIKE '%"+ keyword + "%' OR id_mobil LIKE '%" + keyword 
                + "%' OR  nama_mobil LIKE  '%" + keyword  + "%' OR id_pelanggan LIKE '%" + keyword + 
                "%' OR tgl_ambil LIKE '%" + keyword + "%' OR tgl_kembali LIKE '%" + keyword + "%'";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
   
    public void updateDataSewa(String id, String keterangan, String ket_pembayaran){
        CRUDquery = "update detail_sewa set keterangan=?, ket_pembayaran=? where id_transaksi=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, keterangan);
            CRUDsmt.setString(2, ket_pembayaran);
            CRUDsmt.setString(3, id);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//    public void cancelSewa(String id){
//        CRUDquery = "delete from siswa where id=?";
//        try {
//            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
//            CRUDsmt.setString(1, id);
//            CRUDsmt.executeUpdate();
//            CRUDsmt.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
