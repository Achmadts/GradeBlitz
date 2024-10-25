package models;

public class Kelas {
    private int id;
    private String namaKelas;

    public Kelas(int id, String namaKelas) {
        this.id = id;
        this.namaKelas = namaKelas;
    }

    public int getId() {
        return id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    @Override
    public String toString() {
        return namaKelas;  // Ini akan menampilkan nama kelas di ComboBox
    }
}
