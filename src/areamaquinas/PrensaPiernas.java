
package areamaquinas;

import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class PrensaPiernas extends Maquina{
    
    public PrensaPiernas(int idMaquina, boolean ocupado, float factorCalorias) {
        super(idMaquina, ocupado, factorCalorias);
    }
    
     @Override
    public ImageIcon utilizar() {
        
         try {
            ImageIcon image = new ImageIcon(this.getClass().getResource("/res/prensaPiernas.png"));
            return image;
        } catch (Exception e) {
            return null;
        }
        
        
    }

    @Override
    public String toString() {
        return "Prensa de piernas "+getIdMaquina();
    }
    
    
    
}
