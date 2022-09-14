/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import java.util.ArrayList;
import main.Ubicacion;

/**
 *
 * @author
 */

public class Ruta {
    private ArrayList<Ubicacion> ubicaciones;
    
    public Ruta(){
        ubicaciones = new ArrayList<>();
    }
    
    public void agregar(Ubicacion ubicacion){
        ubicaciones.add(ubicacion);
    }
    
    public void quitar(Ubicacion ubicacion){
        ubicaciones.remove(ubicacion);
    }

    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }
    
    public void Imprimir(){
        System.out.println(ubicaciones);
    }
}
