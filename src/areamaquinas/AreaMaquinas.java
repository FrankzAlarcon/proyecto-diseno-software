
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
        this.lista = null;
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
    
    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public ListaMaquinas getLista() {
        return lista;
    }

    public void setLista(ListaMaquinas lista) {
        this.lista = lista;
    }

    public AreaMaquinasPanel getArea() {
        return area;
    }

    public void setArea(AreaMaquinasPanel area) {
        this.area = area;
    }

    public RutinaMaquinas getRutina() {
        return rutina;
    }

    public void setRutina(RutinaMaquinas rutina) {
        this.rutina = rutina;
    }
    
    
    
    
}
