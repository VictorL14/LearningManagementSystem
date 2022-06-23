package Entity;

public class Detail_MatkulEntity {
    protected int id_matkul;
    protected String npm_mahasiswa;
    protected String jumlah_sks;

    public Detail_MatkulEntity(int id_matkul, String npm_mahasiswa, String jumlah_sks){
        this.id_matkul = id_matkul;
        this.npm_mahasiswa = npm_mahasiswa;
        this.jumlah_sks = jumlah_sks;
    }

    public Detail_MatkulEntity(){
    }

    public int getId_matkul() {
        return id_matkul;
    }
    public String getNpm_mahasiswa() {
        return npm_mahasiswa;
    }
    public String getJumlah_sks() {
        return jumlah_sks;
    }

    public void setId_matkul(int id_matkul) {
        this.id_matkul = id_matkul;
    }
    public void setNpm_mahasiswa(String npm_mahasiswa) {
        this.npm_mahasiswa = npm_mahasiswa;
    }
    public void setJumlah_sks(String jumlah_sks) {
        this.jumlah_sks = jumlah_sks;
    }
}
