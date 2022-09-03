
package trailrunning;

import main.*;

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
        //Inicializacion del observado y observador
        SensorUbicacion sensorUbicacion = new SensorUbicacion();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setObservador(sensorUbicacion);
        sensorUbicacion.setObservado(ubicacion);
        //

        
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
