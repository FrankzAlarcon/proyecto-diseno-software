package cycling;

import static java.lang.Thread.sleep;
import main.ActionThread;
import main.ControladorGiro;
import main.Giro;
import main.SensorGiro;

public class BicicletaExterna extends Bicicleta{

    public BicicletaExterna(int dificultad) {
        super(dificultad);
        this.dificultad = 1;
    }
    
    public void iniciar() {
        Giro giro = new Giro();
        SensorGiro sensorGiro = new SensorGiro();
        giro.setSensor(sensorGiro);
        sensorGiro.setFactor(giro);
        controladorGiro = new ControladorGiro();
        controladorGiro.setSensor(sensorGiro);
        sensorGiro.setControlador(controladorGiro);
        controladorGiro.definirUmbral(9);
        controladorGiro.setAction(new CyclingGiroActionExterna(controladorGiro, this));

        thread = new ActionThread() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        sleep(1000);
                        giro.notificar();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        thread.start();
    }
    
    
    public void detener() {
        thread.stopAction();
    }
    public double getDistaciaRecorrida() {
        return distanciaRecorrida;
    }
    
}
