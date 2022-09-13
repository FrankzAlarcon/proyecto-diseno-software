
package padel;

import main.ControladorPresion;
import main.DefinableAction;

public class PadelGolpeAction implements DefinableAction{

    private Partida partida;

    public PadelGolpeAction(Partida partida) {
        this.partida = partida;
    }
    
    @Override
    public void exec() {
        this.partida.registrarGolpe();
    }
    
}
