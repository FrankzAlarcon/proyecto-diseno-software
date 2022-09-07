
package running;


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
        try {
            Thread.sleep(tiempo*1000);
            rutinaEstandar.cambiarNivel(new Avanzado(rutinaEstandar));
        } catch (Exception e) {
        }
    }
    
    
    
    
}
