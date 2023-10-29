package model;

public class Prodi {
    private String id;
    private String nama;

    public Prodi(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}