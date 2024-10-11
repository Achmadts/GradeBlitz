package models;

public class InputDataGuruModel {

    private String nip;
    private String nama;
    private String email;
    private String password;
    private String guruMapel;
    
    public InputDataGuruModel(String nip, String nama, String email, String password, String guruMapel) {
        this.nip = nip;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.guruMapel = guruMapel;
    }
    
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGuruMapel() {
        return guruMapel;
    }

    public void setGuruMapel(String guruMapel) {
        this.guruMapel = guruMapel;
    }
}