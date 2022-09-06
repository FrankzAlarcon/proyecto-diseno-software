
package running;
import main.Rutina;

public class RutinaEstandarRunning implements Rutina{
   
    //atributos
    private double velocidad;
    private int inclinacion;
    NivelRutinaRunning nivel;    
    private double tiempo;
    private double caloriasQuemadas;

    //constructor

    public RutinaEstandarRunning(double velocidad, int inclinacion, NivelRutinaRunning nivel, double tiempo, double caloriasQuemadas) {
        this.velocidad = velocidad;
        this.inclinacion = inclinacion;
        this.nivel = nivel;
        this.tiempo = tiempo;
        this.caloriasQuemadas = caloriasQuemadas;
    }
    
    
    
    
    
   
    //metodos

    @Override
    public double calcularCaloriasQuemadas() {
        double caloriasQuemadas = 0;
        
        
        return caloriasQuemadas;
    }

    @Override
    public void detener() {
        
    }

    @Override
    public void iniciar() {
        
    }
    
 
}
