package Controller;
import Entity.Detail_TugasEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
public class Detail_TugasController {
    public ArrayList<Detail_TugasEntity> getAllDetTug(){return AllObjectModel.detail_tugasModel.getALLDetTug();}

    public void insertDetTug(int id_tugas, String npm_mahasiswa, String jumlah_tugas){
        Detail_TugasEntity detail_tugasEntity = new Detail_TugasEntity();
        detail_tugasEntity.setId_tugas(id_tugas);
        detail_tugasEntity.setNpm_mahasiswa(npm_mahasiswa);
        detail_tugasEntity.setJumlah_tugas(jumlah_tugas);
        AllObjectModel.detail_tugasModel.insertDetTug(detail_tugasEntity);
    }

    public void updateDetTug(int id_tugas, String npm_mahasiswa, String jumlah_tugas){
        Detail_TugasEntity detail_tugasEntity = new Detail_TugasEntity();
        detail_tugasEntity.setId_tugas(id_tugas);
        detail_tugasEntity.setNpm_mahasiswa(npm_mahasiswa);
        detail_tugasEntity.setJumlah_tugas(jumlah_tugas);
        AllObjectModel.detail_tugasModel.updateDetTug(detail_tugasEntity);
    }

    public void deleteDetTug(int id_tugas){AllObjectModel.detail_tugasModel.deleteDetTug(id_tugas);}

    public DefaultTableModel daftarDetTug(){
        DefaultTableModel dataDaftarDetTug = new DefaultTableModel();
        Object[] kolom = {"ID_TUGAS","NPM_MAHASISWA","JUMLAH_TUGAS"};
        dataDaftarDetTug.setColumnIdentifiers(kolom);
        int size=getAllDetTug().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[7];
            data[0]=AllObjectModel.detail_tugasModel.getALLDetTug().get(i).getId_tugas();
            data[1]=AllObjectModel.detail_tugasModel.getALLDetTug().get(i).getNpm_mahasiswa();
            data[2]=AllObjectModel.detail_tugasModel.getALLDetTug().get(i).getJumlah_tugas();
            dataDaftarDetTug.addRow(data);
        }
        return dataDaftarDetTug;
    }
}
