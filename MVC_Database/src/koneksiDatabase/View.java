package koneksiDatabase;

import java.awt.Color;
import static java.awt.SystemColor.window;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel title;

    JLabel lNim = new JLabel("NIM        :  ");
    JTextField tfnim = new JTextField();
    JLabel lNamaMhs = new JLabel("Nama Mahasiswa :  ");
    JTextField tfNamaMhs = new JTextField();
    JLabel lAlamatMhs = new JLabel("Alamat Mahasiswa :  ");
    JTextField tfAlamatMhs = new JTextField();

    JLabel lNimUpdate = new JLabel("NIM        :  ");
    //JTextField tfnimUpdate = new JTextField();
    JLabel lNamaMhsUpdate = new JLabel("Nama Mahasiswa :  ");
    JTextField tfNamaMhsUpdate = new JTextField();
    JLabel lAlamatMhsUpdate = new JLabel("Alamat Mahasiswa :  ");
    JTextField tfAlamatMhsUpdate = new JTextField();

    JComboBox daftarNim = new JComboBox();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnUpdatePanel = new JButton("Update");
    JButton btnCancelPanel = new JButton("Cancel");

    JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama","Alamat"};

    public View() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 500);

        title = new JLabel("Data Mahasiswa");
        add(title);
        title.setBounds(200, 5, 100, 20);

        title = new JLabel("Tambah Data");
        add(title);
        title.setBounds(100, 35, 100, 20);

        title = new JLabel("Update Data");
        add(title);
        title.setBounds(350, 35, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(20,195,480,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lNim);
        lNim.setBounds(20,65,90,20);
        add(tfnim);
        tfnim.setBounds(110, 65, 120,20);
        add(lNamaMhs);
        lNamaMhs.setBounds(20, 90, 90, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(110, 90, 120, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(20, 115, 90, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(110, 115, 120, 20);

        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 155, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 155, 90, 20);


        add(lNimUpdate);
        lNimUpdate.setBounds(270,65,90,20);
        add(daftarNim);
        daftarNim.setBounds(360, 65, 120, 20);
        add(lNamaMhsUpdate);
        lNamaMhsUpdate.setBounds(270, 90, 90, 20);
        add(tfNamaMhsUpdate);
        tfNamaMhsUpdate.setBounds(360, 90, 120, 20);
        add(lAlamatMhsUpdate);
        lAlamatMhsUpdate.setBounds(270, 115, 90, 20);
        add(tfAlamatMhsUpdate);
        tfAlamatMhsUpdate.setBounds(360, 115, 120, 20);

        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(270, 155, 90, 20);
        add(btnCancelPanel);
        btnCancelPanel.setBounds(380, 155, 90, 20);
    }


    public String getNim() {
        return tfnim.getText();
    }

    public String getNamaMhs() {
        return tfNamaMhs.getText();
    }

    public String getAlamatMhs() {
        return tfAlamatMhs.getText();
    }

    public String getNimMhsCombo(){
        return daftarNim.getSelectedItem().toString();
    }

    public String getNamaMhsUpdate(){
        return tfNamaMhsUpdate.getText();
    }

    public String getAlamatMhsUpdate(){
        return tfAlamatMhsUpdate.getText();
    }
}
