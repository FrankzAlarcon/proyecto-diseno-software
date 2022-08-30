
package main;

import main.SensorUbicacion;
/**
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Posicion extends Observado{

    private float posX;
    private float posY;
 
    private SensorUbicacion sensor;

    public Posicion(float posX, float posY, SensorUbicacion sensor) {
        this.posX = posX;
        this.posY = posY;
        this.sensor = sensor;
    }
    
    
    

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public SensorUbicacion getSensor() {
        return sensor;
    }

    public void setSensor(SensorUbicacion sensor) {
        this.sensor = sensor;
    }
    
    
    @Override
    public void notificar() {
        
    }
    
}
