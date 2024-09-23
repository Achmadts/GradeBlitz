/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Guru.HomeGuru;
import javax.swing.table.DefaultTableModel;
import models.GuruModel;
//import views.GuruView;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Achmad
 */
public class GuruController {

    private GuruModel model;
    private HomeGuru home;

    public GuruController(HomeGuru home, int userId) {
        this.home = home;
        this.model = new GuruModel(userId);
    }
}
