
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
        this.observador = new SensorPosicion();
    }

    public float getPosX() {
        return posX;
    }

    public void setPos(float posX, float posY){
        this.posX = posX;
        this.posY = posY;
    }

    public float getPosY() {
        return posY;
    }

    public SensorPosicion getSensor() {
        return (SensorPosicion) observador;
    }
    
    @Override
    public void notificar(){
        this.observador.actualizar();
    }
    
}
