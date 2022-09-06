package main;

public class ControladorGiro extends Controlador{


    private double anguloTotal;
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        double angulo = ((Giro)this.sensor.getObservado()).getAnguloTotal();
        double numVueltas = angulo/(2*Math.PI); //numero de vueltas
        if(numVueltas >= umbral){
            anguloTotal += angulo;
        }

        System.out.println("Control de giro---------------------->"+anguloTotal);
    }
    public double getAnguloTotal() {
        return anguloTotal;
    }
}
