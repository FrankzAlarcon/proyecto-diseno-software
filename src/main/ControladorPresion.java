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
        this.observador = new SensorPresion();
    }

    public int getNumeroGolpes() {
        return numeroGolpes;
    }

    public double getUmbral() {
        return umbral;
    }

    public Observador getObservador() {
        return observador;
    }

    public void setObservador(Observador observador) {
        this.observador = observador;
    }
    
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void ejecutarAccion() {
        SensorPresion auxObserver = (SensorPresion)this.observador;
        Presion auxSubject = (Presion)auxObserver.getObservado();
        if(auxObserver.getSensibilidad() * (auxSubject.getFuerza()/auxSubject.getAreaRaqueta())> this.umbral)
            this.numeroGolpes++;
    }
    
}
