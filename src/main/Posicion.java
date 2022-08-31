
package main;

/**
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Posicion extends Observado{

    private float posX;
    private float posY;

    public Posicion(){
        this.posX = posX;
        this.posY = posY;
    }
    
    public Posicion(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
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
        return (SensorPosicion) observador;
    }

    public void setSensor(SensorPosicion sensor) {
        this.observador = sensor;
    }
    
    @Override
    public void notificar(){
        this.observador.actualizar();
    }
    
}
