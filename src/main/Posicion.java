
package main;

/**
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Posicion extends Observado{

    private float posX;
    private float posY;

    public Posicion(){
        this.posX = 0.0f;
        this.posY = 0.0f;
    }
    
    public Posicion(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public float getPosX() {
        return posX;
    }

    public void setPos(float posX, float posY){
        SensorPosicion aux = (SensorPosicion)this.observador;
        aux.setUltimaPosicion(this);
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
        ((SensorPosicion)this.observador).setUltimaPosicion(this);
        this.posX =(float)(Math.random()*5);
        this.posY =(float)(Math.random()*5);

        this.observador.actualizar();
    }
    
}
