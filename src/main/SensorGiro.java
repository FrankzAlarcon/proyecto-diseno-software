package main;

public class SensorGiro extends Observador{
    @Override
    public void actualizar() {
        controlador.ejecutarAccion();
    }
}
