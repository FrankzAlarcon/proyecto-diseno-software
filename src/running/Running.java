package running;

import main.Aplicacion;

public class Running {

    //atributos
    private RutinaPersonalizadaRunning rutinaPersonalizada;
    private RutinaEstandarRunning rutinaEstandar;
    private Aplicacion aplicacion;

    //constructores
    public Running(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.rutinaEstandar = new RutinaEstandarRunning(aplicacion);
        this.rutinaPersonalizada = new RutinaPersonalizadaRunning(aplicacion);

    }

    //getters & setters
    public RutinaPersonalizadaRunning getRutinaPersonalizada() {
        return rutinaPersonalizada;
    }

    public void setRutinaPersonalizada(RutinaPersonalizadaRunning rutinaPersonalizada) {
        this.rutinaPersonalizada = rutinaPersonalizada;
    }

    public RutinaEstandarRunning getRutinaEstandar() {
        return rutinaEstandar;
    }

    public void setRutinaEstandar(RutinaEstandarRunning rutinaEstandar) {
        this.rutinaEstandar = rutinaEstandar;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    //metodos de clase
    //nos dirigimos  la respectivas clases
    public RutinaPersonalizadaRunning seleccionarPersonalizada() {
        return rutinaPersonalizada;

    }

    public RutinaEstandarRunning seleccionarEstandar() {
        return rutinaEstandar;

    }

}
