
package areamaquinas;

import javax.swing.JOptionPane;
import main.Aplicacion;
import main.MainFrame;

/**
 *
 * @author chris
 * a
 */
public class AreaMaquinas {
    private Aplicacion aplicacion;
    private ListaMaquinas lista;
    private AreaMaquinasPanel area;
    private RutinaMaquinas rutina;

    public AreaMaquinas(Aplicacion aplicacion, ListaMaquinas lista, RutinaMaquinas rutina) {
        this.aplicacion = aplicacion;
        this.lista = lista;
        this.rutina = rutina;
    }
    
     public AreaMaquinas(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        //this.lista = null;
        // Mover a AreaMaquinas
        this.lista=new ListaMaquinas();
        lista.agregar(new PrensaPiernas(1, false, 5));
        lista.agregar(new PrensaPiernas(2, false, 5));
        lista.agregar(new Dorsalera(1, false, 4));
        lista.agregar(new Dorsalera(2, false, 4));
        lista.agregar(new MaquinaPoleas(1, false, 3));
        lista.agregar(new MaquinaPoleas(2, false, 3));
        
        this.rutina=null;
    }
    
    public ListaMaquinas desplegarMaquinas(){
        return lista;
    }
    
    public Maquina seleccionarMaquina(int indice,MainFrame mainframe){
        if(lista.getMaquina(indice).isOcupado()){
                            
            JOptionPane.showMessageDialog(mainframe, "Maquina no disponible");
            return null;
        }else{
            return lista.getMaquina(indice);
            

        }
    }
    
    public Maquina getMaquina(int indice) {
        return lista.getMaquina(indice);
    }

    public void setLista(ListaMaquinas lista) {
        this.lista = lista;
    }

    public RutinaMaquinas getRutina() {
        return rutina;
    }

    public void setRutina(RutinaMaquinas rutina) {
        this.rutina = rutina;
    } 

    public Aplicacion getAplicacion() {
        return aplicacion;
    }
    
}
