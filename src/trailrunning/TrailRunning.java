
package trailrunning;

import main.Aplicacion;
import main.ControladorUbicacion;

/**
 *
 * @author green
 */
public class TrailRunning {
    private final double MET = 6.0;
    private double distanciaRecorrida;
    private double gradoPromedio;
    private double caloriasQuemadas;
    private Velocidad velocidad;
    private Aplicacion aplicacion;
    private Cronometro cronometro;
    private ControladorUbicacion controladorUbicacion;
    private ConsumoOxigeno consumoOxigeno;
    
    
    public void iniciar() {
        cronometro.iniciar();
        
    }
    
    public void detener(){
        cronometro.detener();
        caloriasQuemadas = calcularCaloriasQuemadas();
        
    }
    
    public void mostrarResultados() {
        
    }
    
    public void actualizarDistanciaRecorrida() {
        
    }
    
    public void actualizarGradoElevacion(){
        
    }
    
    public double calcularCaloriasQuemadas() {
        return MET * aplicacion.getUsuario().getPeso() * cronometro.calcular();
    }
}
