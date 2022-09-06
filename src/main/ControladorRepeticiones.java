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
public class ControladorRepeticiones extends Controlador{

    public ControladorRepeticiones(double umbral, SensorRepeticion sensor) {
        this.umbral = umbral;
        this.observador = sensor;
    }
    
    @Override
    public void definirUmbral(double umbral) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejecutarAccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
