/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padel;

import main.Aplicacion;

/**
 *
 * @author Anthony Simbaña
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

    public void iniciarEntrenamiento() {

    }

    public void detenerEntrenamiento() {
    }

    public Raqueta getRaqueta() {
        return raqueta;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public float getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public float calcularCaloriasQuemadas() {
        //Calorías quemadas por distancia recorrida. Fuente: https://www.marathonranking.com/entrenamiento/tabla-cuantas-calorias-quemas-por-km-corrido-2/#:~:text=A%20mayor%20peso%20m%C3%A1s%20calor%C3%ADas,%C3%9770%3D700%20calor%C3%ADas%20quemadas.
        caloriasQuemadas += this.raqueta.getControladorPosicion().getDistanciaRecorrida();

        //Calorías quemadas por número de golpes con la raqueta
        caloriasQuemadas += 0.08 * this.raqueta.getControladorPresion().getNumeroGolpes();

        //Calorías quemadas por peso y altura
        caloriasQuemadas *= this.aplicacion.getUsuario().getPeso() * 0.06 * this.aplicacion.getUsuario().getAltura();

        //Calorías quemadas por edad
        caloriasQuemadas -= 5.72 * this.aplicacion.getUsuario().getEdad();

        //Calorías quemadas por altura

        //Calorías por sexo. Fuente: https://gimnasiorizo.wordpress.com/2013/08/23/gasto-calorico-diferencia-entre-hombres-y-mujeres/
        if(this.aplicacion.getUsuario().getSexo() == 'F')
            caloriasQuemadas *= 0.9;

        return caloriasQuemadas;
    }

}
