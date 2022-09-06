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
public class ControladorRepeticiones extends Controlador{

    public ControladorRepeticiones(double umbral, SensorRepeticion sensor) {
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
        
        if(sensor.getNumRepeticiones().getNumero() >= umbral){
            action.exec();
        }
    }
    
}
