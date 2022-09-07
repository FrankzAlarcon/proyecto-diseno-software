/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author green
 */
public class Ubicacion extends Observado {
    private double latitud = 0.0;
    private double longitud = 0.0;
    private double elevacion;
    public Ubicacion() {
        this(0.0,0.0,0.0);
    }

    public Ubicacion(double latitud, double longitud, double elevacion) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion = elevacion;
    }

    @Override
    public void notificar() {
        SensorUbicacion sensor = ((SensorUbicacion) this.sensor);
        sensor.setUbicacion(new Ubicacion(latitud, longitud, elevacion));
        latitud += 0.0001;
        longitud += 0.0001;
        elevacion = Math.random()*2;
        sensor.actualizar();

    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getElevacion() {
        return elevacion;
    }

    public Vec3 toVec3() {
        double R = 6371e3 + elevacion;
        double tetha = Math.toRadians(longitud);
        double phi = Math.toRadians(latitud);

        double x = R * Math.cos(phi) * Math.sin(tetha);
        double y = R * Math.sin(phi);
        double z = R * Math.cos(phi) * Math.cos(tetha);

        return new Vec3(x, y, z);
    }
}
