/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class ControladorPresion extends Controlador{

    private int numeroGolpes;
    
    public ControladorPresion(){
        this.numeroGolpes = 0;
        this.umbral = 0;
    }

    public int getNumeroGolpes() {
        return numeroGolpes;
    }

    public double getUmbral() {
        return umbral;
    }

    public Sensor getSensor() {
        return sensor;
    }
    
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        SensorPresion auxObserver = (SensorPresion)this.sensor;
        Presion auxSubject = (Presion)auxObserver.getObservado();
        if(auxObserver.getSensibilidad() * (auxSubject.getFuerza() / auxSubject.getAreaRaqueta()) > this.umbral)
            this.numeroGolpes++;
    }
    
}
