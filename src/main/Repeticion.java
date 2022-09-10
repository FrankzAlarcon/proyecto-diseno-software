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
public class Repeticion extends Factor {
    private double distancia;
    SensorRepeticion sensor;

    public Repeticion() {
        this.distancia = 0;
        this.sensor = null;
    }
    public Repeticion(int numero) {
        this.distancia = numero;
        
    }
    
    public Repeticion(int valor,SensorRepeticion sensor) {
        this.distancia = valor;
        this.sensor = sensor;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double numero) {
        this.distancia = numero;
    }

    public SensorRepeticion getSensor() {
        return sensor;
    }

    public void setSensor(SensorRepeticion sensor) {
        this.sensor = sensor;
    }
        
    @Override
    public void notificar() {
       SensorRepeticion sensor = ((SensorRepeticion) this.sensor);
        distancia = Math.random()*10;
       
        sensor.actualizar();
    }
    
    
}
