

package running;

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
        try {
            Thread.sleep(1000*tiempo);
            rutinaEstandar.cambiarNivel(new Moderado(rutinaEstandar));
        } catch (Exception e) {
        }
    }
    
    
    

   



    
}
