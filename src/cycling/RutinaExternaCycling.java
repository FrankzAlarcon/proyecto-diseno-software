/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.*;

/**
 *
 * @author Stalin
 */
public class RutinaExternaCycling implements Rutina {
    private Ruta ruta;
    private ControladorUbicacion controladorUbicacion;
    private ActionThread thread;
    private double distancia;
    
    public RutinaExternaCycling(){
        this.ruta = new Ruta();
    }
    
    public void iniciar(){
        //Inicializacion del observado y observador
        SensorUbicacion sensorUbicacion = new SensorUbicacion();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setSensor(sensorUbicacion);
        sensorUbicacion.setObservado(ubicacion);
        //Controlador ubicacion
        controladorUbicacion = new ControladorUbicacion();
        controladorUbicacion.setSensor(sensorUbicacion);
        sensorUbicacion.setControlador(controladorUbicacion);
        controladorUbicacion.definirUmbral(5);
        controladorUbicacion.setAction(new DefinableAction() {
            @Override
            public void exec() {
                ruta.agregar(new Ubicacion(ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getElevacion()));
                distancia += controladorUbicacion.getDistanciaRecorrida();
            }
        });
        System.out.println("Acción iniciada ------------------------------");
        thread = new ActionThread() {
            @Override
            public void run() {
                while(isRunning) {
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
    
    public void detener(){
        thread.stopAction();
    }
    
    public double calcularCaloriasQuemadas(){
        return 0.0;
    }
    
    public double calcularDistancia(){
        return distancia;
    }
    
    public void compararUbicacionActual(){
    }

    public Ruta getRuta() {
        return ruta;
    }
}
