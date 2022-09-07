
package running;


import main.ActionThread;

public class Avanzado extends NivelRutinaRunning{
    
   
    public Avanzado(RutinaEstandarRunning rutinaEstandar) {
        super(rutinaEstandar);
        inclinacion = 3;
        velocidad = 10;
        tiempo = 15;
    }
   
    
    
    //getters & setters
    
    
    //metodos

    @Override
    public void cambiarNivelRutina(NivelRutinaRunning nivel) {
        actionThread = new ActionThread(){
            @Override
            public void run() {
                try {

                    Thread.sleep(1000*tiempo);
                    rutinaEstandar.actualizarTiempo();
                    rutinaEstandar.actualizarCalorias();
                    rutinaEstandar.detener();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        actionThread.start();
    }
    
    
   
    
    
    
}
