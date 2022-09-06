
package areamaquinas;

import java.time.LocalTime;
import java.util.ArrayList;
import main.ControladorPeso;
import main.ControladorRepeticiones;
import main.NumeroRepeticion;
import main.Peso;
import main.Rutina;

/**
 *
 * @author dell
 */
public class RutinaMaquinas implements Rutina{
    private ArrayList<NumeroRepeticion> numRepeticiones;
    private ArrayList<Peso> pesos;
    private ArrayList<Double> tiempos;
    private Double caloriasQuemadas;
    private double tiempoUltimo;
    private ControladorPeso controladorPeso ;
    private ControladorRepeticiones controladorRepeticion; 

    public RutinaMaquinas() {
        this.numRepeticiones = new ArrayList();
        this.pesos = new ArrayList();
        this.tiempos = new ArrayList();
        this.caloriasQuemadas = 0.0;
        this.tiempoUltimo = 0.0;
        this.controladorPeso =  null;
        this.controladorRepeticion = null;
    }
    
    public RutinaMaquinas(ArrayList<NumeroRepeticion> numRepeticiones, ArrayList<Peso> pesos, ArrayList<Double> tiempos, Double caloriasQuemadas, double tiempoActual, ControladorPeso controladorPeso, ControladorRepeticiones controladorRepeticion) {
        this.numRepeticiones = numRepeticiones;
        this.pesos = pesos;
        this.tiempos = tiempos;
        this.caloriasQuemadas = caloriasQuemadas;
        this.tiempoUltimo = tiempoActual;
        this.controladorPeso = controladorPeso;
        this.controladorRepeticion = controladorRepeticion;
    }
     
    @Override
    public void iniciar() {
        LocalTime tiempo=LocalTime.now();
        double segundosInicio = tiempo.getHour()*3600.0 + tiempo.getMinute() * 60.0 + tiempo.getSecond();
        this.tiempoUltimo=  segundosInicio;     
    }

    @Override
    public void detener() {
        //Finaliza la rutina y manda a llamar al metodo calorias quemadas
        LocalTime tiempo=LocalTime.now();
        double segundosFinal = tiempo.getHour()*3600.0 + tiempo.getMinute() * 60.0 + tiempo.getSecond();
        this.tiempos.add(segundosFinal - tiempoUltimo);
        caloriasQuemadas = this.calcularCaloriasQuemadas();
    }
    
    @Override
    public double calcularCaloriasQuemadas() {
        double calorias=0.0;
        for(int i=0; i < pesos.size(); i++){
            calorias += (this.numRepeticiones.get(i).getNumero() * this.pesos.get(i).getValor()) / this.tiempos.get(i); 
        }
        this.caloriasQuemadas = calorias;
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

    public ArrayList<Double> getTiempos() {
        return tiempos;
    }

    public void setTiempos(ArrayList<Double> tiempos) {
        this.tiempos = tiempos;
    }

    public Double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(Double caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public double getTiempoUltimo() {
        return tiempoUltimo;
    }

    public void setTiempoUltimo(double tiempoUltimo) {
        this.tiempoUltimo = tiempoUltimo;
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
    
    
    
    public void actualizarSubRutina(Peso nuevoPeso){
        this.numRepeticiones.add(new NumeroRepeticion()); //La repetecion se establece en 0
        this.pesos.add(nuevoPeso);
        LocalTime tiempo=LocalTime.now();
        double segundosFinal = tiempo.getHour()*3600.0 + tiempo.getMinute() * 60.0 + tiempo.getSecond();
        this.tiempos.add(segundosFinal - tiempoUltimo);
        this.tiempoUltimo = segundosFinal;
    }
    
    

 
    
    
    
}
