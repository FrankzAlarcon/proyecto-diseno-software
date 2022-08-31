/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.ControladorUbicacion;

/**
 *
 * @author Stalin
 */
public class RutinaExterna extends RutinaCycling{
    private Ruta ruta;
    private ControladorUbicacion controladorUbicacion;
    
    public RutinaExterna(double distancia, double caloriasQuemadas, Ruta ruta, ControladorUbicacion controladorUbicacion){
        super(distancia,caloriasQuemadas);
        this.ruta = ruta;
        this.controladorUbicacion = controladorUbicacion;
    }
    
    public void iniciar(){
    }
    
    public void detener(){
    }
    
    public void calcularCaloriasQuemadas(){
    }
    
    public void calcularDistancia(){
    }
    
    public void compararUbicacionActual(){
    }
    
    
}
