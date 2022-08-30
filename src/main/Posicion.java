
package main;

import main.SensorPosicion;
/**
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Posicion extends Observado{

    private float posX;
    private float posY;
 
    private SensorPosicion sensor;

    public Posicion(float posX, float posY, SensorPosicion sensor) {
        this.posX = posX;
        this.posY = posY;
        this.sensor = new SensorPosicion();
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

    public SensorPosicion getSensor() {
        return sensor;
    }

    public void setSensor(SensorPosicion sensor) {
        this.sensor = sensor;
    }

    
    
    @Override
    public void notificar() {
        
    }
    
}
