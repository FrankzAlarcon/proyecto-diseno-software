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
public class NumeroRepeticion extends Observado{
    private int numero;
    SensorRepeticion sensor;

    public NumeroRepeticion() {
        this.numero = 0;
        this.sensor = null;
    }
    public NumeroRepeticion(int valor,SensorRepeticion sensor) {
        this.numero = valor;
        this.sensor = sensor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public SensorRepeticion getSensor() {
        return sensor;
    }

    public void setSensor(SensorRepeticion sensor) {
        this.sensor = sensor;
    }
    
    

    @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
