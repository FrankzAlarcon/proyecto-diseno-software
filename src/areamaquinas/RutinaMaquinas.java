
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
    private ListaPesos pesos;
    private ListaRepeticiones numRepeticiones;
    private Cronometro cronometro;
    private ControladorPeso controladorPeso ;
    private ControladorRepeticion controladorRepeticion;
    private ActionThread threadPeso;
    private ActionThread threadRepeticion;
    private Maquina maquina;
    private AreaMaquinas areaMaquinas;


    public RutinaMaquinas() {
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
        
        
        
        
        controladorPeso.setAction(new PesoAction(controladorPeso, this));
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
        
        controladorRepeticion.setAction(new RepeticionAction(controladorRepeticion, this));
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
        //this.caloriasQuemadas = this.calcularCaloriasQuemadas(); //Retorna y asigna
    }
    
    @Override
    public double calcularCaloriasQuemadas() {
         CalculadoraCaloriasAreaMaquinas calculadora = new CalculadoraCaloriasAreaMaquinas();
         calculadora.calcularCaloriasQuemadas(this);    
         return calculadora.getCaloriasQuemadas();
    }    

    
    public void actualizarSubRutina(){
        SensorPeso sensorPeso = ((SensorPeso)controladorPeso.getSensor());
        Peso nuevoPeso=sensorPeso.getPesoActual();
        pesos.agregar(nuevoPeso);
        
        numRepeticiones.agregar(0); //La repetecion se establece en 0
    }
    
    public void actualizarRepeticion(){
        SensorRepeticion sensorRepeticion = ((SensorRepeticion)controladorRepeticion.getSensor());
        Repeticion nuevaRepeticion=sensorRepeticion.getRepeticion();
        
        numRepeticiones.actualizarUltimo();
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public ListaRepeticiones getNumRepeticiones() {
        return numRepeticiones;
    }

    public ListaPesos getPesos() {
        return pesos;
    }

    public void setAreaMaquinas(AreaMaquinas areaMaquinas) {
        this.areaMaquinas = areaMaquinas;
    }     

    public Cronometro getCronometro() {
        return cronometro;
    }

    public AreaMaquinas getAreaMaquinas() {
        return areaMaquinas;
    }
    
    
}
