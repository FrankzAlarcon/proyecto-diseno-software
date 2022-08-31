
package main;

/**
 *
 * @author dell
 */
public class SensorPeso extends Observador{
    private Peso pesoActual;

    public SensorPeso(Peso pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Peso getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Peso pesoActual) {
        this.pesoActual = pesoActual;
    }
    
    
    @Override
    public void actualizar() {
       
    }
    
    
}
