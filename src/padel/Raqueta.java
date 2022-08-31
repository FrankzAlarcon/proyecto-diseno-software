/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padel;

import main.ControladorPosicion;
import main.ControladorPresion;
import main.Posicion;
import main.Presion;
import main.SensorPosicion;
import main.SensorPresion;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Raqueta {
    private String marca;
    private ControladorPosicion controladorPosicion;
    private ControladorPresion controladorPresion;

    public Raqueta(String marca) {
        this.marca = marca;
    }
    
    public String getMarca() {
        return marca;
    }

    public ControladorPosicion getControladorPosicion() {
        return controladorPosicion;
    }

    public ControladorPresion getControladorPresion() {
        return controladorPresion;
    }  
    
    public void iniciar(){
        //Controlador presion
        //Posicion pos = new Posicion();
        //SensorPosicion senPos = new SensorPosicion(0.2f);
        Presion pres = new Presion();
        SensorPresion senPres = new SensorPresion(0.2f);
        controladorPresion = new ControladorPresion();
        pres.setObservador(senPres);
        senPres.setObservado(pres);
        
        
        //controladorPosicion = new ControladorPosicion(senPos);
    }
    
    public void detener(){};
    
}
