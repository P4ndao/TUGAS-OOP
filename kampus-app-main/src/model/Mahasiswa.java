package model;

public class Mahasiswa {

    private String nim;
    public String getNim() {
        return nim;
    }

    private String nama;
    public String getNama() {
        return nama;
    }

    private String prodiId;
    public String getprodiId() {
        return prodiId;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Mahasiswa(String nim, String nama, String prodiId) {
        this.nim = nim;
        this.nama = nama;
        this.prodiId = prodiId;
    }
}
