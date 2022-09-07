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
public abstract class Observado {
    Sensor sensor;
    
    public abstract void notificar();
    
    public void setSensor(Sensor sensor){
        sensor.observado = this;
        this.sensor = sensor;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
