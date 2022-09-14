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
    private double caloriaaQuemadas;
    private Aplicacion aplicacion;

    public RutinaInternaCycling(Aplicacion aplicacion) {
        bicicleta = new BicicletaInterna(5);
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
        double segundos = cronometro.obtenerTiempo();
        caloriaaQuemadas = calcularCaloriasQuemadas();

    }

    public double calcularCaloriasQuemadas() {

        CalculadoraCaloriasCycling calculadora = new CalculadoraCaloriasCycling(
                cronometro.obtenerTiempo() / 60,
                aplicacion.getUsuario().getAltura(),
                MET);
         System.out.println("jsjs");

        return calculadora.calcularCaloriasQuemadas();
       
        //return aplicacion.getUsuario().getPeso()*cronometro.obtenerTiempo()*0.0175*MET/60;
    }

    public double calcularDistancia() {
        return bicicleta.getDistaciaRecorrida();
    }

    public void setBicicleta(BicicletaInterna bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }
}
