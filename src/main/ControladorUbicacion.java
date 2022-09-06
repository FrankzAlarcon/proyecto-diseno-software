/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author green
 */
public class ControladorUbicacion extends Controlador{
    
    private double umbral;
    private double distanciaRecorrida;

    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        SensorUbicacion sensor = (SensorUbicacion) this.sensor;
        //System.out.println(sensor.getUbicacionAnterior() + " " + sensor.getUbicacionActual());
        Vec3 inicio = sensor.getUbicacionAnterior().toVec3();
        Vec3 destino = sensor.getUbicacionActual().toVec3();
        distanciaRecorrida = destino.minus(inicio).getModule();
        //System.out.println("Acción ejecutada: " +tempDistance);
        if(distanciaRecorrida >= umbral){
            action.exec();
        }
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
    
}
