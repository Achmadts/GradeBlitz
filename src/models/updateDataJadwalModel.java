package models;

public class updateDataJadwalModel {

    private int jadwalId;
    private String guru, mapel, hari, jam, ruang, nip;

    public updateDataJadwalModel(int jadwalId, String nip, String mapel, String hari, String jam, String ruang) {
        this.jadwalId = jadwalId;
        this.nip = nip;
        this.mapel = mapel;
        this.hari = hari;
        this.jam = jam;
        this.ruang = ruang;
    }

    // Getters
    public int getJadwalId() {
        return jadwalId;
    }

    public String getNip() {
        return nip;
    }

    public String getMapel() {
        return mapel;
    }

    public String getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }

    public String getRuang() {
        return ruang;
    }

    // Setters
    public void setJadwalId(int jadwalId) {
        this.jadwalId = jadwalId;
    }

    public void setGuru(String guru) {
        this.guru = nip;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }
}
