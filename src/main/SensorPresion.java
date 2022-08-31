/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 * comentando...
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class SensorPresion extends Observador{

    private float sensibilidad;
    private ControladorPresion controlador;

    public SensorPresion(){
        this.sensibilidad = 1.0f;
        this.observado = new Presion();
    }
    
    public SensorPresion(float sensibilidad) {
        this.sensibilidad = sensibilidad;
        this.observado = new Presion();
    }

    public float getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(float sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public Observado getObservado() {
        return observado;
    }

    public void setObservado(Observado observado) {
        this.observado = observado;
    }
    
    @Override
    public void actualizar() {
        this.controlador.ejecutarAccion();
    }
}
