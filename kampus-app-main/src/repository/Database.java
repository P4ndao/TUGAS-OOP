package repository;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import model.DBTables;
import model.Prodi;

public class Database {
    private Gson gson;
    private String namaFileDataMahasiswa = "db_kampusapp";
    protected DBTables tables = new DBTables();
    public MahasiswaTbl mahasiswaTbl = new MahasiswaTbl(this);
    
    private ArrayList<Prodi> prodiList = new ArrayList<>();

    

    public void addProdi(Prodi prodi) {
        prodiList.add(prodi);
    }

    public Prodi getProdiById(String prodiId) {
        for (Prodi prodi : prodiList) {
            if (prodi.getId().equals(prodiId)) {
                return prodi;
            }
        }
        return null;
    }

    public Database() {
        gson = new Gson();

        Prodi prodi1 = new Prodi("0001", "Sistem Informasi");
        Prodi prodi2 = new Prodi("0002", "Teknik Informatika");
        prodiList.add(prodi1);
        prodiList.add(prodi2);

        readDBFile();
    }
        

    protected void commit() {
        try (PrintWriter writer = new PrintWriter(new File(namaFileDataMahasiswa))) {
            writer.println(gson.toJson(tables));
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file: " + e.getMessage());
        }
    }

    private void readDBFile() {
        try (Scanner scanner = new Scanner(new File(namaFileDataMahasiswa))) {
            while (scanner.hasNextLine()) {
                String jsonString = scanner.nextLine();
                tables = gson.fromJson(jsonString, DBTables.class);
            }
        } catch (IOException e) {
            
        }
    }
}
