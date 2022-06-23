package Entity;

public class DosenEntity {
    protected String nim_dosen;
    protected String nama_dosen;
    protected String notelp_dosen;

    public DosenEntity(String nim_dosen, String nama_dosen, String notelp_dosen){
        this.nim_dosen = nim_dosen;
        this.nama_dosen = nama_dosen;
        this.notelp_dosen = notelp_dosen;
    }

    public DosenEntity(){
    }

    public String getNim_dosen() {
        return nim_dosen;
    }
    public String getNama_dosen() {
        return nama_dosen;
    }
    public String getNotelp_dosen() {
        return notelp_dosen;
    }

    public void setNim_dosen(String nim_dosen) {
        this.nim_dosen = nim_dosen;
    }

    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    public void setNotelp_dosen(String notelp_dosen) {
        this.notelp_dosen = notelp_dosen;
    }
}
