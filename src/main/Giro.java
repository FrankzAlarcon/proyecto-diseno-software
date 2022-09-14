package main;

public class Giro extends Factor {
    private double anguloTotal;
    
    public Giro(){
        this.anguloTotal = 0.0;
    }
    

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
