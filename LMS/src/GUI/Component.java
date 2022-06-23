package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Component extends JFrame{
    //dashboard
    protected JLabel labellms = new JLabel("LEARNING MANAGEMENT SYSTEM");
    protected JButton btndosen = new JButton("DOSEN");
    protected JButton btnmhs = new JButton("MAHASISWA");

    //login
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelnpm = new JLabel("NPM MAHASISWA");
    protected JLabel labelnim = new JLabel("NIM DOSEN");
    protected JLabel labellogin = new JLabel("LOGIN");
    protected JLabel labeldosen = new JLabel("DOSEN");
    protected JLabel labelmhs = new JLabel("MAHASISWA");
    protected JButton btnlogin = new JButton("LOG IN");
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldnpm = new JTextField();
    protected JTextField fieldnim = new JTextField();

    //menudosen-tugas
    protected JButton btntambahtugas = new JButton("TAMBAH TUGAS");
    protected JButton btnedittugas = new JButton("EDIT TUGAS");
    protected JLabel labelnmtugas = new JLabel("NAMA TUGAS");
    protected JLabel labelnltugas = new JLabel("NILAI TUGAS");
    protected JTextField fieldnmtugas = new JTextField();
    protected JTextField fieldnltugas = new JTextField();

    //menumahasiswa
    protected JLabel labelmntugas = new JLabel("NILAI TUGAS");




}
