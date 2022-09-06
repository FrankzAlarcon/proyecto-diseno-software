
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
        this.controladorPeso =  new ControladorPeso(5);
        this.controladorRepeticion = new ControladorRepeticiones(5);
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
    
    public void cambiarRutina(){
        //Cambia la rutina y guarda los valores correpondientes
        LocalTime tiempo=LocalTime.now();
        double segundosFinal = tiempo.getHour()*3600.0 + tiempo.getMinute() * 60.0 + tiempo.getSecond();
        this.tiempos.add(segundosFinal - tiempoUltimo);
        this.tiempoUltimo = segundosFinal;

    }
    @Override
    public double calcularCaloriasQuemadas() {
        double calorias = (numRepeticiones.get(0).getNumero() * pesos.get(0).getValor()) / tiempos.get(0); 
        return calorias ;
    }

    public ArrayList<NumeroRepeticion> getNumRepeticiones() {
        return numRepeticiones;
    }

    public void setNumRepeticiones(ArrayList<NumeroRepeticion> numRepeticiones) {
        this.numRepeticiones = numRepeticiones;
    }

    public ArrayList<Peso> getPesos() {
        return pesos;
    }

    public void setPesos(ArrayList<Peso> pesos) {
        this.pesos = pesos;
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
    
    


    public void actualizarDatos(){

    }

 
    
    
    
}
