
package running;

import main.Rutina;


public abstract class RutinaRunning implements Rutina{
    
    double tiempo;
    double caloriasQuemadas;

    public RutinaRunning() {
        this.tiempo = tiempo;
        this.caloriasQuemadas = caloriasQuemadas;
    }
    
    
    @Override
    public void iniciar() {

    }

    @Override
    public void detener() {

    }

    @Override
    public double calcularCaloriasQuemadas() {
        
    
    return this.caloriasQuemadas;
    }
    
}
