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
    private SensorPresion sensorPresion;
    
    @Override
    public void notificar() {
        
    }

    public Presion(float fuerza, float areaRaqueta, SensorPresion sensorPresion) {
        this.fuerza = fuerza;
        this.areaRaqueta = areaRaqueta;
        this.sensorPresion = sensorPresion;
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
        return SensorPresion;
    }

    public void setSensorPresion(SensorPresion SensorPresion) {
        this.SensorPresion = SensorPresion;
    }

    public Observador getObservador() {
        return observador;
    }

    public void setObservador(Observador observador) {
        this.observador = observador;
    }
    
    
    
}
