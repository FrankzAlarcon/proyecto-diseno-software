
package areamaquinas;

/**
 *
 * @author dell
 */
public class MaquinaPoleas extends Maquina{

    public MaquinaPoleas(int idMaquina, boolean ocupado, float factorCalorias) {
        super(idMaquina, ocupado, factorCalorias);
    }

    @Override
    void utilizar() {
        System.out.println("uso Maquina de Poleas"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "MaquinaPoleas "+getIdMaquina();
    }
    
    
}
