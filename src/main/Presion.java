/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Presion extends Observado{
    private float fuerza;
    private float areaRaqueta;
    
    @Override
    public void notificar() {
        
    }

    public Presion(float fuerza, float areaRaqueta, SensorPresion sensorPresion) {
        this.fuerza = fuerza;
        this.areaRaqueta = areaRaqueta;
        this.observador = sensorPresion;
    }

    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }

    public float getAreaRaqueta() {
        return areaRaqueta;
    }

    public void setAreaRaqueta(float areaRaqueta) {
        this.areaRaqueta = areaRaqueta;
    }

    public SensorPresion getSensorPresion() {
        return (SensorPresion)observador;
    }

    public void setSensorPresion(SensorPresion SensorPresion) {
        this.observador = SensorPresion;
    }

    public Observador getObservador() {
        return observador;
    }

    public void setObservador(Observador observador) {
        this.observador = observador;
    }    
}
