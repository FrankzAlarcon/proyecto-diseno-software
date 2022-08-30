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
    
    public ControladorPresion(SensorPresion observador){
        this.numeroGolpes = 0;
        this.umbral = 0;
        this.observador = observador;
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
        
    }
    
}
