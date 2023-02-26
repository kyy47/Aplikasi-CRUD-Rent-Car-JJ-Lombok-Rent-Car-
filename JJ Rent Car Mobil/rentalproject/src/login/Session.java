package login;

public class Session{
    private static String userID , nama, statusLogin;
    public static void setUserId(String userID) {
        Session.userID = userID;
    }
    public static String getUserID() {
        return Session.userID;
    }
    public static void setNama(String nama) {
        Session.nama = nama;
    }
    public static String getNama() {
        return Session.nama;
    }
    public static void setStatusLogin(String statusLogin) {
        Session.statusLogin = statusLogin;
    }
    public static String getStatusLogin() {
        return Session.statusLogin;
    }
}