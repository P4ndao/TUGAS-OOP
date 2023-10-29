import java.util.Scanner;

import model.Mahasiswa;
import model.Prodi;
import repository.Database;

public class KampusApp {
    public static void main(String[] arg) {
        KampusApp kampusApp = new KampusApp();
        kampusApp.showMenu();
    }

    private Scanner scanner;
    private Database db;

    public KampusApp() {
        scanner = new Scanner(System.in);
        db = new Database();
    }

    public void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("Selamat Datang di Aplikasi Kampus");
        System.out.println("Pilihan Menu:");
        System.out.println("1 -> Tambah Data Mahasiswa");
        System.out.println("2 -> Ubah Data Mahasiswa");
        System.out.println("3 -> Hapus Data Mahasiswa");
        System.out.println("4 -> Cari Data Mahasiswa");
        System.out.println("0 -> Keluar Aplikasi");
        System.out.print("Silahkan masukan menu yang dipilih: ");
        int menuYangDipilih = scanner.nextInt();
        scanner.nextLine();
        switch(menuYangDipilih) {
            case 1:
            menuTambah();
            break;
            case 2:
            menuUbah();
            break;
            case 3:
            menuHapus();
            break;
            case 4:
            menuCari();
            break;
            default: {
                System.out.print("* Terimakasih sudah menggunakan Aplikasi Kampus *");
                System.exit(0);
            }
            break;
        }
        scanner.close();
    }

    public void menuTambah() {
        System.out.println("----- Menu Tambah Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukan ID Prodi: ");
        String prodiId = scanner.nextLine();
        scanner.nextLine();

        Prodi prodi = db.getProdiById(prodiId);
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodiId);
        db.mahasiswaTbl.create(mahasiswa);
        System.out.println("Data Mahasiswa berhasil ditambahkan.");


        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuUbah() {
        System.out.println("----- Menu Ubah Data Mahasiswa -----");
        System.out.print("Masukan NIM Sebelumnya: ");
        String nimLama = scanner.nextLine();
        System.out.print("Masukan NIM: ");
        String nimBaru = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukan ID Prodi: ");
        String prodiId = scanner.nextLine();
        scanner.nextLine();

        Prodi prodi = db.getProdiById(prodiId);
        if (prodi != null) {
            Mahasiswa mahasiswa = new Mahasiswa(nimBaru, nama, prodiId);
            db.mahasiswaTbl.update(nimLama, mahasiswa);
            System.out.println("Data Mahasiswa berhasil diubah.");
        } else {
            System.out.println("Prodi dengan ID " + prodiId + " tidak ditemukan.");
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuCari(){
        System.out.println("----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        Mahasiswa mahasiswa = db.mahasiswaTbl.getMahasiswaByNim(nim);
        if (mahasiswa == null) {
            System.out.println("* NIM tidak ditemukan *");
        } else {
            Prodi prodi = db.getProdiById(mahasiswa.getprodiId());
    
            if (prodi != null) {
                System.out.println("* NIM: " + mahasiswa.getNim() + " *");
                System.out.println("* Nama: " + mahasiswa.getNama() + " *");
                System.out.println("* Prodi: " + prodi.getNama() + " *");
            } else {
                System.out.println("* NIM: " + mahasiswa.getNim() + " *");
                System.out.println("* Nama: " + mahasiswa.getNama() + " *");
                System.out.println("* Prodi tidak ditemukan *");
            }
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapus() {
        System.out.println("----- Menu Hapus Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        db.mahasiswaTbl.delete(nim);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }
}