/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;
import form.LoginForm;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {

        // to set FlatLaft Look and Feel for JFrames
        FlatLightLaf.setup();

        new LoginForm().setVisible(true);
    }
}
