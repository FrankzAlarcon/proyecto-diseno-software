
package running;


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
        try {
            Thread.sleep(tiempo*1000);
            rutinaEstandar.detener();
                    
        } catch (Exception e) {
        }
    }
    
    
   
    
    
    
}
