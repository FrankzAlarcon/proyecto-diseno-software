
package areamaquinas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ListaMaquinas {
    private List maquinas;

    public ListaMaquinas() {
        this.maquinas = new ArrayList();
    }
    
    public void agregar(Maquina m){
        
        maquinas.add(m);
    }
    
    public void quitar(Maquina m){
        maquinas.remove(m);
    }
    
    public Maquina getMaquina(int indice){
        
        return (Maquina)maquinas.get(indice);
    }
    
}
