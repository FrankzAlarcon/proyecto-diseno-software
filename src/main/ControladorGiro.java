package main;

public class ControladorGiro extends Controlador{

    private double anguloTotal;
    
    public ControladorGiro(){
        this.anguloTotal = 0.0;
    }
    
    @Override
    public void definirUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public void verificarUmbral() {
        double angulo = ((Giro)this.sensor.getFactor()).getAnguloTotal();
        if (angulo>umbral) {
            anguloTotal=angulo;
            action.exec();
        }
    }
    
    public double getAnguloTotal() {
        return anguloTotal;
    }

}
