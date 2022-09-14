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
public abstract class Bicicleta {

    protected int dificultad;
    protected ControladorGiro controladorGiro;
    protected double distanciaRecorrida;
    protected ActionThread thread;
    protected double radio = 0.5;//

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
    
    public double getRadio(){
        return radio;
    }
    
    public void iniciar() {
    }

    public void detener() {
    }
    
    public void actualizarDistanciaRecorrida(double distancia){
        this.distanciaRecorrida += distancia;
    }



}
