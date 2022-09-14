/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cycling;

import main.DefinableAction;
import main.Ubicacion;

/**
 *
 * @author BRYAN_ANDRADE
 */
public class CyclingUbicacionAction implements DefinableAction{
    
    private Ruta ruta;
    private Ubicacion ubicacion;
    
    
    public CyclingUbicacionAction(Ruta ruta, Ubicacion ubicacion){
        this.ruta = ruta;
        this.ubicacion = ubicacion;
    }
     @Override
    public void exec() {
        ruta.agregar(new Ubicacion(ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getElevacion()));
    }
    
}
