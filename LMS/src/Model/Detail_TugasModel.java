package Model;
import Entity.Detail_TugasEntity;
import Helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
public class Detail_TugasModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();
    public Detail_TugasModel(){ }

    public ArrayList<Detail_TugasEntity> getALLDetTug(){
        ArrayList arrayListDetTug = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM detail_tugas";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                Detail_TugasEntity DetTugEntity = new Detail_TugasEntity();
                DetTugEntity.setId_tugas(rs.getInt("id_tugas"));
                DetTugEntity.setNpm_mahasiswa(rs.getString("npm_mahasiswa"));
                DetTugEntity.setJumlah_tugas(rs.getString("jumlah_tugas"));
                arrayListDetTug.add(DetTugEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListDetTug;
    }

    public void insertDetTug(Detail_TugasEntity DetTugEntity){
        try {
            sql = "INSERT INTO detail_tugas (id_tugas, npm_mahasiswa, jumlah_tugas) VALUES(?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, DetTugEntity.getId_tugas());
            stat.setString(2, DetTugEntity.getNpm_mahasiswa());
            stat.setString(3, DetTugEntity.getJumlah_tugas());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateDetTug(Detail_TugasEntity DetTugEntity){
        try{
            sql = "UPDATE detail_tugas SET npm_mahasiswa=?, jumlah_tugas=? WHERE id_tugas=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, DetTugEntity.getNpm_mahasiswa());
            stat.setString(2, DetTugEntity.getJumlah_tugas());
            stat.setInt(3, DetTugEntity.getId_tugas());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteDetTug(int id){
        try{
            sql = "delete from detail_tugas WHERE id_tugas=?";
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
