/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuunit;

import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author RIZKY
 */
public class Unit {
    private String idMobil, namaMobil, tipeMobil, noPolisi, keterangan;
    private int harga;

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

    public String getTipeMobil() {
        return tipeMobil;
    }

    public void setTipeMobil(String tipeMobil) {
        this.tipeMobil = tipeMobil;
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public Unit(){
        try {
            MySQLConnection  Connection = new MySQLConnection();
            CRUDkoneksi = Connection.getKoneksi();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
   
    public ResultSet tampilData(){
        CRUDquery = "select * from unit";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    public ResultSet cariData(String id_mobil, String nama_mobil){
        if (id_mobil == "") {
            id_mobil = "kosongan";
        }else if(nama_mobil == ""){
            nama_mobil = "kosongan";
        }
        CRUDquery = "select * from unit where id_mobil LIKE '%"+ id_mobil + "%' OR nama_mobil LIKE '%" + nama_mobil + "%'";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    public void tambahData(String id_mobil, String nama_mobil, String tipe_mobil,String no_polisi, int harga, String keterangan){
        CRUDquery = "insert into unit values(?,?,?,?,?,?)";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, id_mobil);
            CRUDsmt.setString(2, nama_mobil);
            CRUDsmt.setString(3, tipe_mobil);
            CRUDsmt.setString(4, no_polisi);
            CRUDsmt.setInt(5, harga);
            CRUDsmt.setString(6, keterangan);
            CRUDsmt.executeUpdate(); 
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void ubahData(String id_mobil, String nama_mobil, String tipe_mobil,String no_polisi, int harga, String keterangan){
        CRUDquery = "update unit set nama_mobil=?, tipe_mobil=?, no_polisi=?, harga=?, keterangan=? where id_mobil=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, nama_mobil);
            CRUDsmt.setString(2, tipe_mobil);
            CRUDsmt.setString(3, no_polisi);
            CRUDsmt.setInt(4, harga);
            CRUDsmt.setString(5, keterangan);
            CRUDsmt.setString(6, id_mobil);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void hapusData(String id_mobil){
        CRUDquery = "delete from unit where id_mobil=?";
        try {
            CRUDsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDsmt.setString(1, id_mobil);
            CRUDsmt.executeUpdate();
            CRUDsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
