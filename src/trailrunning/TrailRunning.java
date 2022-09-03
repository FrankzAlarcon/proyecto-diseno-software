
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
    private double oxigenoConsumido;
    private Velocidad velocidad;
    private Aplicacion aplicacion;
    private Cronometro cronometro;
    private ControladorUbicacion controladorUbicacion;
    private ConsumoOxigeno consumoOxigeno;
    private ActionThread thread;

    public TrailRunning(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;

    }

    public ControladorUbicacion getControladorUbicacion() {
        return controladorUbicacion;
    }

    public void iniciar() {
        cronometro = new Cronometro();
        cronometro.iniciar();

        //Inicializacion del observado y observador
        SensorUbicacion sensorUbicacion = new SensorUbicacion();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setObservador(sensorUbicacion);
        sensorUbicacion.setObservado(ubicacion);
        //Controlador ubicacion
        controladorUbicacion = new ControladorUbicacion();
        controladorUbicacion.setObservador(sensorUbicacion);
        sensorUbicacion.setControlador(controladorUbicacion);
        System.out.println("Acción iniciada ------------------------------");
        thread = new ActionThread() {
            @Override
            public void run() {
                while(isRunning) {
                    try {
                        sleep(1000);
                        ubicacion.notificar();

                    } catch (InterruptedException e) {
                        //throw new RuntimeException(e);
                    }
                }
            }
        };

        thread.start();
        
    }
    
    public void detener(){
        System.out.println("Acción detenida ------------------------------");
        thread.stopAction();
        cronometro.detener();
        caloriasQuemadas = calcularCaloriasQuemadas();
        distanciaRecorrida += controladorUbicacion.getDistanciaRecorrida();
        //oxigenoConsumido += consumoOxigeno.calcular();
        
    }
    /*
    public void mostrarResultados() {
        
    }
    */
    public void actualizarDistanciaRecorrida() {
        
    }
    
    public void actualizarGradoElevacion(){
        
    }
    
    public double calcularCaloriasQuemadas() {
        return MET * aplicacion.getUsuario().getPeso() * cronometro.calcular();
    }
}
