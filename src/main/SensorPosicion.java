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
    private ControladorPosicion controlador;

    public SensorPosicion(){
        this.ultimaPosicion = new Posicion();
        this.ultimaPosicion.setSensor(this);
    }
    
    public Observado getObservado() {
        return observado;
    }

    public void setObservado(Observado observado) {
        this.observado = observado;
    }

    public Posicion getUltimaPosicion() {
        return ultimaPosicion;
    }

    public void registrar(Posicion ultimaPosicion) {
        this.ultimaPosicion = new Posicion(ultimaPosicion.getPosX(), ultimaPosicion.getPosY());
    }

    public ControladorPosicion getControlador() {
        return controlador;
    }

    public void setControlador(ControladorPosicion controlador) {
        this.controlador = controlador;
    }
    
    @Override
    public void actualizar() {
        
        this.controlador.ejecutarAccion();
    }
    
    public void actualizar(Observador observador) {
        this.ultimaPosicion = (Posicion)this.observado;
        this.observado = observado;
    }
    
}
