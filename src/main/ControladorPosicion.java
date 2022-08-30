/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class ControladorPosicion extends Controlador{
    
    public float distanciaRecorrida;
    SensorPosicion observador = new SensorPosicion();

    public ControladorPosicion(double umbral, float distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public float getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(float distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }
    
    
    
    

    @Override
    public void definirUmbral(double umbral) {
        
    }

    @Override
    public void ejecutarAccion() {
        
    }
    
}
