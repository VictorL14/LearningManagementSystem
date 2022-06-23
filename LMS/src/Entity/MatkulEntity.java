package Entity;

public class MatkulEntity {
    protected int id_matkul;
    protected String nim_dosen;
    protected String nama_matkul;

    public MatkulEntity(int id_matkul, String nim_dosen, String nama_matkul){
        this.id_matkul = id_matkul;
        this.nim_dosen = nim_dosen;
        this.nama_matkul = nama_matkul;
    }

    public MatkulEntity(){
    }

    public int getId_matkul() {return id_matkul;}
    public String getNim_dosen() {
        return nim_dosen;
    }
    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setId_matkul(int id_matkul) {this.id_matkul = id_matkul;}
    public void setNim_dosen(String nim_dosen) {
        this.nim_dosen = nim_dosen;
    }
    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }
}
