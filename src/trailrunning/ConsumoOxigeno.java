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
    private double grado = 0.0;
    private int numMediciones;
    private Velocidad velocidad;

    public ConsumoOxigeno(Velocidad velocidad) {
        this.velocidad = velocidad;
    }

    public double calcular() {
        double velocidad = this.velocidad.calcular()*60; //m/min
        double gradoPromedio = grado/numMediciones;
        double MPH = velocidad * (60.0/1609.34); // m/min a mph
        if(MPH <= 3.7){
            return 0.1*velocidad + (1.8*velocidad * gradoPromedio);
        }else {
            return 0.2*velocidad + (0.9*velocidad * gradoPromedio);
        }
        
    }

    public void actualizarGrado(double grado){
        if(grado >= 0) {
            this.grado += grado;
            numMediciones += 1;
        }
    }


    
    
    
}
