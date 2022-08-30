/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trailrunning;

/**
 *
 * @author green
 */
public class ConsumoOxigeno {
    
    private double velocidad;
    private double grado;
    
    public double calcular() {
        double MPH = velocidad * (3600.0/1609.34); // m/s a mph
        if(MPH <= 3.7){
            return 0.1*velocidad + (1.8*velocidad*grado);
        }else {
           return 0.2*velocidad + (0.9*velocidad*grado);
        }
        
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setGrado(double grado) {
        this.grado = grado;
    }


    
    
    
}
