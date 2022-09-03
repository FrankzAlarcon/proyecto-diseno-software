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
    public SensorUbicacion sensor;

    public Ubicacion() {
        this(0.0,0.0);
    }

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public void notificar() {
        SensorUbicacion sensor = ((SensorUbicacion)this.observador);
        sensor.setUbicacion(new Ubicacion(latitud, longitud));
        latitud += 0.0005;
        longitud += 0.0005;

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

    @Override
    public String toString() {
        return latitud + ", " + longitud;
    }
}
