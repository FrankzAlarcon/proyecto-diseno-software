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
public abstract class Controlador {
    protected double umbral;
    
    Sensor sensor;
    DefinableAction action;
    public abstract void definirUmbral(double umbral);
    public abstract void verificarUmbral();
    public void setAction(DefinableAction action){
        this.action = action;
    }

    public void setSensor(Sensor sensor){
        this.sensor = sensor;
    }
    public Sensor getSensor(){
        return sensor;
    }
}
