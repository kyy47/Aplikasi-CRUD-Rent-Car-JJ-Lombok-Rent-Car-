package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection{
    private Connection connect;
    private String driverName = "com.mysql.jdbc.Driver";
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:";
    private String port ="3306/";
    private String database = "db_rental_mobil";
    private String url = "jdbc:mysql://localhost:3306/db_rental_mobil";
    private String username = "root";
    private String password= "";
    public Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try{
                Class.forName(driverName);//cek apakah driver tsb ada atau tidak
                System.out.println("Class Driver Ditemukan");
                try{
                    connect = DriverManager.getConnection(url, username, password);  // koneksi ke database
                    System.out.println("Koneksi Database Sukses");
                }catch(SQLException se){
                    System.out.println("Koneksi Database Gagal : " + se);
                    System.exit(0);
                }
            }catch(ClassNotFoundException cnfe){
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
}