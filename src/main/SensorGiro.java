package main;

public class SensorGiro extends Sensor {
    
    @Override
    public void actualizar() {
        controlador.verificarUmbral();
    }
}
