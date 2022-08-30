/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trailrunning;

/**
 *
 * @author green
 */
public class Velocidad {
    private double distancia = 1.0;
    private double tiempo = 1.0;
    public double calcular() {
        return distancia/tiempo;
    }

    public Velocidad() {
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    
}
