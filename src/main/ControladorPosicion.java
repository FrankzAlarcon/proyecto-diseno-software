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
    
    private float desplazamiento;

    public ControladorPosicion() {
        this.desplazamiento = 0;
        this.umbral = 0;
    }

    public double getUmbral() {
        return umbral;
    }
    
    public float getDesplazamiento() {
        return desplazamiento;
    }

    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        SensorPosicion auxObserver = (SensorPosicion)this.sensor;
        Posicion auxSubject = (Posicion)auxObserver.getObservado();
        Posicion auxSubjectUltimo = (Posicion)auxObserver.getUltimaPosicion();
        float x = auxSubject.getPosX() - auxSubjectUltimo.getPosX();
        x = x * x;
        float y = auxSubject.getPosY() - auxSubjectUltimo.getPosY();
        y = y * y;
        desplazamiento = (float)sqrt(x + y);
        if(desplazamiento >= umbral){
            action.exec();
        }
    }
    
}
