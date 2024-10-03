/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Achmad
 */
public class updateDataGuruModel {

    private String nip, full_name, email, password, guruMapel;

    public updateDataGuruModel(String nip, String full_name, String email, String password, String guruMapel) {
        this.nip = nip;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.guruMapel = guruMapel;
    }

    public String getNip() {
        return nip;
    }

    public String getFullName() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGuruMapel() {
        return guruMapel;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGuruMapel(String guruMapel) {
        this.guruMapel = guruMapel;
    }
}
