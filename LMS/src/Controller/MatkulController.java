package Controller;
import Entity.MatkulEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
public class MatkulController {
    public ArrayList<MatkulEntity> getAllMatkul(){return AllObjectModel.matkulModel.getALLMatkul();}

    public void insertMatkul(int id_matkul, String nim_dosen, String nama_matkul){
        MatkulEntity matkulEntity = new MatkulEntity();
        matkulEntity.setId_matkul(id_matkul);
        matkulEntity.setNim_dosen(nim_dosen);
        matkulEntity.setNama_matkul(nama_matkul);
        AllObjectModel.matkulModel.insertMatkul(matkulEntity);
    }

    public void updateMatkul(int id_matkul, String nim_dosen, String nama_matkul){
        MatkulEntity matkulEntity = new MatkulEntity();
        matkulEntity.setId_matkul(id_matkul);
        matkulEntity.setNim_dosen(nim_dosen);
        matkulEntity.setNama_matkul(nama_matkul);
        AllObjectModel.matkulModel.updateMatkul(matkulEntity);
    }

    public void deleteMatkul(int id_matkul){AllObjectModel.matkulModel.deleteMatkul(id_matkul);}

    public DefaultTableModel daftarMatkul(){
        DefaultTableModel dataDaftarMatkul = new DefaultTableModel();
        Object[] kolom = {"ID_MATKUL","NIM_DOSEN","NAMA_MATKUL"};
        dataDaftarMatkul.setColumnIdentifiers(kolom);
        int size=getAllMatkul().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[7];
            data[0]=AllObjectModel.matkulModel.getALLMatkul().get(i).getId_matkul();
            data[1]=AllObjectModel.matkulModel.getALLMatkul().get(i).getNim_dosen();
            data[2]=AllObjectModel.matkulModel.getALLMatkul().get(i).getNama_matkul();
            dataDaftarMatkul.addRow(data);
        }
        return dataDaftarMatkul;
    }
}
