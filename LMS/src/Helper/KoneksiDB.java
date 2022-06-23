package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    public static Connection getconection(){
        Connection conn07302 = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_belajar";
        String user = "root";
        String pass = "";
        try {
            Class.forName(driver);
            conn07302 = DriverManager.getConnection(url,user,pass);
            System.out.println("Berhasil Koneksi Database");
        }catch (Exception e){
            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();
        }
        return conn07302;
    }

    public static void main(String[] args) {
        Connection conn = KoneksiDB.getconection();
    }
}
