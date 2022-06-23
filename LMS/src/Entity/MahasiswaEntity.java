package Entity;

public class MahasiswaEntity {
    protected String npm_mahasiswa;
    protected String nama_mahasiswa;
    protected String notelp_mahasiswa;

    public MahasiswaEntity(String npm_mahasiswa, String nama_mahasiswa, String notelp_mahasiswa){
        this.npm_mahasiswa = npm_mahasiswa;
        this.nama_mahasiswa = nama_mahasiswa;
        this.notelp_mahasiswa = notelp_mahasiswa;
    }

    public MahasiswaEntity(){

    }

    public String getNpm_mahasiswa() {
        return npm_mahasiswa;
    }
    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }
    public String getNotelp_mahasiswa() {
        return notelp_mahasiswa;
    }

    public void setNpm_mahasiswa(String npm_mahasiswa) {
        this.npm_mahasiswa = npm_mahasiswa;
    }
    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }
    public void setNotelp_mahasiswa(String notelp_mahasiswa) {
        this.notelp_mahasiswa = notelp_mahasiswa;
    }
}
