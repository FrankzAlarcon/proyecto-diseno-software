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
public class ControladorPeso extends Controlador{
    
    
    public ControladorPeso(double umbral, SensorPeso sensor) {
        this.umbral = umbral;
        this.sensor = new SensorPeso();
    }    

    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        SensorPeso sensor = (SensorPeso) this.sensor;
        //System.out.println(sensor.getUbicacionAnterior() + " " + sensor.getUbicacionActual());
        
        //System.out.println("Acción ejecutada: " +tempDistance);
        if(sensor.getPesoActual().getValor() >= umbral){
            action.exec();
        }
    }
        
}
