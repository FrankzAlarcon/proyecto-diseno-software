/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import main.ControladorRepeticion;
import main.DefinableAction;
import main.Repeticion;
import main.SensorRepeticion;

/**
 *
 * @author Frankz
 */
public class RepeticionAction implements DefinableAction{
    ControladorRepeticion controladorRepeticion;
    RutinaMaquinas rutinaMaquinas;

    public RepeticionAction(ControladorRepeticion controlador, RutinaMaquinas rutinaMaquinas) {
        this.controladorRepeticion = controlador;
        this.rutinaMaquinas = rutinaMaquinas;
    }

    @Override
    public void exec() {        
        rutinaMaquinas.actualizarRepeticion();
    }        
}
