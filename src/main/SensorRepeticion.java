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
public class SensorRepeticion extends Observador{
    private NumeroRepeticion numRepeticiones;

    public SensorRepeticion() {
    }
    
    public SensorRepeticion(NumeroRepeticion numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }

    public NumeroRepeticion getNumRepeticiones() { 
        return numRepeticiones;
    }

    public void setNumRepeticiones(NumeroRepeticion numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
