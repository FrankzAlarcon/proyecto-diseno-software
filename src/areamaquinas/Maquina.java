
package areamaquinas;

import javax.swing.ImageIcon;

/**
 *
 * @author Emilio Montalvo
 */
public abstract class Maquina {
    private int idMaquina;
    private boolean ocupado;
    private float factorCalorias;

    public Maquina(int idMaquina, boolean ocupado, float factorCalorias) {
        this.idMaquina = idMaquina;
        this.ocupado = ocupado;
        this.factorCalorias = factorCalorias;
    }
    
    
    public void iniciarUso(){
        ocupado=true;
        this.utilizar();
    }
    
    public void detenerUso(){
        ocupado=false;
        
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public float getFactorCalorias() {
        return factorCalorias;
    }

    public void setFactorCalorias(float factorCalorias) {
        this.factorCalorias = factorCalorias;
    }
    
    
    
    abstract ImageIcon utilizar();
    
    
}
