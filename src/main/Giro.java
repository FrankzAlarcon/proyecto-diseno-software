package main;

public class Giro extends Observado{
    private double anguloTotal;

    @Override
    public void notificar() {
        SensorGiro sensorGiro = (SensorGiro) this.observador;
        anguloTotal += 10;
        sensorGiro.actualizar();

    }
    public double getAnguloTotal() {
        return anguloTotal;
    }
}
