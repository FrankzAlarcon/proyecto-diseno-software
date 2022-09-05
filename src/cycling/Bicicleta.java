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
public class Bicicleta {
    private int dificultad;
    private ControladorGiro controladorGiro;
    private ActionThread thread;
    
    public Bicicleta(int dificultad){
        this.dificultad = dificultad;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void calcularDistanciaRecorrida(){
    }
    
    public void calcularCaloriasQuemadas(){
    }
    
    public void aumentarDificultad(){
    }
    
    public void disminuirDificultad(){
    }


    public void iniciar() {
        Giro giro = new Giro();
        SensorGiro sensorGiro = new SensorGiro();
        giro.setObservador(sensorGiro);
        sensorGiro.setObservado(giro);
        controladorGiro = new ControladorGiro();
        controladorGiro.setObservador(sensorGiro);
        sensorGiro.setControlador(controladorGiro);
        thread = new ActionThread() {
            @Override
            public void run() {
                while(isRunning) {
                    try {
                        sleep(1000);
                        giro.notificar();
                        System.out.println("Giro la rueda");
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
    }

    public double getAnguloTotal(){
        return controladorGiro.getAnguloTotal();
    }
}
