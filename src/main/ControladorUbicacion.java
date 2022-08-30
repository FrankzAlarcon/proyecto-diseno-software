/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author green
 */
public class ControladorUbicacion extends Controlador{
    
    private double umbral;
    SensorUbicacion sensor;
    Ubicacion anterior;
    Ubicacion actual;
    
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void ejecutarAccion() {
        
    }
    
}
