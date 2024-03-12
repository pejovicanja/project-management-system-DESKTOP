/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;
import form.ServerForm;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {
        try {
            // to set FlatLaft Look and Feel for JFrames
            FlatLightLaf.setup();
            new ServerForm().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error starting server application", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
