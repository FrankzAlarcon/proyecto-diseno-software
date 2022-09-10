package trailrunning;

import main.ControladorUbicacion;
import main.DefinableAction;

public class TrailRunningAction implements DefinableAction {

    private ControladorUbicacion controladorUbicacion;
    private Velocidad velocidad;
    private ConsumoOxigeno consumoOxigeno;

    public TrailRunningAction(ControladorUbicacion controladorUbicacion, Velocidad velocidad, ConsumoOxigeno consumoOxigeno) {
        this.controladorUbicacion = controladorUbicacion;
        this.velocidad = velocidad;
        this.consumoOxigeno = consumoOxigeno;
    }

    @Override
    public void exec() {
        consumoOxigeno.actualizarGrado(controladorUbicacion.getGrado());
        velocidad.actualizarDistanciaRecorrida(controladorUbicacion.getDistanciaRecorrida());

    }
}
