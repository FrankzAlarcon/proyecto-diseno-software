package main;

public class Giro extends Factor {
    private double anguloTotal;

    @Override
    public void notificar() {
        SensorGiro sensorGiro = (SensorGiro) this.sensor;
        anguloTotal += 10;
        sensorGiro.actualizar();

    }
    public double getAnguloTotal() {
        
        return anguloTotal;
    }
}
