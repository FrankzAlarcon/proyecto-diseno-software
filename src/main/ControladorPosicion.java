/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static java.lang.Math.sqrt;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class ControladorPosicion extends Controlador{
    
    private float distanciaRecorrida;

    public ControladorPosicion(SensorPosicion observador) {
        this.distanciaRecorrida = 0;
        this.umbral = 0;
        this.observador = observador;
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
    
    public float getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void ejecutarAccion() {
        SensorPosicion auxObserver = (SensorPosicion)this.observador;
        Posicion auxSubject = (Posicion)auxObserver.getObservado();
        Posicion auxSubjectUltimo = (Posicion)auxObserver.getUltimaPosicion();
        float x = auxSubject.getPosX() - auxSubjectUltimo.getPosX();
        x = x * x;
        float y = auxSubject.getPosY() - auxSubjectUltimo.getPosY();
        y = y * y;
        distanciaRecorrida += sqrt(x + y);
    }
    
}
