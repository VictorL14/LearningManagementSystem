package Model;
import Entity.Detail_MatkulEntity;
import Helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;

public class Detail_MatkulModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();
    public Detail_MatkulModel(){ }

    public ArrayList<Detail_MatkulEntity> getALLDetMat(){
        ArrayList arrayListDetMat = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM detail_matkul";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Detail_MatkulEntity DetMatEntity = new Detail_MatkulEntity();
                DetMatEntity.setId_matkul(rs.getInt("id_matkul"));
                DetMatEntity.setNpm_mahasiswa(rs.getString("npm_mahasiswa"));
                DetMatEntity.setJumlah_sks(rs.getString("jumlah_sks"));
                arrayListDetMat.add(DetMatEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListDetMat;
    }

    public void insertDetMat(Detail_MatkulEntity DetMatEntity){
        try {
            sql = "INSERT INTO detail_matkul (id_matkul, npm_mahasiswa, jumlah_sks) VALUES(?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, DetMatEntity.getId_matkul());
            stat.setString(2, DetMatEntity.getNpm_mahasiswa());
            stat.setString(3, DetMatEntity.getJumlah_sks());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateDetMat(Detail_MatkulEntity DetMatEntity){
        try{
            sql = "UPDATE detail_matkul SET npm_mahasiswa=?, jumlah_sks=? WHERE id_matkul=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, DetMatEntity.getNpm_mahasiswa());
            stat.setString(2, DetMatEntity.getJumlah_sks());
            stat.setInt(3, DetMatEntity.getId_matkul());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteDetMat(int id){
        try{
            sql = "delete from detail_matkul WHERE id_matkul=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
            System.out.println("Berhasil Menghapus Data!!!");
        }catch (SQLException e){
            System.out.println("Gagal Menghapus Data !!!");
            e.printStackTrace();
        }
    }
}
