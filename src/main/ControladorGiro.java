package main;

public class ControladorGiro extends Controlador{


    private double anguloTotal;
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void ejecutarAccion() {
        double angulo = ((Giro)this.observador.getObservado()).getAnguloTotal();
        double numVueltas = angulo/(2*Math.PI); //numero de vueltas
        if(numVueltas >= umbral){
            anguloTotal += angulo;
        }

    }
    public double getAnguloTotal() {
        return anguloTotal;
    }
}
