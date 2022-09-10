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
public class ControladorRepeticion extends Controlador{

    public ControladorRepeticion(double umbral, SensorRepeticion sensor) {
        this.umbral = umbral;
        this.sensor = new SensorRepeticion();
    }
    
    @Override
    public void definirUmbral(double umbral) {
       this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
         SensorRepeticion sensor = (SensorRepeticion) this.sensor;
        
        if(sensor.getRepeticion().getDistancia() >= umbral){
            action.exec();
        }
    }

    public double getUmbral() {
        return umbral;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public DefinableAction getAction() {
        return action;
    }

    public void setAction(DefinableAction action) {
        this.action = action;
    }
    
    
}
