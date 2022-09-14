
package padel;

public class CalculadoraCaloriasPadel {
    private final float metroFactor = 1.0f;
    private final float golpeFactor = 0.08f;
    private final float pesoFactor = 1.0f;
    private final float alturaFactor = 0.06f;
    private final float edadFactor = 5.72f;
    private final float sexoFemeninoFactor = 0.9f;

    public CalculadoraCaloriasPadel() {
    }
    
    public float calcularCaloriasQuemadas(Padel padel){
        float caloriasQuemadas = 0.0f;
        
        //Calorías quemadas por distancia recorrida. Fuente: https://www.marathonranking.com/entrenamiento/tabla-cuantas-calorias-quemas-por-km-corrido-2/#:~:text=A%20mayor%20peso%20m%C3%A1s%20calor%C3%ADas,%C3%9770%3D700%20calor%C3%ADas%20quemadas.
        caloriasQuemadas += metroFactor * padel.getPartida().getDistanciaRecorrida();

        //Calorías quemadas por número de golpes con la raqueta
        caloriasQuemadas += golpeFactor * padel.getPartida().getNumeroGolpes();

        //Calorías quemadas por peso y altura
        caloriasQuemadas *= pesoFactor * padel.getAplicacion().getUsuario().getPeso() * alturaFactor * padel.getAplicacion().getUsuario().getAltura();

        //Calorías quemadas por edad
        caloriasQuemadas *= edadFactor / padel.getAplicacion().getUsuario().getEdad();

        //Calorías por sexo. Fuente: https://gimnasiorizo.wordpress.com/2013/08/23/gasto-calorico-diferencia-entre-hombres-y-mujeres/
        if(padel.getAplicacion().getUsuario().getSexo() == 'F')
            caloriasQuemadas *= sexoFemeninoFactor;
        
        return caloriasQuemadas;
    }
}
