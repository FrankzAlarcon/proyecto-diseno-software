/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cycling;
import main.ControladorGiro;
import main.DefinableAction;

/**
 *
 * @author BRYAN_ANDRADE
 */
public class CyclingGiroAction implements DefinableAction{
    ControladorGiro controladorGiro;
    private Bicicleta bicicleta;

    public CyclingGiroAction(ControladorGiro controladorGiro, Bicicleta bicicleta){
        this.controladorGiro = controladorGiro;
        this.bicicleta = bicicleta;
    }
    @Override
    public void exec() {
        bicicleta.actualizarDistanciaRecorrida((controladorGiro.getAnguloTotal()-bicicleta.getDificultad()*2) * bicicleta.getRadio() * Math.PI * 2);
        
    }
    
    
    
}
