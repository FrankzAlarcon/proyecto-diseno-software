/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import static java.lang.Thread.sleep;
import main.ActionThread;
import main.Aplicacion;
import main.ControladorUbicacion;
import main.Rutina;
import main.SensorUbicacion;
import main.Ubicacion;
import trailrunning.Cronometro;
import main.*;

/**
 *
 * @author Stalin
 */
public class RutinaInternaCycling implements Rutina {

    private static double MET = 6.0;
    private Bicicleta bicicleta;
    private Cronometro cronometro;
    private ControladorUbicacion controladorUbicacion;
    private ActionThread thread;
    private double caloriaaQuemadas;
    private Ruta ruta;

    public RutinaInternaCycling() {
        bicicleta = new Bicicleta(5);
    }

    public void iniciar() {
        cronometro = new Cronometro();
        cronometro.iniciar();
        bicicleta.iniciar();

        //Inicializacion del observado y observador
        SensorUbicacion sensorUbicacion = new SensorUbicacion();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setObservador(sensorUbicacion);
        sensorUbicacion.setObservado(ubicacion);
        //Controlador ubicacion
        controladorUbicacion = new ControladorUbicacion();
        controladorUbicacion.setObservador(sensorUbicacion);
        sensorUbicacion.setControlador(controladorUbicacion);
        controladorUbicacion.definirUmbral(5);
        System.out.println("Acción iniciada ------------------------------");
        thread = new ActionThread() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        sleep(1000);
                        ubicacion.notificar();
                        //ruta.agregar(new Ubicacion(ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getElevacion()));

                    } catch (InterruptedException e) {
                        //throw new RuntimeException(e);
                    }
                }
            }
        };

        thread.start();

    }

    public void detener() {
        thread.stopAction();
        cronometro.detener();
        bicicleta.detener();
        double segundos = cronometro.calcular();
        caloriaaQuemadas = calcularCaloriasQuemadas();

    }

    public double calcularCaloriasQuemadas() {

       // return Aplicacion.getUsuario().getPeso()*cronometro.calcular()/12; 
       return 0;
    }

    public double calcularDistancia() {
        return controladorUbicacion.getDistanciaRecorrida();
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }
}
