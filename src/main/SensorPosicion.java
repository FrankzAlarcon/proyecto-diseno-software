/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class SensorPosicion extends Sensor {
    
    private Posicion ultimaPosicion;

    public SensorPosicion(){
        this.ultimaPosicion = new Posicion();
        this.ultimaPosicion.setSensor(this);
    }

    public Posicion getUltimaPosicion() {
        return ultimaPosicion;
    }

    public void setUltimaPosicion(Posicion ultimaPosicion) {
        this.ultimaPosicion = new Posicion(ultimaPosicion.getPosX(), ultimaPosicion.getPosY());
    }
    
    @Override
    public void actualizar() {
        
        this.controlador.verificarUmbral();
    }

    /*
    public void actualizar(Observador observador) {
        this.ultimaPosicion = (Posicion)this.observado;
        this.observado = observado;
    }*/
    
}
