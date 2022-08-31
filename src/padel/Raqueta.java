/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padel;

import main.ControladorPosicion;
import main.ControladorPresion;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Raqueta {
    private String marca;
    private ControladorPosicion controladorPosicion;
    private ControladorPresion controladorPresion;

    public Raqueta(String marca, ControladorPosicion controladorPosicion, ControladorPresion controladorPresion) {
        this.marca = marca;
        this.controladorPosicion = controladorPosicion;
        this.controladorPresion = controladorPresion;
    }
            
    public void iniciar(){}
    
    public void detener(){};
    
}
