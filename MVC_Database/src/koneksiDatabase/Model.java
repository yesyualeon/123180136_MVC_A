package koneksiDatabase;

import java.sql.Connection;
import  java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Model {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbprak";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public Model() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void  insertMahasiswa(String nim, String nama, String alamat) {
        try{
            String query = "INSERT INTO `mahasiswa` (`nim`, `nama`, `alamat`) VALUES ('"+nim+"','"+nama+"','"+alamat+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readMahasiswa() {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][3];

            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nim");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("alamat");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public ArrayList<String> readNim(){
        try{
            ArrayList<String> data = new ArrayList<>();
            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data.add(resultSet.getString("nim"));
            }
            return data;
        }catch (SQLException e) {
            return null;
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteMahasiswa (String nim) {
        try{
            String query = "DELETE FROM `mahasiswa` WHERE `nim` = '"+nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void updateMahasiswa(String nim, String nama, String alamat) {
        try{
            String query = "UPDATE `mahasiswa` set `nim`='"+nim+"', `nama`='"+nama+"', `alamat`='"+alamat+"' where nim='"+nim+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil DiUpdate");
            JOptionPane.showMessageDialog(null, "Database Updated Successfully");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
