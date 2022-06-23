package Model;
import Entity.MahasiswaEntity;
import Helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
public class MahasiswaModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();

    public ArrayList<MahasiswaEntity> getAllMahasiswa(){
        ArrayList arrayListMahasiswa = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM mahasiswa";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
                mahasiswaEntity.setNpm_mahasiswa(rs.getString("npm_mahasiswa"));
                mahasiswaEntity.setNama_mahasiswa(rs.getString("nama_mahasiswa"));
                mahasiswaEntity.setNotelp_mahasiswa(rs.getString("notelp_mahasiswa"));
                arrayListMahasiswa.add(mahasiswaEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListMahasiswa;
    }

    public void insertMahasiswa(MahasiswaEntity mahasiswaEntity){
        try{
            sql = "INSERT INTO mahasiswa(npm_mahasiswa, nama_mahasiswa, notelp_mahasiswa) VALUES(?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, mahasiswaEntity.getNpm_mahasiswa());
            stat.setString(2, mahasiswaEntity.getNama_mahasiswa());
            stat.setString(3, mahasiswaEntity.getNotelp_mahasiswa());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void updateMahasiswa(MahasiswaEntity mahasiswaEntity){
        try{
            sql = "UPDATE mahasiswa SET nama_mahasiswa=?, notelp_mahasiswa=? WHERE npm_mahasiswa=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, mahasiswaEntity.getNama_mahasiswa());
            stat.setString(2, mahasiswaEntity.getNotelp_mahasiswa());
            stat.setString(3, mahasiswaEntity.getNpm_mahasiswa());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteMahasiswa(String npm){
        try{
            sql = "delete from mahasiswa WHERE npm_mahasiswa=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, npm);
            stat.executeUpdate();
            System.out.println("Berhasil Menghapus Data!!!");
        }catch (SQLException e){
            System.out.println("Gagal Menghapus Data !!!");
            e.printStackTrace();
        }
    }

    public int cekLoginMahasiswa(String nama, String npm) {
        int cek = 0;
        try {
            sql = "SELECT * FROM mahasiswa WHERE nama_mahasiswa =? and npm_mahasiswa=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setString(2, npm);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("npm_mahasiswa");
            }else{
                cek = 0;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }

    public int lihatnpm(String npm){
        int cek = 0;
        try{
            sql = "SELECT * FROM penduduk WHERE nik = ?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, npm);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("npm");
            }else {
                cek = 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cek;
    }
}
