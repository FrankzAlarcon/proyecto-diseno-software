/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

/**
 *
 * @author Stalin
 */
public class RutinaInterna extends RutinaCycling {
    private Bicicleta bicicleta;
    
    public RutinaInterna(double distancia, double caloriasQuemadas, Bicicleta bicicleta){
        super(distancia, caloriasQuemadas);
        this.bicicleta = bicicleta;
    }
    
    public void iniciar(){
    }
    
    public void detener(){
    }
    
    public void calcularCaloriasQuemadas() {
    }
    
    public void calcularDistancia() {
    }
    
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicleta = bicicleta;
    }
    
    
    
}
