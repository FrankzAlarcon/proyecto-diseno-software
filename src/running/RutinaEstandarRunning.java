package running;

import main.Rutina;
import main.Aplicacion;

public class RutinaEstandarRunning implements Rutina {

    //atributos
    private double velocidad;
    private int inclinacion;
    NivelRutinaRunning nivel;
    private double tiempo;
    private double caloriasQuemadas;
    private Aplicacion aplicacion;

    //constructor
    public RutinaEstandarRunning(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    //metodos
    @Override
    public double calcularCaloriasQuemadas() {
        double caloriasQuemadas = 0;

        return caloriasQuemadas;
    }

    @Override
    public void detener() {

    }

    @Override
    public void iniciar() {

    }

}
