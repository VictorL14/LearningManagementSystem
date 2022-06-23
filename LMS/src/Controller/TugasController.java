package Controller;
import Entity.TugasEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TugasController {
    public ArrayList<TugasEntity> getALLTugas(){return AllObjectModel.tugasModel.getALLTugas();}

    public void insertTugas(int id_tugas, int id_matkul, String nim_dosen, String nama_tugas, String nilai_tugas){
        TugasEntity tugasEntity = new TugasEntity();
        tugasEntity.setId_tugas(id_tugas);
        tugasEntity.setId_matkul(id_matkul);
        tugasEntity.setNim_dosen(nim_dosen);
        tugasEntity.setNama_tugas(nama_tugas);
        tugasEntity.setNilai_tugas(nilai_tugas);
        AllObjectModel.tugasModel.insertTugas(tugasEntity);
    }

    public void updateTugas(int id_tugas, int id_matkul, String nim_dosen, String nama_tugas, String nilai_tugas){
        TugasEntity tugasEntity = new TugasEntity();
        tugasEntity.setId_tugas(id_tugas);
        tugasEntity.setId_matkul(id_matkul);
        tugasEntity.setNim_dosen(nim_dosen);
        tugasEntity.setNama_tugas(nama_tugas);
        tugasEntity.setNilai_tugas(nilai_tugas);
        AllObjectModel.tugasModel.updateTugas(tugasEntity);
    }

    public void deleteTugas(int id_tugas){AllObjectModel.tugasModel.deleteTugas(id_tugas);}

    public DefaultTableModel daftarTugas(){
        DefaultTableModel dataDaftarTugas = new DefaultTableModel();
        Object[] kolom = {"ID_TUGAS","ID_MATKUL","NIM_DOSEN","NAMA_TUGAS","NILAI_TUGAS"};
        dataDaftarTugas.setColumnIdentifiers(kolom);
        int size=getALLTugas().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[7];
            data[0]=AllObjectModel.tugasModel.getALLTugas().get(i).getId_tugas();
            data[1]=AllObjectModel.tugasModel.getALLTugas().get(i).getId_matkul();
            data[2]=AllObjectModel.tugasModel.getALLTugas().get(i).getNim_dosen();
            data[3]=AllObjectModel.tugasModel.getALLTugas().get(i).getNama_tugas();
            data[4]=AllObjectModel.tugasModel.getALLTugas().get(i).getNilai_tugas();
            dataDaftarTugas.addRow(data);
        }
        return dataDaftarTugas;
    }
}
