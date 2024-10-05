/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.TataUsahaModel;
import TataUsaha.HomeTataUsaha;
import TataUsaha.HomeTataUsaha;
import java.awt.Component;
import javax.swing.JOptionPane;
import loginandsignup.LoginOld;

/**
 *
 * @author Achmad
 */
public class TataUsahaController {

    private TataUsahaModel model;
    private HomeTataUsaha home;

    public TataUsahaController(HomeTataUsaha home, int userId) {
        this.home = home;
        this.model = new TataUsahaModel(userId);
    }
}
