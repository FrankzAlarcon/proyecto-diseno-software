package running;

import main.ActionThread;

public abstract class NivelRutinaRunning {
    RutinaEstandarRunning rutinaEstandar;
    protected int tiempo;
    protected int velocidad;
    protected int inclinacion;
    protected ActionThread actionThread;
    
   
    public NivelRutinaRunning(RutinaEstandarRunning rutinaEstandar) {
        this.rutinaEstandar = rutinaEstandar;
        
    }
    
    public abstract void cambiarNivelRutina(NivelRutinaRunning nivel);
        
    
    
    
    
    
    
}
