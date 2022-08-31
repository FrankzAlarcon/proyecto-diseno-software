
package main;

/**
 *
 * @author dell
 */
public class Peso  extends Observado{
    private double valor;
    private SensorPeso sensor;

    public Peso(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public SensorPeso getSensor() {
        return sensor;
    }

    public void setSensor(SensorPeso sensor) {
        this.sensor = sensor;
    }
    

    @Override
    public void notificar() {
        
    }
    
    
    
}
