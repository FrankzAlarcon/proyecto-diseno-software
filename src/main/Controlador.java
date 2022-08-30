/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Frankz
 */
public abstract class Controlador {
    private double umbral;
    
    Observador observador;
    
    public abstract void definirUmbral(double umbral);
    public abstract void ejecutarAccion();
}
