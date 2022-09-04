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

    public SensorPresion(){
        this.sensibilidad = 1.0f;
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
    
    @Override
    public void actualizar() {
        this.controlador.ejecutarAccion();
    }
}
