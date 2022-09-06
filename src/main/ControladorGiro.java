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
        if (angulo>umbral) {
            anguloTotal=angulo;
            action.exec();
        }
        

        System.out.println("Control de giro---------------------->"+anguloTotal);
    }
    
    public double getAnguloTotal() {
        return anguloTotal;
    }

}
