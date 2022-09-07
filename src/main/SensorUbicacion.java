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
        return (Ubicacion) factor;
    }

    public Ubicacion getUbicacionAnterior() {
        return anterior;
    }

    public void setUbicacion(Factor ubicacion) {
        if(this.factor != null)
            this.anterior = (Ubicacion) this.factor;
        this.factor = ubicacion;
    }


    @Override
    public void actualizar() {
        controlador.verificarUmbral();
    }

}
