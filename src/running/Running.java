
package running;

import main.Aplicacion;

public class Running {
    //atributos
    private RutinaPersonalizadaRunning rutinaPersonalizada;
    private RutinaEstandarRunning rutinaEstandar;
    private Aplicacion aplicacion;

    //constructores
    
    public Running() {
    }
    
    public Running(RutinaPersonalizadaRunning rutinaPersonalizada, RutinaEstandarRunning rutinaEstandar, Aplicacion aplicacion) {
        this.rutinaPersonalizada = rutinaPersonalizada;
        this.rutinaEstandar = rutinaEstandar;
        this.aplicacion = aplicacion;
    }
    //getters & setters

    public RutinaPersonalizadaRunning getRutinaPersonalizada() {
        return rutinaPersonalizada;
    }

    public void setRutinaPersonalizada(RutinaPersonalizadaRunning rutinaPersonalizada) {
        this.rutinaPersonalizada = rutinaPersonalizada;
    }

    public RutinaEstandarRunning getRutinaEstandar() {
        return rutinaEstandar;
    }

    public void setRutinaEstandar(RutinaEstandarRunning rutinaEstandar) {
        this.rutinaEstandar = rutinaEstandar;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
    
    //metodos de clase
    
    //nos dirigimos  la respectivas clases
    public void seleccionarPersonalizada(){
       RutinaPersonalizadaRunning rutinaPersonalizada = new RutinaPersonalizadaRunning(0, 0, 0, 0);
       
        
    }
    
    public void seleccionarEstandar(){ 
        
    }
    
    
    
    
    

    
    
    
    
}
