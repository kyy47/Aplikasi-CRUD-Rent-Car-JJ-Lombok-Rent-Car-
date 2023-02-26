package login;
import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MySQLConnection;

public class Login {
    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query, userID, password, pesan;
    public Login(){
        MySQLConnection connection = new MySQLConnection();
        try {
            koneksi = connection.getKoneksi();
        } catch (Exception e) {
            System.out.println("koneksi error");
        }
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String cekLogin(String userID, String password) {
        query = "SELECT nama FROM users WHERE id_user=? AND password=md5(?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.setString(2, password);
            dataUser = psmt.executeQuery();
            if (dataUser.next()) {
                Session.setUserId(userID);
                Session.setNama(dataUser.getString("nama"));
                Session.setStatusLogin("AKTIF");
                query = "INSERT INTO log_login(id_user) values(?)";
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, userID);
                    psmt.executeUpdate();
                    psmt.close();
                } catch (Exception e) {
                    pesan = "Gagal Simpan Log Login";
                }
            }else{
                pesan = "Gagal Login";
            }
        } catch (Exception e) {
            pesan = "Gagal Login, Query Error";
        }
        return pesan;
    }
    public void LogOut(String userID){
        query ="UPDATE log_login SET waktu_logout = CURRENT_TIMESTAMP() where id_user=? ORDER BY id DESC LIMIT 1";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.executeUpdate();
            psmt.close();

            Session.setUserId(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        } catch (Exception e) {
            System.out.println("Hadehh");
        }
    }

}
