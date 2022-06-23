package Model;
import Entity.TugasEntity;
import Helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
public class TugasModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();
    public TugasModel(){ }

    public ArrayList<TugasEntity> getALLTugas(){
        ArrayList arrayListTugas = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM tugas";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                TugasEntity tugasEntity = new TugasEntity();
                tugasEntity.setId_tugas(rs.getInt("id_tugas"));
                tugasEntity.setId_matkul(rs.getInt("id_matkul"));
                tugasEntity.setNim_dosen(rs.getString("nim_dosen"));
                tugasEntity.setNama_tugas(rs.getString("nama_tugas"));
                tugasEntity.setNilai_tugas("nilai_tugas");
                arrayListTugas.add(tugasEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListTugas;
    }

    public void insertTugas(TugasEntity tugasEntity){
        try {
            sql = "INSERT INTO tugas (id_tugas, id_matkul, nim_dosen, nama_tugas, nilai_tugas) VALUES(?,?,?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, tugasEntity.getId_tugas());
            stat.setInt(2, tugasEntity.getId_matkul());
            stat.setString(3, tugasEntity.getNim_dosen());
            stat.setString(4, tugasEntity.getNama_tugas());
            stat.setString(5, tugasEntity.getNilai_tugas());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateTugas(TugasEntity tugasEntity) {
        try {
            sql = "UPDATE tugas SET id_matkul=?, nim_dosen=?, nama_tugas=?, nilai_tugas=? WHERE id_tugas=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, tugasEntity.getId_matkul());
            stat.setString(2, tugasEntity.getNim_dosen());
            stat.setString(3, tugasEntity.getNama_tugas());
            stat.setString(4, tugasEntity.getNilai_tugas());
            stat.setInt(5, tugasEntity.getId_tugas());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteTugas(int id){
        try{
            sql = "delete from tugas WHERE id_tugas=?";
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
