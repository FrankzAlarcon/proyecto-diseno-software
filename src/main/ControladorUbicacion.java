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

    private double distanciaRecorrida;
    private double grado;

    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        SensorUbicacion sensor = (SensorUbicacion) this.sensor;
        Vec3 a = sensor.getUbicacionAnterior().toVec3();
        Vec3 b = sensor.getUbicacionActual().toVec3();
        Vec3 c = b.minus(a);
        Vec3 b1 = b.times(a.getModule()/b.getModule());
        Vec3 d = b1.minus(a);

        double ang1 = d.angle(b1);
        double ang2 = a.angle(c.times(-1));
        grado = ang2 - ang1;
        distanciaRecorrida = c.getModule();
        if(distanciaRecorrida >= umbral){
            action.exec();
        }
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public double getGrado() {
        return grado;
    }
}
