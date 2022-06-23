package Controller;
import Entity.DosenEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class DosenController {
    public ArrayList<DosenEntity> getAllDosen(){return AllObjectModel.dosenModel.getAllDosen();}

    public void insertDosen(String nim_dosen, String nama_dosen, String notelp_dosen){
        DosenEntity dosenEntity = new DosenEntity();
        dosenEntity.setNim_dosen(nim_dosen);
        dosenEntity.setNama_dosen(nama_dosen);
        dosenEntity.setNotelp_dosen(notelp_dosen);
        AllObjectModel.dosenModel.insertDosen(dosenEntity);
    }

    public void updateDosen(String nim_dosen, String nama_dosen, String notelp_dosen){
        DosenEntity dosenEntity = new DosenEntity();
        dosenEntity.setNim_dosen(nim_dosen);
        dosenEntity.setNama_dosen(nama_dosen);
        dosenEntity.setNotelp_dosen(notelp_dosen);
        AllObjectModel.dosenModel.updateDosen(dosenEntity);
    }

    public void deleteDosen(String nim_dosen){AllObjectModel.dosenModel.deleteDosen(nim_dosen);}

    public int loginDosen(String nama, String nim) {
        int log = AllObjectModel.dosenModel.cekLoginDosen(nama, nim);
        return log;
    }

    public DefaultTableModel daftarDosen(){
        DefaultTableModel dataDaftarDosen = new DefaultTableModel();
        Object[] kolom = {"NIM_DOSEN","NAMA_DOSEN","NOTELP_DOSEN"};
        dataDaftarDosen.setColumnIdentifiers(kolom);
        int size=getAllDosen().size();
        for(int i = 0; i< size ;i++){
            Object []data=new Object[7];
            data[0]=AllObjectModel.dosenModel.getAllDosen().get(i).getNim_dosen();
            data[1]=AllObjectModel.dosenModel.getAllDosen().get(i).getNama_dosen();
            data[2]=AllObjectModel.dosenModel.getAllDosen().get(i).getNotelp_dosen();
            dataDaftarDosen.addRow(data);
        }
        return dataDaftarDosen;
    }
}
