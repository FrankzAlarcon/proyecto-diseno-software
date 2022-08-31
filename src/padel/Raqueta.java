/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padel;

import main.ControladorPosicion;
import main.ControladorPresion;
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ControladorPosicion getControladorPosicion() {
        return controladorPosicion;
    }

    public ControladorPresion getControladorPresion() {
        return controladorPresion;
    }  
    
    public void iniciar(){
        //Controlador presion
        SensorPosicion senPos = new SensorPosicion(0.2f);
        SensorPresion senPres = new SensorPresion(0.2f);
        controladorPosicion = new ControladorPosicion(senPos);
        controladorPresion = new ControladorPresion(senPres);
    }
    
    public void detener(){};
    
}
