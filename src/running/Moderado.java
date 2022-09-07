
package running;


import main.ActionThread;

public class Moderado extends NivelRutinaRunning{

  

    public Moderado(RutinaEstandarRunning rutinaEstandar) {
        super(rutinaEstandar);
        inclinacion = 2;
        tiempo = 7;
        velocidad = 6;
    }
   
    
    
    


    
    //metodos

    @Override
    public void cambiarNivelRutina(NivelRutinaRunning nivel) {
        actionThread = new ActionThread(){
            @Override
            public void run() {
                try {
                    System.out.println("Estado moderado");
                    Thread.sleep(1000*tiempo);
                    rutinaEstandar.actualizarTiempo();
                    rutinaEstandar.actualizarCalorias();
                    rutinaEstandar.cambiarNivel(new Avanzado(rutinaEstandar));
                } catch (Exception e) {
                }
            }
        };
        actionThread.start();
    }
    
    
    
    
}
