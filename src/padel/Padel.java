
package padel;

import main.Aplicacion;

/**
 *
 * @author Anthony Simbaña
 */
public class Padel {

    public static Padel createInstance(Aplicacion aplicacion){
        return new Padel(new Raqueta("Nox"), aplicacion, new Partida());
    }

    private Raqueta raqueta;
    private Aplicacion aplicacion;
    private Partida partida;

    public Padel(Raqueta raqueta, Aplicacion aplicacion, Partida partida) {
        this.raqueta = raqueta;
        this.aplicacion = aplicacion;
        this.partida = partida;
    }

    public void iniciarEntrenamiento() {
        this.partida.reiniciar();
        this.raqueta.iniciar();
        this.raqueta.getControladorPosicion().setAction(new PadelDesplazamientoAction(this.raqueta.getControladorPosicion(), partida));
        this.raqueta.getControladorPresion().setAction(new PadelGolpeAction(partida));
    }

    public void detenerEntrenamiento() {
        this.raqueta.detener();
    }

    public Raqueta getRaqueta() {
        return raqueta;
    }
    
    public Partida getPartida(){
        return partida;
    }
    
    public Aplicacion getAplicacion(){
        return aplicacion;
    }
}
