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

    public SensorPresion(float sensibilidad, Presion presion) {
        this.sensibilidad = sensibilidad;
        this.observado = presion;
    }

    public float getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(float sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public Presion getObservado() {
        return (Presion)observado;
    }

    public void setObservado(Presion observado) {
        this.observado = observado;
    }
    
    @Override
    public void actualizar() {
        
    }
    
}
