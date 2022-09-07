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

    private float presionEjercida;
    
    public ControladorPresion(){
        this.presionEjercida = 0;
        this.umbral = 0;
    }

    public float getPresionEjercida() {
        return presionEjercida;
    }

    public double getUmbral() {
        return umbral;
    }
    
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        SensorPresion auxObserver = (SensorPresion)this.sensor;
        Presion auxSubject = (Presion)auxObserver.getFactor();
        presionEjercida = auxObserver.getSensibilidad() * (auxSubject.getFuerza() / auxSubject.getAreaRaqueta());
        if(presionEjercida >= this.umbral)
            action.exec();
    }
    
}
