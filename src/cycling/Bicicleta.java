/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.*;

/**
 *
 * @author 
 */
public class Bicicleta {

    private int dificultad;
    private ControladorGiro controladorGiro;
    private double distanciaRecorrida;
    private ActionThread thread;
    private double radio = 0.5;//

    public Bicicleta(int dificultad) {
        this.dificultad = dificultad;
    }

    public void setDificultad(int dificultad) {
        if(dificultad > 5){
            dificultad = 5;
        }

        if(dificultad < 1){
            dificultad = 1;
        }
        this.dificultad = dificultad;
    }

    public int getDificultad() {

        return dificultad;
    }
    
    public void iniciar() {
        Giro giro = new Giro();
        SensorGiro sensorGiro = new SensorGiro();
        giro.setSensor(sensorGiro);
        sensorGiro.setFactor(giro);
        controladorGiro = new ControladorGiro();
        controladorGiro.setSensor(sensorGiro);
        sensorGiro.setControlador(controladorGiro);
        controladorGiro.setAction(new DefinableAction() {
            @Override
            public void exec() {

                distanciaRecorrida += (controladorGiro.getAnguloTotal()-dificultad*2) * radio * Math.PI * 2;
            }

        });

        thread = new ActionThread() {
            @Override
            public void run() {
                while (isRunning) {
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

    public double getAnguloTotal() {
        return controladorGiro.getAnguloTotal();
    }

    public double getDistaciaRecorrida() {

        return distanciaRecorrida;
    }
}
