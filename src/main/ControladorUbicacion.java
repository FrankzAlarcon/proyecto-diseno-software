/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import trailrunning.Vec3;

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
    public void ejecutarAccion() {
        SensorUbicacion sensor = (SensorUbicacion) observador;
        System.out.println(sensor.getUbicacionAnterior() + " " + sensor.getUbicacionActual());
        double tempDistance = calcularDistancia(sensor.getUbicacionAnterior(), sensor.getUbicacionActual());
        System.out.println("Acción ejecutada: " +tempDistance);
        if(tempDistance >= umbral){
            distanciaRecorrida += tempDistance;
            System.out.println("Pasó el umbral");
        }
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    private Vec3 toVec3(Ubicacion ubicacion){
        double R = 6371e3 + ubicacion.getElevacion();
        double tetha = Math.toRadians(ubicacion.getLongitud());
        double phi = Math.toRadians(ubicacion.getLatitud());

        double x = R * Math.cos(phi) * Math.sin(tetha);
        double y = R * Math.sin(phi);
        double z = R * Math.cos(phi) * Math.cos(tetha);

        return new Vec3(x, y, z);
    }

    private double calcularDistancia(Ubicacion inicio, Ubicacion destino){
        Vec3 a = toVec3(inicio);
        Vec3 b = toVec3(destino);
        Vec3 c = b.minus(a);
        Vec3 b1 = b.times(a.getModule()/b.getModule());
        Vec3 d = b1.minus(a);

        double ang1 = d.angle(b1);
        double ang2 = a.angle(c.times(-1));
        double tetha = ang2 - ang1;

        return b.minus(a).getModule();
        /*
        double lat1 = inicio.getLatitud();
        double lat2 = destino.getLatitud();
        double lon1 = inicio.getLongitud();
        double lon2 = destino.getLongitud();
        double R = 6371e3; // metres
        double ang1 = lat1 * Math.PI/180; // φ, λ in radians
        double ang2 = lat2 * Math.PI/180;
        double delta1 = (lat2-lat1) * Math.PI/180;
        double delta2 = (lon2-lon1) * Math.PI/180;

        double a = Math.sin(delta1/2) * Math.sin(delta1/2) +
                Math.cos(ang1) * Math.cos(ang2) *
                        Math.sin(delta2/2) * Math.sin(delta2/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double d = R * c; // in metres
        return d;

         */
    }
    
}
