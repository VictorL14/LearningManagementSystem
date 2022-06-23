package Entity;

public class TugasEntity {
    protected int id_tugas;
    protected int id_matkul;
    protected String nim_dosen;
    protected String nama_tugas;
    protected String nilai_tugas;

    public TugasEntity(int id_tugas, int id_matkul, String nim_dosen, String nama_tugas, String nilai_tugas){
        this.id_tugas = id_tugas;
        this.id_matkul = id_matkul;
        this.nim_dosen = nim_dosen;
        this.nama_tugas = nama_tugas;
        this.nilai_tugas = nilai_tugas;
    }

    public TugasEntity(){
    }

    public int getId_tugas() {
        return id_tugas;
    }
    public int getId_matkul() {
        return id_matkul;
    }
    public String getNim_dosen() {
        return nim_dosen;
    }
    public String getNama_tugas() {
        return nama_tugas;
    }
    public String getNilai_tugas() {
        return nilai_tugas;
    }

    public void setId_tugas(int id_tugas) {
        this.id_tugas = id_tugas;
    }
    public void setId_matkul(int id_matkul) {
        this.id_matkul = id_matkul;
    }
    public void setNim_dosen(String nim_dosen) {
        this.nim_dosen = nim_dosen;
    }
    public void setNama_tugas(String nama_tugas) {
        this.nama_tugas = nama_tugas;
    }
    public void setNilai_tugas(String nilai_tugas) {
        this.nilai_tugas = nilai_tugas;
    }
}
