/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Frankz
 */
public abstract class Observado {
    Observador observador;
    
    public abstract void notificar();
    
    public void setObservador(Observador observador){
        observador.observado = this;
        this.observador = observador;
    }
}
