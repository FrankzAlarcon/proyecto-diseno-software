/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cycling;

import static java.lang.Thread.sleep;
import main.ActionThread;
import main.Aplicacion;
import main.ControladorUbicacion;
import main.DefinableAction;
import main.Rutina;
import main.SensorUbicacion;
import main.Ubicacion;
import trailrunning.Cronometro;

/**
 *
 * @author Stalin
 */
public class RutinaInternaCycling implements Rutina {

    private static double MET = 7.0;
    private Bicicleta bicicleta;
    private Cronometro cronometro;
    private ControladorUbicacion controladorUbicacion;
    private double caloriaaQuemadas;
    private Ruta ruta;
    private double distanciaRecorrida;
    private Aplicacion aplicacion;

    public RutinaInternaCycling(Aplicacion aplicacion) {
        bicicleta = new Bicicleta(5);
        this.aplicacion=aplicacion;
        
    }

    public ControladorUbicacion getControladorUbicacion() {
        return controladorUbicacion;
    }

    public void iniciar() {
        cronometro = new Cronometro();
        cronometro.iniciar();
        bicicleta.iniciar();

    }

    public void detener() {
        cronometro.detener();
        bicicleta.detener();
        double segundos = cronometro.calcular();
        caloriaaQuemadas = calcularCaloriasQuemadas();

    }

    public double calcularCaloriasQuemadas() {

        return aplicacion.getUsuario().getPeso()*cronometro.calcular()/60*0.0175*MET; 
        //return 0;
    }

    public double calcularDistancia() {
        return bicicleta.getDistaciaRecorrida();
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }
}
