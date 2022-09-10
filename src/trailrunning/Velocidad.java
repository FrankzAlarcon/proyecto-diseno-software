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
    private double distanciaRecorrida = 0.0;
    private Cronometro cronometro;
    public double calcular() {
        cronometro.detener();
        return distanciaRecorrida/cronometro.obtenerTiempo();
    }

    public Velocidad(Cronometro cronometro) {
        this.cronometro = cronometro;
    }

    public void actualizarDistanciaRecorrida(double nuevaDistancia){
        distanciaRecorrida += nuevaDistancia;
    }

    public double getDistanciaRecorrida(){
        return distanciaRecorrida;
    }




    
    
    
    
}
