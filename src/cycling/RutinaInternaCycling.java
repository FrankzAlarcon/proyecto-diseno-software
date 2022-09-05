/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.Rutina;
import trailrunning.Cronometro;

/**
 *
 * @author Stalin
 */
public class RutinaInternaCycling implements Rutina {
    private Bicicleta bicicleta;
    private Cronometro cronometro;
    public RutinaInternaCycling(){
        bicicleta = new Bicicleta(5);
    }
    
    public void iniciar(){
        cronometro = new Cronometro();
        cronometro.iniciar();
        bicicleta.iniciar();

    }
    
    public void detener(){
        cronometro.detener();
        bicicleta.detener();
        double segundos = cronometro.calcular();

    }
    
    public double calcularCaloriasQuemadas() {
        return 0.0;
    }
    
    public double calcularDistancia() {
        return 0.0;
    }
    
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicleta = bicicleta;
    }


    public Bicicleta getBicicleta() {
        return bicicleta;
    }
}
