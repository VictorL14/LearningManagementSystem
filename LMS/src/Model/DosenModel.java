package Model;
import Entity.DosenEntity;
import Helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DosenModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();

    public DosenModel() {
    }

    public ArrayList<DosenEntity> getAllDosen() {
        ArrayList arrayListDosen = new ArrayList();
        try {
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM dosen";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                DosenEntity dosenEntity = new DosenEntity();
                dosenEntity.setNim_dosen(rs.getString("nim_dosen"));
                dosenEntity.setNama_dosen(rs.getString("nama_dosen"));
                dosenEntity.setNotelp_dosen(rs.getString("notelp_dosen"));
                arrayListDosen.add(dosenEntity);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arrayListDosen;
    }

    public void insertDosen(DosenEntity dosenEntity) {
        try {
            sql = "INSERT INTO dosen(nim_dosen, nama_dosen, notelp_dosen) VALUES(?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, dosenEntity.getNim_dosen());
            stat.setString(2, dosenEntity.getNama_dosen());
            stat.setString(3, dosenEntity.getNotelp_dosen());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateDosen(DosenEntity dosenEntity) {
        try {
            sql = "UPDATE dosen SET nama_dosen =?, notelp_dosen =? WHERE nim_dosen =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, dosenEntity.getNama_dosen());
            stat.setString(2, dosenEntity.getNotelp_dosen());
            stat.setString(3, dosenEntity.getNim_dosen());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void deleteDosen(String nim) {
        try {
            sql = "delete from dosen WHERE nim_dosen=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, nim);
            stat.executeUpdate();
            System.out.println("Berhasil Menghapus Data!!!");
        } catch (SQLException e) {
            System.out.println("Gagal Menghapus Data !!!");
            e.printStackTrace();
        }
    }

    public int cekLoginDosen(String nama, String nim) {
        int cek = 0;
        try {
            sql = "SELECT * FROM dosen WHERE nama_dosen =? and nim_dosen=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setString(2, nim);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                cek = rs.getInt("nim_dosen");
            } else {
                cek = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cek;
    }

    public HashMap<String, String> tugaskelas() {
        HashMap<String, String> tk = new HashMap<>();
        try {
            sql = "SELECT dosen.nim_dosen, dosen.nama_dosen, tugas.nama_tugas, detail_tugas.npm_mahasiswa, mahasiswa.nama_mahasiswa FROM dosen RIGHT JOIN tugas ON dosen.nim_dosen = tugas.nim_dosen JOIN detail_tugas ON tugas.id_tugas JOIN mahasiswa ON detail_tugas.npm_mahasiswa = mahasiswa.npm_mahasiswa";
            //PreparedStatement stat = conn07302.prepareStatement(sql);
            Statement s = conn07302.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                tk.put("nim_dosen", String.valueOf(rs.getString("nim_dosen")));
                tk.put("nama_dosen", String.valueOf(rs.getString("nama_dosen")));
                tk.put("nama_tugas", String.valueOf(rs.getString("nama_tugas")));
                tk.put("npm_mahasiswa", String.valueOf(rs.getString("npm_mahasiswa")));
                tk.put("nama_mahasiswa", String.valueOf(rs.getString("nama_mahasiswa")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tk;
    }
}
