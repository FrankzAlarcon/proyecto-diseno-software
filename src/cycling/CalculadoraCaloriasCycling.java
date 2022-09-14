/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cycling;

/**
 *
 * @author Freddy Pallo <fredy.pallo@epn.edu.ec>
 */
public class CalculadoraCaloriasCycling {
    
    private double tiempo;
    private double peso;
    private double MET;

    public CalculadoraCaloriasCycling(double tiempo, double peso, double MET) {
        this.tiempo = tiempo;
        this.peso = peso;
        this.MET = MET;
    }
    
    
    public double calcularCaloriasQuemadas(){
        return MET*peso*tiempo*0.0175;
    }
    
}
