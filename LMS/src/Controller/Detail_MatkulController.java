package Controller;
import Entity.Detail_MatkulEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
public class Detail_MatkulController {
    public ArrayList<Detail_MatkulEntity> getAllDetMat(){return AllObjectModel.detail_matkulModel.getALLDetMat();}

    public void insertDetMat(int id_matkul, String npm_mahasiswa, String jumlah_sks){
        Detail_MatkulEntity detail_matkulEntity = new Detail_MatkulEntity();
        detail_matkulEntity.setId_matkul(id_matkul);
        detail_matkulEntity.setNpm_mahasiswa(npm_mahasiswa);
        detail_matkulEntity.setJumlah_sks(jumlah_sks);
        AllObjectModel.detail_matkulModel.insertDetMat(detail_matkulEntity);
    }

    public void updateDetMat(int id_matkul, String npm_mahasiswa, String jumlah_sks){
        Detail_MatkulEntity detail_matkulEntity = new Detail_MatkulEntity();
        detail_matkulEntity.setId_matkul(id_matkul);
        detail_matkulEntity.setNpm_mahasiswa(npm_mahasiswa);
        detail_matkulEntity.setJumlah_sks(jumlah_sks);
        AllObjectModel.detail_matkulModel.updateDetMat(detail_matkulEntity);
    }

    public void deleteDetMat(int id_matkul){AllObjectModel.detail_matkulModel.deleteDetMat(id_matkul);}

    public DefaultTableModel daftarDetMat(){
        DefaultTableModel dataDaftarDetMat = new DefaultTableModel();
        Object[] kolom = {"ID_MATKUL","NPM_MAHASISWA","JUMLAH_SKS"};
        dataDaftarDetMat.setColumnIdentifiers(kolom);
        int size=getAllDetMat().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[7];
            data[0]=AllObjectModel.detail_matkulModel.getALLDetMat().get(i).getId_matkul();
            data[1]=AllObjectModel.detail_matkulModel.getALLDetMat().get(i).getNpm_mahasiswa();
            data[2]=AllObjectModel.detail_matkulModel.getALLDetMat().get(i).getJumlah_sks();
            dataDaftarDetMat.addRow(data);
        }
        return dataDaftarDetMat;
    }
}
