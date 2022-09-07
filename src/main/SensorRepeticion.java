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
public class SensorRepeticion extends Sensor {
    private NumeroRepeticion numRepeticiones;

    public SensorRepeticion() {
        this.numRepeticiones = null;
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
        controlador.verificarUmbral();
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
    
}
