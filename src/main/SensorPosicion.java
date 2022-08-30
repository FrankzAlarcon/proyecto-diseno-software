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

    private float sensibilidad;
    private int numeroGolpes;
    private Presion presion;
    
    @Override
    public void actualizar() {
        
    }

    public SensorPosicion(float sensibilidad, int numeroGolpes, Presion presion) {
        this.sensibilidad = sensibilidad;
        this.numeroGolpes = numeroGolpes;
        this.presion = presion;
    }

    public float getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(float sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public int getNumeroGolpes() {
        return numeroGolpes;
    }

    public void setNumeroGolpes(int numeroGolpes) {
        this.numeroGolpes = numeroGolpes;
    }

    public Presion getPresion() {
        return presion;
    }

    public void setPresion(Presion presion) {
        this.presion = presion;
    }

    public Observado getObservado() {
        return observado;
    }

    public void setObservado(Observado observado) {
        this.observado = observado;
    }
    
    
    
}
