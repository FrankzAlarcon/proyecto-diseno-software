/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import main.Aplicacion;
import main.Rutina;
import trailrunning.Cronometro;

/**
 *
 * @author
 */
public class RutinaInternaCycling implements Rutina {

    private static double MET = 7.0;
    private BicicletaInterna bicicleta;
    private Cronometro cronometro;
    private Aplicacion aplicacion;

    public RutinaInternaCycling(Aplicacion aplicacion) {
        bicicleta = new BicicletaInterna(1);
        this.aplicacion = aplicacion;

    }

    public void iniciar() {
        cronometro = new Cronometro();
        cronometro.iniciar();
        bicicleta.iniciar();

    }

    public void detener() {
        cronometro.detener();
        bicicleta.detener();
    }

    public double calcularCaloriasQuemadas() {

        CalculadoraCaloriasCycling calculadora = new CalculadoraCaloriasCycling(
                cronometro.obtenerTiempo() / 60,
                aplicacion.getUsuario().getPeso(),
                MET);

        return calculadora.calcularCaloriasQuemadas();
    }

    public double obtenerDistancia() {
        return bicicleta.getDistaciaRecorrida();
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }
    

}
