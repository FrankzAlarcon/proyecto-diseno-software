/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

/**
 *
 * @author Emilio Montalvo
 */
public class ResumenRutina {
    private Maquina maquina;
    private RutinaMaquinas rutina;

    public ResumenRutina(Maquina maquina, RutinaMaquinas rutina) {
        this.maquina = maquina;
        this.rutina = rutina;
    }
    
    
    public void iniciar(){
        maquina.iniciarUso();
        rutina.iniciar();
    }
    
    public void finalizar(){
        maquina.detenerUso();
        rutina.detener();
        
    }
    public void visualizarDatos(){
        
    }
    
    public void refrescarDatos(){
        
    }
    
    public void mostrarResumen(){
        
    }
    
    public void mostrar(){
        
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public RutinaMaquinas getRutina() {
        return rutina;
    }

    public void setRutina(RutinaMaquinas rutina) {
        this.rutina = rutina;
    }
    
    
}
