/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import main.ControladorPeso;
import main.DefinableAction;

/**
 *
 * @author Frankz
 */
public class PesoAction implements DefinableAction{
    ControladorPeso controladorPeso;
    RutinaMaquinas rutinaMaquinas;

    public PesoAction(ControladorPeso controladorPeso, RutinaMaquinas rutinaMaquinas) {
        this.controladorPeso = controladorPeso;
        this.rutinaMaquinas = rutinaMaquinas;
    }

    @Override
    public void exec() {
        rutinaMaquinas.actualizarSubRutina();
    }
    
    
}
