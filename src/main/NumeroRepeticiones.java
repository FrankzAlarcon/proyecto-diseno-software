
package main;
/*
    author: Chris
*/

public class NumeroRepeticiones extends Observado{
    private int numero;
    private SensorRepeticion sensor;

    public NumeroRepeticiones(int numero, SensorRepeticion sensor) {
        this.numero = numero;
        this.sensor = sensor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public SensorRepeticion getSensor() {
        return sensor;
    }

    public void setSensor(SensorRepeticion sensor) {
        this.sensor = sensor;
    }

   
    @Override
    public void notificar() {
        
    }
    
}
