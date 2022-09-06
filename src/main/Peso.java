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
public class Peso extends Observado{
    private double valor;
    SensorPeso sensor;

    public Peso() {
        this.valor = 0.0; 
        this.sensor = null;
    } 
    public Peso(double valor, SensorPeso sensor) {
        this.valor = valor; 
        this.sensor = sensor;
    }    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public SensorPeso getSensor() {
        return sensor;
    }

    public void setSensor(SensorPeso sensor) {
        this.sensor = sensor;
    }    
    
        
    @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
