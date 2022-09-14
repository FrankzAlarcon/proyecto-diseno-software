package running;

import main.Rutina;
import main.Aplicacion;
import main.MainFrame;

public class RutinaEstandarRunning implements Rutina {

    //atributos
    private MainFrame mainFrame;
    private int velocidad;
    private int inclinacion;
    NivelRutinaRunning nivel;
    private int tiempo;
    private double caloriasQuemadas;
    private Aplicacion aplicacion;
    CalculadoraCaloriasRunning calculadora = new CalculadoraCaloriasRunning();

    //constructor
    public RutinaEstandarRunning(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.nivel = new Basico(this);
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getInclinacion() {
        return inclinacion;
    }

    public void setInclinacion(int inclinacion) {
        this.inclinacion = inclinacion;
    }

    public NivelRutinaRunning getNivel() {
        return nivel;
    }

    public void setNivel(NivelRutinaRunning nivel) {
        this.nivel = nivel;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(double caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    //metodos
    @Override
    public double calcularCaloriasQuemadas() {
        double caloriasQuemadas = 0;
        caloriasQuemadas = this.tiempo * mainFrame.getAplicacion().getUsuario().getPeso() * 0.029;
        return caloriasQuemadas;
    }

    @Override
    public void detener() {
        //this.calcularCaloriasQuemadas();
        nivel.actionThread.interrupt();
        mainFrame.setMainPanel(new ResultadosEstandarPanel(mainFrame));
    }

    @Override
    public void iniciar() {
        nivel.cambiarNivelRutina(null);

    }

    public void cambiarNivel(NivelRutinaRunning nivel) {
        this.nivel = nivel;
        this.nivel.cambiarNivelRutina(nivel);
    }

    public void actualizarTiempo() {
        tiempo += nivel.tiempo;
    }

    public void actualizarCalorias() {
        caloriasQuemadas += calculadora.calcularCaloriasEstandar(this.tiempo, mainFrame.getAplicacion().getUsuario().getPeso());
    }

}
