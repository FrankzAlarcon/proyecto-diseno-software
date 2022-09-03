/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author green
 */
public class SensorUbicacion extends Observador{
    
    private Observado ubicacion;

    public SensorUbicacion() {

    }

    public void setUbicacion(Observado ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void actualizar() {
        
    }
    
}
