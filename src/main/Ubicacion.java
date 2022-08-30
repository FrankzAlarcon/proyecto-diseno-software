/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author green
 */
public class Ubicacion extends Observado {
    private double latitud;
    private double longitud;
    private double elevacion;
    public SensorUbicacion sensor;

    public Ubicacion(SensorUbicacion sensor) {
        this.sensor = sensor;
    }

    @Override
    public void notificar() {
       
    }
    
}
