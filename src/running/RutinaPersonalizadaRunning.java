/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running;
import main.Rutina;


public class RutinaPersonalizadaRunning implements Rutina{
    //atributos
    
    private double tiempo;
    private double velocidad;
    private double inclinacion;
    private double caloriasQuemadas;

    //constructor
    public RutinaPersonalizadaRunning(double tiempo, double velocidad, double inclinacion, double caloriasQuemadas) {
        this.tiempo = tiempo;
        this.velocidad = velocidad;
        this.inclinacion = inclinacion;
        this.caloriasQuemadas = caloriasQuemadas;
    }
    
    //getters & setters

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getInclinacion() {
        return inclinacion;
    }

    public void setInclinacion(double inclinacion) {
        this.inclinacion = inclinacion;
    }

    public double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(double caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }
    
    
    

   
    //metodos
    
    public void obtenerDatos(double tiempo, double velocidad, int inclinacion, double caloriasQuemadas){
        this.setTiempo(tiempo);
        this.setVelocidad(velocidad);
        this.setInclinacion(inclinacion);
        
    }
    
    

    @Override
    public double calcularCaloriasQuemadas() {
        double caloriasQuemadas = 0;
        
        
        return caloriasQuemadas;
    }

    @Override
    public void detener() {
        
    }

    @Override
    public void iniciar() {
        
    }
   
    
}
