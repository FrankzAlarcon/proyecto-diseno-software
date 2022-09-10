
package areamaquinas;

import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.util.ArrayList;
import main.ActionThread;
import main.ControladorPeso;
import main.ControladorRepeticion;
import main.DefinableAction;
import main.Repeticion;
import main.Peso;
import main.Rutina;
import main.SensorPeso;
import main.SensorRepeticion;
import trailrunning.Cronometro;

/**
 *
 * @author dell
 */
public class RutinaMaquinas implements Rutina{
    private ArrayList<Repeticion> numRepeticionesAnterior;
    private ArrayList<Peso> pesosAnterior;
    private ListaPesos pesos;
    private ListaRepeticiones numRepeticiones;
    private Cronometro cronometro;
    private double tiempo;
    private double caloriasQuemadas;
    private double tiempoInicial;
    private ControladorPeso controladorPeso ;
    private ControladorRepeticion controladorRepeticion;
    private ActionThread threadPeso;
    private ActionThread threadRepeticion;
    private Maquina maquina;
    private AreaMaquinas areaMaquinas;


    public RutinaMaquinas() {
        this.numRepeticionesAnterior = new ArrayList();
        this.pesosAnterior = new ArrayList();
        this.tiempo = 0.0;
        this.caloriasQuemadas = 0.0;
        this.tiempoInicial = 0.0;
        this.controladorPeso =  null;
        this.controladorRepeticion = null;
        this.maquina = null;
        this.pesos = new ListaPesos();
        this.numRepeticiones = new ListaRepeticiones();
        this.cronometro = new Cronometro();
        this.areaMaquinas = null;
    }
    public RutinaMaquinas(Maquina m) {
        this.maquina = m;
        this.numRepeticionesAnterior = new ArrayList();
        this.pesosAnterior = new ArrayList();
        this.tiempo = 0.0;
        this.caloriasQuemadas = 0.0;
        this.tiempoInicial = 0.0;
        this.controladorPeso =  null;
        this.controladorRepeticion = null;
        this.pesos = new ListaPesos();
        this.numRepeticiones = new ListaRepeticiones();
        this.cronometro = new Cronometro();
        this.areaMaquinas = null;
    }
     
    @Override
    public void iniciar() {
        cronometro.iniciar();
        
        Peso peso=new Peso(5);
        SensorPeso sensorPeso=new SensorPeso();
        peso.setSensor(sensorPeso);
        sensorPeso.setFactor(peso);
        sensorPeso.setPesoActual(peso);
        
        Repeticion nrepeticion=new Repeticion(0);
        SensorRepeticion sensorRepeticion=new SensorRepeticion();
        nrepeticion.setSensor(sensorRepeticion);
        sensorRepeticion.setFactor(nrepeticion);
        sensorRepeticion.setRepeticion(nrepeticion);
        
        controladorPeso=new ControladorPeso(5, sensorPeso);
        controladorRepeticion=new ControladorRepeticion(3, sensorRepeticion);
        
        controladorPeso.setSensor(sensorPeso);
        controladorRepeticion.setSensor(sensorRepeticion);
        
        sensorRepeticion.setControlador(controladorRepeticion);
        sensorPeso.setControlador(controladorPeso);
        
        
        
        
        controladorPeso.setAction(new DefinableAction() {
            @Override
            public void exec() {
                actualizarSubRutina();
            }
        });
        threadPeso = new ActionThread() {
            @Override
            public void run() {
                while(isRunning) {
                    try {
                        sleep(1000);
                        peso.notificar();

                    } catch (InterruptedException e) {
                        //throw new RuntimeException(e);
                    }
                }
            }
        };
        
        controladorRepeticion.setAction(new DefinableAction() {
            @Override
            public void exec() {
                actualizarRepeticion();
            }
        });
        threadRepeticion = new ActionThread() {
            @Override
            public void run() {
                while(isRunning) {
                    try {
                        sleep(100);
                        nrepeticion.notificar();

                    } catch (InterruptedException e) {
                        //throw new RuntimeException(e);
                    }
                }
            }
        };

        threadPeso.start();
        threadRepeticion.start();        
    }

    @Override
    public void detener() {
        //Finaliza la rutina y manda a llamar al metodo calorias quemadas
        cronometro.detener();
        this.caloriasQuemadas = this.calcularCaloriasQuemadas(); //Retorna y asigna
    }
    
    //@Override
    /*public double calcularCaloriasQuemadas() {
        double calorias=0.0;
        for(int i=0; i < pesosAnterior.size(); i++){
            calorias += (this.numRepeticionesAnterior.get(i).getDistancia() * this.pesosAnterior.get(i).getValor()) / this.tiempo; 
        }
        return calorias ;
    }*/
    @Override
    public double calcularCaloriasQuemadas() {
        double calorias=0.0;
        double pesoUsuario = this.areaMaquinas.getAplicacion().getUsuario().getPeso();
        for(int i=0; i < this.pesos.getPesos().size(); i++){            
            int repeticiones = this.numRepeticiones.getRepeticiones().get(i);
            double peso = this.pesos.getPesos().get(i).getValor();
            calorias +=  pesoUsuario * 0.0175 + (repeticiones / peso);
        }
        calorias = calorias * cronometro.obtenerTiempo();
        return calorias;
    }

    public void agregarRepeticion(Repeticion nuevo){
        this.numRepeticionesAnterior.add(nuevo);
    }

    public void agregarPeso(Peso nuevo){
        this.pesosAnterior.add(nuevo);
    }    
    
    public void actualizarSubRutina(){
        SensorPeso sensorPeso = ((SensorPeso)controladorPeso.getSensor());
        Peso nuevoPeso=sensorPeso.getPesoActual();
        pesos.agregar(nuevoPeso);
        
        numRepeticiones.agregar(0); //La repetecion se establece en 0
        //this.numRepeticionesAnterior.add(new Repeticion()); 
        // this.agregarPeso(nuevoPeso);
    }
    
    public void actualizarRepeticion(){
        SensorRepeticion sensorRepeticion = ((SensorRepeticion)controladorRepeticion.getSensor());
        Repeticion nuevaRepeticion=sensorRepeticion.getRepeticion();
        
        numRepeticiones.actualizarUltimo();

        //numRepeticionesAnterior.set(numRepeticionesAnterior.size()-1, nuevaRepeticion);               
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    
    
    
    /*public double calcularPromedioPesos(){
        double aux = 0.0;
        for(int i=0; i < this.pesosAnterior.size(); i++ ){
            aux += pesosAnterior.get(i).getValor();        
        }
        return aux;
    }*/
    /*public int calcularNumRepeteciciones(){
        int aux = 0;
        for(int i=0; i < this.numRepeticionesAnterior.size(); i++ ){
            aux += numRepeticionesAnterior.get(i).getDistancia();        
        }
        return aux;
    }  */

    public ListaRepeticiones getNumRepeticiones() {
        return numRepeticiones;
    }

    public ListaPesos getPesos() {
        return pesos;
    }

    public void setAreaMaquinas(AreaMaquinas areaMaquinas) {
        this.areaMaquinas = areaMaquinas;
    }
    
    
    
}
