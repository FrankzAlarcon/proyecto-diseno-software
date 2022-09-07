
package areamaquinas;

import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.util.ArrayList;
import main.ActionThread;
import main.ControladorPeso;
import main.ControladorRepeticiones;
import main.DefinableAction;
import main.NumeroRepeticion;
import main.Peso;
import main.Rutina;
import main.SensorPeso;
import main.SensorRepeticion;
import main.SensorUbicacion;

/**
 *
 * @author dell
 */
public class RutinaMaquinas implements Rutina{
    private ArrayList<NumeroRepeticion> numRepeticiones;
    private ArrayList<Peso> pesos;
    private double tiempo;
    private Double caloriasQuemadas;
    private double tiempoInicial;
    private ControladorPeso controladorPeso ;
    private ControladorRepeticiones controladorRepeticion; 
    private ActionThread threadPeso;
    private ActionThread threadRepeticion;
    private Maquina maquina;


    public RutinaMaquinas() {
        this.numRepeticiones = new ArrayList();
        this.pesos = new ArrayList();
        this.tiempo = 0.0;
        this.caloriasQuemadas = 0.0;
        this.tiempoInicial = 0.0;
        this.controladorPeso =  null;
        this.controladorRepeticion = null;
        
//      pesos.add(new Peso(0));
//      numRepeticiones.add(new NumeroRepeticion(0));
//      tiempos.add(tiempoUltimo)
    }
    
    public RutinaMaquinas(ArrayList<NumeroRepeticion> numRepeticiones, ArrayList<Peso> pesos, double tiempo, Double caloriasQuemadas, double tiempoActual, ControladorPeso controladorPeso, ControladorRepeticiones controladorRepeticion) {
        this.numRepeticiones = numRepeticiones;
        this.pesos = pesos;
        this.tiempo = tiempo;
        this.caloriasQuemadas = caloriasQuemadas;
        this.tiempoInicial = tiempoActual;
        this.controladorPeso = controladorPeso;
        this.controladorRepeticion = controladorRepeticion;
    }
     
    @Override
    public void iniciar() {
        LocalTime tiempo=LocalTime.now();
        double segundosInicio = tiempo.getHour()*3600.0 + tiempo.getMinute() * 60.0 + tiempo.getSecond();
        this.tiempoInicial=  segundosInicio;
        
        Peso peso=new Peso(5);
        SensorPeso sensorPeso=new SensorPeso();
        peso.setSensor(sensorPeso);
        sensorPeso.setObservado(peso);
        sensorPeso.setPesoActual(peso);
        
        NumeroRepeticion nrepeticion=new NumeroRepeticion(0);
        SensorRepeticion sensorRepeticion=new SensorRepeticion();
        nrepeticion.setSensor(sensorRepeticion);
        sensorRepeticion.setObservado(nrepeticion);
        sensorRepeticion.setNumRepeticiones(nrepeticion);
        
        controladorPeso=new ControladorPeso(5, sensorPeso);
        controladorRepeticion=new ControladorRepeticiones(1, sensorRepeticion);
        
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
                        sleep(1000);
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
        LocalTime tiempo=LocalTime.now();
        double segundosFinal = tiempo.getHour()*3600.0 + tiempo.getMinute() * 60.0 + tiempo.getSecond();
        this.tiempo = (segundosFinal - tiempoInicial);
        this.caloriasQuemadas = this.calcularCaloriasQuemadas(); //Retorna y asigna
    }
    
    @Override
    public double calcularCaloriasQuemadas() {
        double calorias=0.0;
        for(int i=0; i < pesos.size(); i++){
            calorias += (this.numRepeticiones.get(i).getNumero() * this.pesos.get(i).getValor()) / this.tiempo; 
        }
        return calorias ;
    }

    public ArrayList<NumeroRepeticion> getNumRepeticiones() {
        return numRepeticiones;
    }

    public void setNumRepeticiones(ArrayList<NumeroRepeticion> numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }
    public void agregarRepeticion(NumeroRepeticion nuevo){
        this.numRepeticiones.add(nuevo);
    }

    public ArrayList<Peso> getPesos() {
        return pesos;
    }

    public void setPesos(ArrayList<Peso> pesos) {
        this.pesos = pesos;
    }
    public void agregarPeso(Peso nuevo){
        this.pesos.add(nuevo);
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public Double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(Double caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public double getTiempoUltimo() {
        return tiempoInicial;
    }

    public void setTiempoUltimo(double tiempoUltimo) {
        this.tiempoInicial = tiempoUltimo;
    }

    public ControladorPeso getControladorPeso() {
        return controladorPeso;
    }

    public void setControladorPeso(ControladorPeso controladorPeso) {
        this.controladorPeso = controladorPeso;
    }

    public ControladorRepeticiones getControladorRepeticion() {
        return controladorRepeticion;
    }

    public void setControladorRepeticion(ControladorRepeticiones controladorRepeticion) {
        this.controladorRepeticion = controladorRepeticion;
    }
    
    
    
    public void actualizarSubRutina(){
        SensorPeso sensorPeso = ((SensorPeso)controladorPeso.getSensor());
        Peso nuevoPeso=sensorPeso.getPesoActual();
        this.numRepeticiones.add(new NumeroRepeticion()); //La repetecion se establece en 0
        this.pesos.add(nuevoPeso);
    }
    
    public void actualizarRepeticion(){
        SensorRepeticion sensorRepeticion = ((SensorRepeticion)controladorRepeticion.getSensor());
        NumeroRepeticion nuevaRepeticion=sensorRepeticion.getNumRepeticiones();
        
        numRepeticiones.add(new NumeroRepeticion(0));
        numRepeticiones.set(numRepeticiones.size()-1, nuevaRepeticion);
        
       
    }

    public ActionThread getThreadPeso() {
        return threadPeso;
    }

    public void setThreadPeso(ActionThread threadPeso) {
        this.threadPeso = threadPeso;
    }

    public ActionThread getThreadRepeticion() {
        return threadRepeticion;
    }

    public void setThreadRepeticion(ActionThread threadRepeticion) {
        this.threadRepeticion = threadRepeticion;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    
    public double calcularPromedioPesos(){
        double aux = 0.0;
        for(int i=0; i < this.pesos.size(); i++ ){
            aux += pesos.get(i).getValor();        
        }
        return aux;
    }
    public int calcularNumRepeteciciones(){
        int aux = 0;
        for(int i=0; i < this.numRepeticiones.size(); i++ ){
            aux += numRepeticiones.get(i).getNumero();        
        }
        return aux;
    }
    
    
    

 
    
    
    
}
