/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.formdev.flatlaf.FlatDarkLaf;
import padel.Padel;

import javax.swing.*;

/**
 *
 * @author Frankz
 */
public class Aplicacion {
    Usuario usuario; 
    MainFrame mainFrame;
    private Padel padel;

    public static void main(String[] args) {
        new Aplicacion().iniciar();
    }

    public void iniciar(){
        mainFrame.setMainPanel(new LogIn(mainFrame));
        mainFrame.setVisible(true);

    }


    public Aplicacion() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        mainFrame = new MainFrame(this);
        usuario = new Usuario("Pepito Pistolas",
                23,
                160.26,
                1.85,
                'M'
                );
        padel = Padel.createInstance(this);
    }

    public void seleccionarArea() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Padel seleccionarPadel() {
        return padel;
    }
}
