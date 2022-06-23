package Controller;
import Entity.MahasiswaEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
public class MahasiswaController {
    public ArrayList<MahasiswaEntity> getAllMahasiswa(){return AllObjectModel.mahasiswaModel.getAllMahasiswa();}

    public void insertMahasiswa(String npm_mahasiswa, String nama_mahasiswa, String notelp_mahasiswa){
        MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
        mahasiswaEntity.setNpm_mahasiswa(npm_mahasiswa);
        mahasiswaEntity.setNama_mahasiswa(nama_mahasiswa);
        mahasiswaEntity.setNotelp_mahasiswa(notelp_mahasiswa);
        AllObjectModel.mahasiswaModel.insertMahasiswa(mahasiswaEntity);
    }

    public void updateMahasiswa(String npm_mahasiswa, String nama_mahasiswa, String notelp_mahasiswa){
        MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
        mahasiswaEntity.setNpm_mahasiswa(npm_mahasiswa);
        mahasiswaEntity.setNama_mahasiswa(nama_mahasiswa);
        mahasiswaEntity.setNotelp_mahasiswa(notelp_mahasiswa);
        AllObjectModel.mahasiswaModel.updateMahasiswa(mahasiswaEntity);
    }

    public void deleteMahasiswa(String npm_mahasiswa){AllObjectModel.mahasiswaModel.deleteMahasiswa(npm_mahasiswa);}

    public int loginMahasiswa(String nama, String npm) {
        int log = AllObjectModel.mahasiswaModel.cekLoginMahasiswa(nama, npm);
        return log;
    }

    public DefaultTableModel daftarMahasiswa(){
        DefaultTableModel dataDaftarMahasiswa = new DefaultTableModel();
        Object[] kolom = {"NPM_MAHASISWA","NAMA_MAHASISWA","NOTELP_MAHASISWA"};
        dataDaftarMahasiswa.setColumnIdentifiers(kolom);
        int size=getAllMahasiswa().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[7];
            data[0]=AllObjectModel.mahasiswaModel.getAllMahasiswa().get(i).getNpm_mahasiswa();
            data[1]=AllObjectModel.mahasiswaModel.getAllMahasiswa().get(i).getNama_mahasiswa();
            data[2]=AllObjectModel.mahasiswaModel.getAllMahasiswa().get(i).getNotelp_mahasiswa();
            dataDaftarMahasiswa.addRow(data);
        }
        return dataDaftarMahasiswa;
    }

    public int lihatnpm(String npm){
        int cek = AllObjectModel.mahasiswaModel.lihatnpm(npm);
        return cek;
    }
}
