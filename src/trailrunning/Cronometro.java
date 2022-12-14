/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trailrunning;

import java.time.LocalTime;

/**
 *
 * @author green
 */
public class Cronometro {
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    
    public void iniciar() {
        horaInicio = LocalTime.now();
    }
    
    public void detener() {
        horaFinal = LocalTime.now();
    }
    public double obtenerTiempo() {
        if(horaInicio == null || horaFinal == null){
            return 0.0;
        }

        double segundosFinal = horaFinal.getHour()*3600.0 + horaFinal.getMinute() * 60.0 + horaFinal.getSecond();
        double segundosInicio = horaInicio.getHour()*3600.0 + horaInicio.getMinute() * 60.0 + horaInicio.getSecond();

        return segundosFinal - segundosInicio;
    }
}
