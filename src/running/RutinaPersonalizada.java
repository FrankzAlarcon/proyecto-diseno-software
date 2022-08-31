/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running;


public class RutinaPersonalizada extends RutinaRunning{
    double tiempo;
    double velocidad;
    double inclinacion;

    public RutinaPersonalizada() {
        this.tiempo = tiempo;
        this.velocidad = velocidad;
        this.inclinacion = inclinacion;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setInclinacion(double inclinacion) {
        this.inclinacion = inclinacion;
    }
    
    
    public void obtenerDatos(){
        
    }

    @Override
    public double calcularCaloriasQuemadas() {
        return super.calcularCaloriasQuemadas(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void detener() {
        super.detener(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void iniciar() {
        super.iniciar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
   
    
}
