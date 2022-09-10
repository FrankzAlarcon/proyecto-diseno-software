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
    private Repeticion repeticion;

    public SensorRepeticion() {
        this.repeticion = null;
    }
    
    public SensorRepeticion(Repeticion numRepeticiones) {
        this.repeticion = numRepeticiones;
    }

    public Repeticion getRepeticion() { 
        return repeticion;
    }

    public void setRepeticion(Repeticion numRepeticiones) {
        this.repeticion = numRepeticiones;
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
