/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.*;
import trailrunning.Cronometro;

/**
 *
 * @author
 */
public class RutinaExternaCycling implements Rutina {

    private Ruta ruta;
    private ControladorUbicacion controladorUbicacion;
    private ActionThread thread;
    private double distanciaRecorrida;
    private Aplicacion aplicacion;
    private Cronometro cronometro;
    private static double MET = 7.2;

    public RutinaExternaCycling(Aplicacion aplicacion) {
        this.ruta = new Ruta();
        this.aplicacion = aplicacion;
    }

    public void iniciar() {
        cronometro = new Cronometro();
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
        controladorUbicacion.setAction(new DefinableAction() {
            @Override
            public void exec() {
                ruta.agregar(new Ubicacion(ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getElevacion()));
                distanciaRecorrida += controladorUbicacion.getDistanciaRecorrida();
            }
        });

        thread = new ActionThread() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        sleep(1000);
                        ubicacion.notificar();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        thread.start();

    }

    public void detener() {
        cronometro.detener();
        thread.stopAction();
    }

    public double calcularCaloriasQuemadas() {
        
        return aplicacion.getUsuario().getPeso() * MET * 0.0175 * cronometro.obtenerTiempo()/60;
    }

    public double calcularDistancia() {
        return distanciaRecorrida;
    }

    public Ruta getRuta() {
        return ruta;
    }
}
