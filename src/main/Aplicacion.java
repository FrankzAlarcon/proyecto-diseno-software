/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import padel.Padel;

/**
 *
 * @author Frankz
 */
public class Aplicacion {
    Usuario usuario;
    Padel padel;
    MainFrame mainFrame;

    public Aplicacion() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }catch (Exception e){
            e.printStackTrace();
        }
        mainFrame = new MainFrame(this);
    }

    public void iniciar(){
        mainFrame.setMainPanel(new LogIn(mainFrame));
        mainFrame.setVisible(true);
    }
    
    public void seleccionarArea() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static void main(String[] args) {
        new Aplicacion().iniciar();
    }
    
}
