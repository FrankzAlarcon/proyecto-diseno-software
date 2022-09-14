/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.Aplicacion;

/**
 *
 * @author 
 */
public class Cycling {
    //Atributos
    private Aplicacion aplicacion;
    private RutinaInternaCycling rutinaInterna;
    private RutinaExternaCycling rutinaExterna;

    
    //Constructor
    public Cycling(Aplicacion aplicacion){
        rutinaExterna = new RutinaExternaCycling(aplicacion);
        rutinaInterna = new RutinaInternaCycling(aplicacion);
        this.aplicacion=aplicacion;
    }
    
    
    public RutinaExternaCycling seleccionarRutinaExterna() {
        return rutinaExterna;
    }

    public RutinaInternaCycling seleccionarRutinaInterna() {
        return rutinaInterna;
    }
}
