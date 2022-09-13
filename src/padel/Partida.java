package padel;

/* @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña*/

public class Partida {
    
    private float distanciaRecorrida;
    private int numeroGolpes;

    public Partida() {
        this.distanciaRecorrida = 0.0f;
        this.numeroGolpes = 0;
    }

    public float getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public int getNumeroGolpes() {
        return numeroGolpes;
    }
    
    public void registrarDesplazamiento(float desplazamiento){
        this.distanciaRecorrida += desplazamiento;
    } 
    
    public void registrarGolpe(){
        this.numeroGolpes++;
    }
    
    public void reiniciar(){
        this.distanciaRecorrida = 0.0f;
        this.numeroGolpes = 0;
    }
}
