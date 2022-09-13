package padel;

import main.ControladorPosicion;
import main.DefinableAction;


public class PadelDesplazamientoAction implements DefinableAction {

    private ControladorPosicion controladorPosicion;
    private Partida partida;

    public PadelDesplazamientoAction(ControladorPosicion controladorPosicion, Partida partida) {
        this.controladorPosicion = controladorPosicion;
        this.partida = partida;
    }

    @Override
    public void exec() {
        this.partida.registrarDesplazamiento(this.controladorPosicion.getDesplazamiento());
    }
}
