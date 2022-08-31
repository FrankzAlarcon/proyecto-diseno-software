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
    private ControladorUbicacion controlador;
    public SensorUbicacion() {
        ubicacion = new Ubicacion(this);
    }

    @Override
    public void actualizar() {
        
    }
    
}
