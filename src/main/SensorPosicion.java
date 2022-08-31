/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class SensorPosicion extends Observador{
    
    private Posicion ultimaPosicion;
    
    public SensorPosicion(Posicion observado) {
        this.observado = observado;
        this.ultimaPosicion = observado;
    }

    public Posicion getUltimaPosicion() {
        return ultimaPosicion;
    }

    public void setUltimaPosicion(Posicion ultimaPosicion) {
        this.ultimaPosicion = ultimaPosicion;
    }

    public Observado getObservado() {
        return observado;
    }

    public void setObservado(Observado observado) {
        this.observado = observado;
    }
    
    @Override
    public void actualizar() {
        
    }
    
}
