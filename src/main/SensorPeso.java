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
public class SensorPeso extends Sensor {
    private Peso pesoActual;

    public SensorPeso() {
        this.pesoActual = null;
    }

    
    public SensorPeso(Peso pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Peso getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Peso pesoActual) {
        this.pesoActual = pesoActual;
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
