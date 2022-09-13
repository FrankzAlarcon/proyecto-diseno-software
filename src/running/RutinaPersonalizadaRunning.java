package running;

import javax.swing.JOptionPane;
import main.Rutina;
import main.Aplicacion;
import main.MainFrame;

public class RutinaPersonalizadaRunning implements Rutina {

    //atributos
    private Aplicacion aplicacion;
    private double tiempo;
    private int nivelVelocidad;
    private int nivelInclinacion;
    private double caloriasQuemadas;
    private double distancia;

    public RutinaPersonalizadaRunning(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    //getters & setters
    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getNivelVelocidad() {
        return nivelVelocidad;
    }

    public void setNivelVelocidad(int nivelVelocidad) {
        this.nivelVelocidad = nivelVelocidad;
    }

    public void setCaloriasQuemadas(double caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getNivelInclinacion() {
        return nivelInclinacion;
    }

    public void setNivelInclinacion(int nivelInclinacion) {
        this.nivelInclinacion = nivelInclinacion;
    }

    public double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public double getDistancia() {
        return distancia;
    }

    //metodos
    public void obtenerDatos(double tiempo, int nivelVelocidad, int inclinacion) {
        this.setTiempo(tiempo);
        this.setNivelVelocidad(nivelVelocidad);
        this.setNivelInclinacion(inclinacion);

    }

    public void calcularDistancia() {
        int aux = this.nivelVelocidad;
        double min = this.tiempo / 60;
        switch (aux) {
            case 1:
                this.setDistancia(1.2 * min);
                break;
            case 2:
                this.setDistancia(2.4 * min);
                break;
            case 3:
                this.setDistancia(3.6 * min);
                break;
            case 4:
                this.setDistancia(4.8 * min);
                break;
            case 5:
                this.setDistancia(6 * min);
                break;
            case 6:
                this.setDistancia(7.2 * min);
                break;
            case 7:
                this.setDistancia(8.4 * min);
                break;
            case 8:
                this.setDistancia(9.6 * min);
                break;
            case 9:
                this.setDistancia(10.8 * min);
                break;
            case 10:
                this.setDistancia(12 * min);
                break;
            default:
                break;
        }

    }

    @Override
    public void iniciar() {

        setCaloriasQuemadas(calcularCaloriasQuemadas());
        calcularDistancia();

    }

    @Override
    public void detener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calcularCaloriasQuemadas() {
        double caloriasQuemadas = 0;
        double pesoLibras = aplicacion.getUsuario().getPeso() / 2.2;
        double mpm = this.nivelVelocidad * 1.2 * 16.66;
        double calificacionPorcentual = 0;

        if (this.nivelInclinacion == 2) {
            calificacionPorcentual = 20 / 100;
        } else if (this.nivelInclinacion == 3) {
            calificacionPorcentual = 40 / 100;
        }

        if (this.nivelVelocidad <= 5) {
            caloriasQuemadas = (0.1 * mpm) + (1.8 * mpm * calificacionPorcentual) + 3.5;
        } else {
            caloriasQuemadas = (0.2 * mpm) + (0.9 * mpm * calificacionPorcentual) + 3.5;
        }

        return caloriasQuemadas;
    }

    public void verificarDatos(double t, int v, int i) {

        if (t <= 0) {
            JOptionPane.showMessageDialog(null, "No se admiten tiempos negativos");
        }
        aplicacion.seleccionarRunning().seleccionarPersonalizada().obtenerDatos(t, v, i);
        aplicacion.seleccionarRunning().seleccionarPersonalizada().iniciar();

    }

}
