package models;

public class updateDataKelasModel {

    private int kelasId;
    private String namaKelas, jurusan;
    private int genId;

    public updateDataKelasModel(int kelasId, String namaKelas, String jurusan, int genId) {
        this.kelasId = kelasId;
        this.namaKelas = namaKelas;
        this.jurusan = jurusan;
        this.genId = genId;
    }

    // Getters
    public int getKelasId() {
        return kelasId;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public int getGenId() {
        return genId;
    }

    // Setters
    public void setKelasId(int kelasId) {
        this.kelasId = kelasId;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setGenId(int genId) {
        this.genId = genId;
    }
}
