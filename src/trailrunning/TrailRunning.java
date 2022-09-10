
package trailrunning;

import main.*;

/**
 *
 * @author green
 */
public class TrailRunning {
    private final double MET = 6.0;
    private Velocidad velocidad;
    private Aplicacion aplicacion;
    private Cronometro cronometro;
    private ConsumoOxigeno consumoOxigeno;
    private ControladorUbicacion controladorUbicacion;
    private ResumenTrailRunning resumenTrailRunning;
    private ActionThread thread;

    public TrailRunning(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        cronometro = new Cronometro();
        velocidad = new Velocidad(cronometro);
        consumoOxigeno = new ConsumoOxigeno(velocidad);
        resumenTrailRunning = new ResumenTrailRunning();
    }

    public void iniciar() {

        cronometro.iniciar();
        //Inicializacion del observado y observador
        SensorUbicacion sensorUbicacion = new SensorUbicacion();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setSensor(sensorUbicacion);
        sensorUbicacion.setFactor(ubicacion);
        //Controlador ubicacion
        controladorUbicacion = new ControladorUbicacion();
        controladorUbicacion.setSensor(sensorUbicacion);
        sensorUbicacion.setControlador(controladorUbicacion);
        controladorUbicacion.definirUmbral(5);

        controladorUbicacion.setAction(new TrailRunningAction(controladorUbicacion, velocidad, consumoOxigeno));
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
        thread.stopAction();
        resumenTrailRunning.actualizarDatos(velocidad, cronometro, aplicacion.getUsuario(), consumoOxigeno);
    }

    public ResumenTrailRunning getResumen() {
        return resumenTrailRunning;
    }
    /*
    public void actualizarDistanciaRecorrida() {
        distanciaRecorrida += controladorUbicacion.getDistanciaRecorrida();
    }
    
    public void actualizarGradoElevacion(){
        SensorUbicacion sensorUbicacion = ((SensorUbicacion)controladorUbicacion.getSensor());
        Vec3 a = sensorUbicacion.getUbicacionAnterior().toVec3();
        Vec3 b = sensorUbicacion.getUbicacionActual().toVec3();
        Vec3 c = b.minus(a);
        Vec3 b1 = b.times(a.getModule()/b.getModule());
        Vec3 d = b1.minus(a);

        double ang1 = d.angle(b1);
        double ang2 = a.angle(c.times(-1));
        double tetha = ang2 - ang1;

        if(tetha > 0){
            gradoPromedio += tetha;
        }

    }
    
    public double calcularCaloriasQuemadas() {
        return MET * aplicacion.getUsuario().getPeso() * cronometro.calcular()/3600;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public double getOxigenoConsumido() {
        return consumoOxigeno.calcular();
    }

    */
}
