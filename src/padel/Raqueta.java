
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
        //Se inicia el medidor de posición
        Posicion posicion = new Posicion();
        SensorPosicion sensorPosicion = new SensorPosicion();
        this.controladorPosicion = new ControladorPosicion();
        
        //Se inicia el medidor de presión
        Presion presion = new Presion();
        SensorPresion sensorPresion = new SensorPresion();
        this.controladorPresion = new ControladorPresion();

        //Configuración de los medidores
        posicion.setObservador(sensorPosicion);
        sensorPosicion.setControlador(controladorPosicion);
        this.controladorPosicion.setObservador(sensorPosicion);
        
        presion.setObservador(sensorPresion);
        sensorPresion.setControlador(controladorPresion);
        this.controladorPresion.setObservador(sensorPresion);
    }
    
    public void detener(){
        this.controladorPosicion = null;
        this.controladorPresion = null;
    };
    
    public static void main(String[] args) {
        Posicion posicion = new Posicion();
        SensorPosicion sensorPosicion = new SensorPosicion();
        ControladorPosicion controladorPosicion = new ControladorPosicion();
        
        posicion.setObservador(sensorPosicion);
        sensorPosicion.setControlador(controladorPosicion);
        controladorPosicion.setObservador(sensorPosicion);
        
        posicion.setPos(100, 200);
        posicion.notificar();
        
        posicion.setPos(-500, +20);
        posicion.notificar();
        
        posicion.setPos(10, 213);
        posicion.notificar();
        
        System.out.println(controladorPosicion.getDistanciaRecorrida() + " metros.");
    }
}
