package running;

public class CalculadoraCaloriasRunning {

    double velocidad, tiempo, peso;
    int indexVelocidad, indexInclinacion;

    public CalculadoraCaloriasRunning() {

        this.velocidad = velocidad;
        this.tiempo = tiempo;
        this.indexInclinacion = indexInclinacion;
        this.indexVelocidad = indexVelocidad;
        this.peso = peso;
    }
//hola
    public double calcularCaloriasEstandar(double tiempo, double peso) {
        double caloriasQuemadas = 0;
        caloriasQuemadas = tiempo * peso * 0.029;
        return caloriasQuemadas;
    }

    public double calcularCaloriasPersonalizado(int indexVelocidad, int indexInclinacion, double peso) {
        double caloriasQuemadas = 0;
        double pesoLibras = peso / 2.2;
        double mpm = indexVelocidad * 1.2 * 16.66;
        double calificacionPorcentual = 0;
        if (indexInclinacion == 2) {
            calificacionPorcentual = 20 / 100;
        } else if (this.indexInclinacion == 3) {
            calificacionPorcentual = 40 / 100;
        }

        if (indexVelocidad <= 5) {
            caloriasQuemadas = (0.1 * mpm) + (1.8 * mpm * calificacionPorcentual) + 3.5;
        } else {
            caloriasQuemadas = (0.2 * mpm) + (0.9 * mpm * calificacionPorcentual) + 3.5;
        }

        return caloriasQuemadas;
    }

}
