
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
    private ResumenRutina resumen;
    private AreaMaquinasPanel area;

    public AreaMaquinas(Aplicacion aplicacion, ListaMaquinas lista, ResumenRutina resumen) {
        this.aplicacion = aplicacion;
        this.lista = lista;
        this.resumen = resumen;
    }
    
     public AreaMaquinas(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.lista = null;
        this.resumen = null;
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
    
    public ResumenRutina mostrarResultado(){
        return resumen;
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

    public ResumenRutina getResumen() {
        return resumen;
    }

    public void setResumen(ResumenRutina resumen) {
        this.resumen = resumen;
    }

    public AreaMaquinasPanel getArea() {
        return area;
    }

    public void setArea(AreaMaquinasPanel area) {
        this.area = area;
    }
    
    
    
    
}
