
package areamaquinas;
import java.util.ArrayList;
import main.NumeroRepeticiones;
import main.Peso;
import main.Rutina;

/**
 *
 * @author dell
 */
public class RutinaMaquinas implements Rutina{
    private ArrayList<NumeroRepeticiones> numRepeticiones;
    private ArrayList<Peso> pesos;
    private ArrayList<Double> tiempos;
    private Double caloriasQuemadas;
    //controladoPeso
    //controladorRepeticiones

    @Override
    public void iniciar() {
        //Incializa el tiempo 
    }

    @Override
    public void detener() {
        //Finaliza la rutina y manda a llamar al metodo calorias quemadas
        caloriasQuemadas = this.calcularCaloriasQuemadas();
        
    }

    @Override
    public double calcularCaloriasQuemadas() {
        double calorias = (numRepeticiones.get(0).getNumero() * pesos.get(0).getValor()) / tiempos.get(0); 
        return calorias ;
    }
    
    public void getDatos(){
        
    }
    
    public void cambiarRutino(){
    
    }
    
    public void actualizarDatoss(){
        
    }
    
}
