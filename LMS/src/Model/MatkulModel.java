package Model;
import Entity.MatkulEntity;
import Helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
public class MatkulModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();
    public MatkulModel(){}

    public ArrayList<MatkulEntity> getALLMatkul(){
        ArrayList arrayListMatkul = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM matkul";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                MatkulEntity matkulEntity = new MatkulEntity();
                matkulEntity.setId_matkul(rs.getInt("id_matkul"));
                matkulEntity.setNim_dosen(rs.getString("nim_dosen"));
                matkulEntity.setNama_matkul(rs.getString("nama_matkul"));
                arrayListMatkul.add(matkulEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListMatkul;
    }

    public void insertMatkul(MatkulEntity matkulEntity){
        try {
            sql = "INSERT INTO matkul (id_matkul, nim_dosen, nama_matkul) VALUES(?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, matkulEntity.getId_matkul());
            stat.setString(2, matkulEntity.getNim_dosen());
            stat.setString(3, matkulEntity.getNama_matkul());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateMatkul(MatkulEntity matkulEntity) {
        try {
            sql = "UPDATE matkul SET  nim_dosen=?, nama_matkul=? WHERE id_matkul=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, matkulEntity.getNim_dosen());
            stat.setString(2, matkulEntity.getNama_matkul());
            stat.setInt(3, matkulEntity.getId_matkul());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteMatkul(int id){
        try{
            sql = "delete from matkul WHERE id_matkul=?";
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
