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
public class SensorPeso extends Observador{
    private Peso pesoActual;

    public SensorPeso() {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
