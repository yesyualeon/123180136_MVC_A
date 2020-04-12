package koneksiDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Controller implements ActionListener {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0) {
            String dataMahasiswa[][] = model.readMahasiswa();
            view.tabel.setModel((new JTable(dataMahasiswa, view.namaKolom)).getModel());
            updateDataCombo(model.readNim());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.btnTambahPanel.addActionListener(this);
        view.btnBatalPanel.addActionListener(this);
        view.btnUpdatePanel.addActionListener(this);
        view.btnCancelPanel.addActionListener(this);


        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();

                String dataterpilih = view.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus NIM" + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deleteMahasiswa(dataterpilih);
                    String dataMahasiswa[][] = model.readMahasiswa();
                    view.tabel.setModel(new JTable(dataMahasiswa, view.namaKolom).getModel());
                    updateDataCombo(model.readNim());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }

       // view.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.btnTambahPanel) {
                    String nim = view.getNim();
                    String nama = view.getNamaMhs();
                    String alamat = view.getAlamatMhs();

                    if (nim.equals("")){
                        JOptionPane.showMessageDialog(null, "Nim Tidak Boleh Kosong");
                    } else if (nim.length() != 9){
                        JOptionPane.showMessageDialog(null, "Nim Harus 9 Digit");
                    } else {
                        model.insertMahasiswa(nim, nama, alamat);
                        String newData[][] = model.readMahasiswa();
                        view.tabel.setModel(new JTable(newData, view.namaKolom).getModel());
                        updateDataCombo(model.readNim());
                    }
                } else if (e.getSource() == view.btnBatalPanel){
                    view.tfnim.setText("");
                    view.tfNamaMhs.setText("");
                    view.tfAlamatMhs.setText("");
                } else if (e.getSource() == view.btnUpdatePanel){
                    String nim = view.getNimMhsCombo();
                    String nama = view.getNamaMhsUpdate();
                    String alamat = view.getAlamatMhsUpdate();

                    if (nama.equals("") || alamat.equals("")){
                        JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong");
                    } else {
                        model.updateMahasiswa(nim, nama, alamat);
                        String newData[][] = model.readMahasiswa();
                        view.tabel.setModel(new JTable(newData, view.namaKolom).getModel());
                        updateDataCombo(model.readNim());
                    }
                } else if (e.getSource() == view.btnCancelPanel){
                    view.tfNamaMhsUpdate.setText("");
                    view.tfAlamatMhsUpdate.setText("");
                }
            }
       // });



    public void updateDataCombo(ArrayList<String> data){
        view.daftarNim.removeAllItems();
        for (String item : data) {
            view.daftarNim.addItem(item);
        }
    }
}
