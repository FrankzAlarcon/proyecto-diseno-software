
package padel;

import main.Aplicacion;

/**
 *
 * @author Anthony Simbaña
 */
public class Padel {

    public static Padel createInstance(Aplicacion aplicacion){
        return new Padel(new Raqueta("Nox"), aplicacion, new Partida(), 0.0f);
    }

    private Raqueta raqueta;
    private Aplicacion aplicacion;
    private Partida partida;
    private float caloriasQuemadas;

    public Padel(Raqueta raqueta, Aplicacion aplicacion, Partida partida, float caloriasQuemadas) {
        this.raqueta = raqueta;
        this.aplicacion = aplicacion;
        this.partida = partida;
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public void iniciarEntrenamiento() {
        this.caloriasQuemadas = 0.0f;
        this.partida.reiniciar();
        this.raqueta.iniciar();
        this.raqueta.getControladorPosicion().setAction(new PadelDesplazamientoAction(this.raqueta.getControladorPosicion(), partida));
        this.raqueta.getControladorPresion().setAction(new PadelGolpeAction(partida));
    }

    public void detenerEntrenamiento() {
        this.raqueta.detener();
        this.calcularCaloriasQuemadas();
    }

    public Raqueta getRaqueta() {
        return raqueta;
    }
    
    public Partida getPartida(){
        return partida;
    }

    public float getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    private void calcularCaloriasQuemadas() {
        //Calorías quemadas por distancia recorrida. Fuente: https://www.marathonranking.com/entrenamiento/tabla-cuantas-calorias-quemas-por-km-corrido-2/#:~:text=A%20mayor%20peso%20m%C3%A1s%20calor%C3%ADas,%C3%9770%3D700%20calor%C3%ADas%20quemadas.
        caloriasQuemadas += this.partida.getDistanciaRecorrida();

        //Calorías quemadas por número de golpes con la raqueta
        caloriasQuemadas += 0.08 * this.partida.getNumeroGolpes();

        //Calorías quemadas por peso y altura
        caloriasQuemadas *= this.aplicacion.getUsuario().getPeso() * 0.06 * this.aplicacion.getUsuario().getAltura();

        //Calorías quemadas por edad
        caloriasQuemadas *= 5.72 / this.aplicacion.getUsuario().getEdad();

        //Calorías por sexo. Fuente: https://gimnasiorizo.wordpress.com/2013/08/23/gasto-calorico-diferencia-entre-hombres-y-mujeres/
        if(this.aplicacion.getUsuario().getSexo() == 'F')
            caloriasQuemadas *= 0.9;
    }

}
