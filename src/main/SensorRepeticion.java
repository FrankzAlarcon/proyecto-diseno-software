
package main;

/**
 *
 * @author dell
 */
public class SensorRepeticion extends Observador{
    private NumeroRepeticiones numRepeticiones;

    public SensorRepeticion(NumeroRepeticiones numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }

    public NumeroRepeticiones getNumRepeticiones() {
        return numRepeticiones;
    }

    public void setNumRepeticiones(NumeroRepeticiones numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }
     
    
    @Override
    public void actualizar() {
        
    }
    
}
