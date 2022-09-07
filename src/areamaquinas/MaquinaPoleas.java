
package areamaquinas;

import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class MaquinaPoleas extends Maquina{

    public MaquinaPoleas(int idMaquina, boolean ocupado, float factorCalorias) {
        super(idMaquina, ocupado, factorCalorias);
    }
    
    @Override
    public ImageIcon utilizar() {
        
         try {
            ImageIcon image = new ImageIcon(this.getClass().getResource("/res/maquinaPoleas.png"));
            return image;
        } catch (Exception e) {
            return null;
        }
        
        
    }

    @Override
    public String toString() {
        return "Maquina De Poleas "+getIdMaquina();
    }
    
    
}
