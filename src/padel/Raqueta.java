
package padel;

import main.*;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Raqueta {
    private String marca;
    private ControladorPosicion controladorPosicion;
    private ControladorPresion controladorPresion;
    private ActionThread thread;
    private float distanciaRecorrida;
    private int numeroGolpes;

    public Raqueta(String marca, float distanciaRecorrida, int numeroGolpes) {
        this.marca = marca;
        this.distanciaRecorrida = distanciaRecorrida;
        this.numeroGolpes = numeroGolpes;
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

    public float getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public int getNumeroGolpes() {
        return numeroGolpes;
    }
    
    public void iniciar(){
        //Reinicio de los datos
        this.numeroGolpes = 0;
        this.distanciaRecorrida = 0.0f;

        //Se inicia el medidor de posición
        Posicion posicion = new Posicion();
        SensorPosicion sensorPosicion = new SensorPosicion();
        this.controladorPosicion = new ControladorPosicion();
        
        //Se inicia el medidor de presión
        Presion presion = new Presion(0.06f);
        SensorPresion sensorPresion = new SensorPresion(1);
        this.controladorPresion = new ControladorPresion();

        //Configuración de los medidores
        posicion.setSensor(sensorPosicion);
        sensorPosicion.setControlador(controladorPosicion);
        this.controladorPosicion.setSensor(sensorPosicion);
        this.controladorPosicion.definirUmbral(0.35);
        
        presion.setSensor(sensorPresion);
        sensorPresion.setControlador(controladorPresion);
        this.controladorPresion.setSensor(sensorPresion);
        this.controladorPresion.definirUmbral(120);
        
        thread = new ActionThread(){

            @Override
            public void run() {
                while(isRunning) {
                    try {
                        sleep(2000);
                        posicion.notificar();
                        presion.notificar();

                    } catch (InterruptedException e) {
                        //throw new RuntimeException(e);
                    }
                }
            }

        };

        thread.start();
    }
    
    public void detener(){
        //this.controladorPosicion = null;
        //this.controladorPresion = null;
        thread.stopAction();
    };
}
