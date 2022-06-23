package Main;
import java.util.HashMap;
import java.util.Scanner;

import Controller.*;
import Entity.DosenEntity;
import Entity.MahasiswaEntity;
import Entity.MatkulEntity;
import Entity.TugasEntity;
import Model.DosenModel;

public class Si_LMS {
    public static Scanner input = new Scanner(System.in);
    public static TugasController tugasController = new TugasController();
    public static MatkulController matkulController = new MatkulController();
    public static MahasiswaController mahasiswaController = new MahasiswaController();
    public static DosenController dosenController = new DosenController();
    public static Detail_TugasController detail_tugasController = new Detail_TugasController();
    public static Detail_MatkulController detail_matkulController = new Detail_MatkulController();

    public static void main(String[] args) {
        /*do{
            System.out.println("Learning Management System");
            System.out.println("LOGIN as");
            System.out.println("1. DOSEN");
            System.out.println("2. MAHASISWA");
            System.out.println("3. KELUAR");
            System.out.println("Masukan Pilihan : ");
            pilih = input.nextInt();
            input.nextLine();
            switch(pilih){
                case 1 : loginDosen();break;
                case 2 : loginMahasiswa();break;
                case 3 : System.out.println("Berhasil keluar");
            }
        }while(pilih <=2);*/
        System.out.println("===Learning Management System===");
        System.out.println("Login Admin");
        String nama, password;
        System.out.println("Masukkan nama: ");
        nama = input.nextLine();
        System.out.println("Masukkan Password: ");
        password = input.nextLine();
        if (nama != "admin" && password != "admin") {
            System.out.println("Berhasil Login");
            menu();
        } else {
            System.out.println("Gagal Login");
        }

    }

    static void menu() {
        int pil;
        do {
            System.out.println("~~MENU SISTEM INFORMASI~~");
            System.out.println("1. Lihat Daftar Tugas");
            System.out.println("2. Lihat Daftar Mata Kuliah");
            System.out.println("3. Lihat Daftar Dosen");
            System.out.println("4. Lihat Daftar Mahasiswa");
            System.out.println("5. Lihat Tugas");
            System.out.println("6. Mengisi Data Tugas");
            System.out.println("7. Mengisi Data Mata Kuliah");
            System.out.println("0. Log Out");
            System.out.println("Masukkan Inputan: ");
            pil = input.nextInt();
            switch (pil) {
                case 1 -> showDataTugas();
                case 2 -> showDataMatkul();
                case 3 -> showDataDosen();
                case 4 -> showDataMahasiswa();
                case 5 -> lihatTugas();
                case 6 -> insertTugas();
                case 7 -> insertMatkul();
            }
        } while (pil != 0);
    }

    static void loginDosen(){
        System.out.println("nama : ");
        String nama = input.next();
        System.out.println("nim : ");
        String nim = input.next();
        int cek = dosenController.loginDosen(nama,nim);
        if(cek != 0){
            System.out.println("berhasil login");
        }else{
            System.out.println("gagal login");
        }
    }

    static void loginMahasiswa(){
        System.out.println("nama : ");
        String nama = input.nextLine();
        System.out.println("npm : ");
        String npm = input.nextLine();
        int cek = mahasiswaController.loginMahasiswa(nama, npm);
        if(cek != 0){
            System.out.println("berhasil login");
            lihatnpm();
        }else{
            System.out.println("gagal login");
        }
    }

    static void lihatnpm(){
        System.out.print("Masukkan npm anda : ");
        String npm = input.nextLine();
        int cek = mahasiswaController.lihatnpm(npm);
        if(cek > 0){
            System.out.println("Data Tersedia");
            //showData(cek);
        }else{
            System.out.println("Data Tidak Tersedia");
        }
    }

    static void showDataTugas(){
        for(TugasEntity tugasEntity : tugasController.getALLTugas()){
            System.out.println("--------------------------------------------------");
            System.out.println("ID TUGAS        :" + tugasEntity.getId_tugas());
            System.out.println("ID MATA KULIAH  :" + tugasEntity.getId_matkul());
            System.out.println("NIM DOSEN       :" + tugasEntity.getNim_dosen());
            System.out.println("NAMA TUGAS      :" + tugasEntity.getNama_tugas());
            System.out.println("NILAI TUGAS     :" + tugasEntity.getNilai_tugas());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("=======================================================");
    }

    static void showDataMatkul(){
        for(MatkulEntity matkulEntity : matkulController.getAllMatkul()){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("ID MATA KULIAH      :" + matkulEntity.getId_matkul());
            System.out.println("NIM DOSEN           :" + matkulEntity.getNim_dosen());
            System.out.println("NAMA MATA KULIAH    :" + matkulEntity.getNama_matkul());
        }
        System.out.println("=======================================================");
    }

    static void showDataDosen(){
        for(DosenEntity dosenEntity : dosenController.getAllDosen()){
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("NIM DOSEN           :" + dosenEntity.getNim_dosen());
            System.out.println("NAMA DOSEN          :" + dosenEntity.getNama_dosen());
            System.out.println("NO TELEPON DOSEN    :" + dosenEntity.getNotelp_dosen());
        }
        System.out.println("=======================================================");
    }

    static void showDataMahasiswa(){
        for(MahasiswaEntity mahasiswaEntity : mahasiswaController.getAllMahasiswa()){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("NAMA MAHASISWA       :" + mahasiswaEntity.getNama_mahasiswa());
            System.out.println("NPM MAHASISWA        :" + mahasiswaEntity.getNpm_mahasiswa());
            System.out.println("NO TELEPON MAHASISWA :" + mahasiswaEntity.getNotelp_mahasiswa());
        }
    }

    static void lihatTugas(){
        DosenModel tk = new DosenModel();
        HashMap<String,String> ntx = tk.tugaskelas();
        int size = tk.getAllDosen().size();
        for(int i=0; i<size/24; i++){
            System.out.println("==========================");
            System.out.println("NIM DOSEN       :" + ntx.get("nim_dosen"));
            System.out.println("NAMA DOSEN      :" + ntx.get("nama_dosen"));
            System.out.println("NAMA TUGAS      :" + ntx.get("nama_tugas"));
            System.out.println("NPM MAHASISWA   :" + ntx.get("npm_mahasiswa"));
            System.out.println("NAMA MAHASISWA  :" + ntx.get("nama_mahasiswa"));
        }
        System.out.println("==========================");
    }

    static void insertTugas(){
        System.out.println("Id Tugas : ");
        int id_tugas = input.nextInt();
        input.nextLine();
        System.out.println("Id Mata Kuliah : ");
        int id_matkul = input.nextInt();
        input.nextLine();
        System.out.println("NIM Dosen : ");
        String nim_dosen = input.nextLine();
        System.out.println("Nama Tugas : ");
        String nama_tugas = input.nextLine();
        System.out.println("Nilai Tugas : ");
        String nilai_tugas = input.nextLine();
        System.out.println("==========================");
        tugasController.insertTugas(id_tugas,id_matkul,nim_dosen,nama_tugas,nilai_tugas);
    }

    static void insertMatkul(){
        System.out.println("Id Mata Kuliah : ");
        int id_matkul = input.nextInt();
        input.nextLine();
        System.out.println("NIM Dosen : ");
        String nim_dosen = input.nextLine();
        System.out.println("Nama Mata Kuliah : ");
        String nama_matkul = input.nextLine();
        System.out.println("==========================");
        matkulController.insertMatkul(id_matkul,nim_dosen,nama_matkul);
    }
}



