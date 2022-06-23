package Entity;

public class Detail_TugasEntity {
    protected int id_tugas;
    protected String npm_mahasiswa;
    protected String jumlah_tugas;

    public Detail_TugasEntity(int id_tugas, String npm_mahasiswa, String jumlah_tugas){
        this.id_tugas = id_tugas;
        this.npm_mahasiswa = npm_mahasiswa;
        this.jumlah_tugas = jumlah_tugas;
    }

    public Detail_TugasEntity(){
    }

    public int getId_tugas() {return id_tugas;}
    public String getNpm_mahasiswa() {
        return npm_mahasiswa;
    }
    public String getJumlah_tugas() {
        return jumlah_tugas;
    }

    public void setId_tugas(int id_tugas) {this.id_tugas = id_tugas;}
    public void setNpm_mahasiswa(String npm_mahasiswa) {this.npm_mahasiswa = npm_mahasiswa;}
    public void setJumlah_tugas(String jumlah_tugas) {this.jumlah_tugas = jumlah_tugas;}
}
