
package main;

/**
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Posicion extends Factor {

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

    public float getPosY() {
        return posY;
    }
    
    public void setPos(float posX, float posY){
        SensorPosicion aux = (SensorPosicion)this.sensor;
        aux.setUltimaPosicion(this);
        this.posX = posX;
        this.posY = posY;
    }
    
    @Override
    public void notificar(){
        ((SensorPosicion)this.sensor).setUltimaPosicion(this);
        this.posX =(float)(Math.random());
        this.posY =(float)(Math.random());

        this.sensor.actualizar();
    }
    
}
