
package areamaquinas;

/**
 *
 * @author Emilio Montalvo
 */
public class Dorsalera extends Maquina{

    public Dorsalera(int idMaquina, boolean ocupado, float factorCalorias) {
        super(idMaquina, ocupado, factorCalorias);
    }

    @Override
    void utilizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
