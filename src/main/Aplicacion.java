/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import areamaquinas.AreaMaquinas;
import com.formdev.flatlaf.FlatDarkLaf;
import cycling.Cycling;
import padel.Padel;
import trailrunning.TrailRunning;
import running.Running;

import javax.swing.*;

/**
 *
 * @author Frankz
 */
public class Aplicacion {

    private final Cycling cycling;
    Usuario usuario;
    MainFrame mainFrame;
    private Padel padel;
    private TrailRunning trailRunning;
    private AreaMaquinas areaMaquinas;
    private Running running;

    public static void main(String[] args) {
        new Aplicacion().iniciar();
    }

    public void iniciar() {
        mainFrame.setMainPanel(new ActividadesPane(mainFrame));
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
        trailRunning = new TrailRunning(this);
        cycling = new Cycling(this);
        areaMaquinas = new AreaMaquinas(this);
        running = new Running(this);
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

    public TrailRunning seleccionarTrailRunning() {
        return trailRunning;
    }

    public Running seleccionarRunning() {
        return running;
    }

    public AreaMaquinas seleccionarAreaMaquina() {
        return areaMaquinas;
    }

    public Cycling seleccionarCycling() {
        return cycling;
    }

}
