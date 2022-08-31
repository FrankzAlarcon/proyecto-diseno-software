
package areamaquinas;

/**
 *
 * @author dell
 */
public class PrensaPiernas extends Maquina{
    
    public PrensaPiernas(int idMaquina, boolean ocupado, float factorCalorias) {
        super(idMaquina, ocupado, factorCalorias);
    }
    
    @Override
    void utilizar() {
        System.out.println("uso Maquina de Prensa de Piernas"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Prensa Piernas";
    }
    
    
    
}
