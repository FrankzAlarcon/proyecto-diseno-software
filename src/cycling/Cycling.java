/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.Aplicacion;
import main.SensorUbicacion;
import main.Ubicacion;

/**
 *
 * @author Stalin
 */
public class Cycling {
    private Aplicacion aplicacion;
    private RutinaInternaCycling rutinaInterna;
    private RutinaExternaCycling rutinaExterna;

    public Cycling(){ // Realizar el constructor
        rutinaExterna = new RutinaExternaCycling();
        rutinaInterna = new RutinaInternaCycling();
    }
    
    public void iniciar(){


    }
    public void detener(){
    }
    
    public void mostrarRutinas(){
    }
    
    public void seleccionarRutina(){
    }
    
    public void mostrarResultado(){
    }

    public RutinaExternaCycling seleccionarRutinaExterna() {
        return rutinaExterna;
    }

    public RutinaInternaCycling seleccionarRutinaInterna() {
        return rutinaInterna;
    }
}
