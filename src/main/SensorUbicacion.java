/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author green
 */
public class SensorUbicacion extends Sensor {
    private Ubicacion anterior;
    public SensorUbicacion() {

    }

    public Ubicacion getUbicacionActual(){
        return (Ubicacion) observado;
    }

    public Ubicacion getUbicacionAnterior() {
        return anterior;
    }

    public void setUbicacion(Observado ubicacion) {
        if(this.observado != null)
            this.anterior = (Ubicacion) this.observado;
        this.observado = ubicacion;
    }


    @Override
    public void actualizar() {
        controlador.verificarUmbral();
    }

}
