/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padel;

import main.Aplicacion;

/**
 *
 * @author Grupo Padel: Jairo García, Santiago Gualotuña, Andrés Ponce, Anthony Simbaña
 */
public class Padel {
    private Raqueta raqueta;
    private Aplicacion aplicacion;
    private float caloriasQuemadas;

    public Padel(Raqueta raqueta, Aplicacion aplicacion, float caloriasQuemadas) {
        this.raqueta = raqueta;
        this.aplicacion = aplicacion;
        this.caloriasQuemadas = caloriasQuemadas;
    }
    
    public void iniciarEntrenamiento(){
    
    }
    
    public void detenerEntrenamiento(){}
    
    public float calcularCaloriasQuemadas(){
        return 1.0f;
    }
    
}
