import java.util.Scanner;

public class Hitung_Nilai_Mahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan nilai tubes: ");
        int nilaiTubes = scanner.nextInt();

        System.out.print("Masukkan nilai quiz: ");
        int nilaiQuiz = scanner.nextInt();

        System.out.print("Masukkan nilai tugas: ");
        int nilaiTugas = scanner.nextInt();

        System.out.print("Masukkan nilai UTS: ");
        int nilaiUTS = scanner.nextInt();

        System.out.print("Masukkan nilai UAS: ");
        int nilaiUAS = scanner.nextInt();

        int totalNilai = (int) ((0.3 * nilaiTubes) + (0.1 * nilaiQuiz) + (0.1 * nilaiTugas) + (0.25 * nilaiUTS) + (0.25 * nilaiUAS));

        System.out.println("\nNama : " + nama);
        System.out.println("NIM    : " + nim);
        System.out.println("Nilai Matakuliah Pemograman Berorientasi Objek : " + totalNilai);
    }
}