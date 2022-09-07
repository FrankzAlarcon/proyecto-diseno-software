

package running;

import main.ActionThread;

public class Basico extends NivelRutinaRunning{
    
    

    public Basico(RutinaEstandarRunning rutinaEstandar) {
        super(rutinaEstandar);
        velocidad = 2;
        tiempo = 4;
        inclinacion = 1;
    }
   
    

    

    
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
                    rutinaEstandar.cambiarNivel(new Moderado(rutinaEstandar));
                } catch (Exception e) {
                }
            }
        };
        actionThread.start();
    }
    
    
    

   



    
}
