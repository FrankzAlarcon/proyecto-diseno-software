
package areamaquinas;

import javax.swing.ImageIcon;

/**
 *
 * @author Emilio Montalvo
 */
public class Dorsalera extends Maquina{

    public Dorsalera(int idMaquina, boolean ocupado, float factorCalorias) {
        super(idMaquina, ocupado, factorCalorias);
    }

     @Override
    public ImageIcon utilizar() {
        
         try {
            ImageIcon image = new ImageIcon(this.getClass().getResource("/res/dorsalera.png"));
            return image;
        } catch (Exception e) {
            return null;
        }
        
        
    }

    @Override
    public String toString() {
        return "Dorsalera "+getIdMaquina();
    }
    
    
    
}
