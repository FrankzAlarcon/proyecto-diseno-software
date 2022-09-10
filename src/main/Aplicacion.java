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

    private Cycling cycling;
    private Usuario usuario;
    private Padel padel;
    private TrailRunning trailRunning;
    private AreaMaquinas areaMaquinas;
    private Running running;

    public Aplicacion() {
        padel = Padel.createInstance(this);
        trailRunning = new TrailRunning(this);
        cycling = new Cycling(this);
        areaMaquinas = new AreaMaquinas(this);
        running = new Running(this);
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.usuario.setAplicacion(this);
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
