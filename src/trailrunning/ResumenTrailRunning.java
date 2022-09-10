package trailrunning;

import main.*;

public class ResumenTrailRunning {
    private double distanciaRecorrida;
    private double caloriasQuemadas;
    private double oxigenoConsumido;
    private double MET = 7.0;

    public ResumenTrailRunning() {
    }

    public void actualizarDatos(Velocidad velocidad, Cronometro cronometro, Usuario usuario, ConsumoOxigeno consumoOxigeno){
        oxigenoConsumido = consumoOxigeno.calcular(); //El consumo oxigeno detiene el modulo de velocidad y a su vez este detiene el cronometro
        distanciaRecorrida = velocidad.getDistanciaRecorrida();
        caloriasQuemadas = calcularCalorias(usuario, cronometro);
    }

    private double calcularCalorias(Usuario usuario, Cronometro cronometro){
        return MET * usuario.getPeso() * cronometro.obtenerTiempo()/60;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public double getOxigenoConsumido() {
        return oxigenoConsumido;
    }

    public double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }
}
