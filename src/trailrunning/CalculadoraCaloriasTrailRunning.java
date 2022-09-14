package trailrunning;

public class CalculadoraCaloriasTrailRunning {
    private double tiempo;
    private double peso;
    private double MET;

    public CalculadoraCaloriasTrailRunning(double tiempo, double peso, double MET) {
        this.tiempo = tiempo;
        this.peso = peso;
        this.MET = MET;
    }

    public double calcularCaloriasQuemadas(){
        return tiempo * peso * MET;
    }
}
