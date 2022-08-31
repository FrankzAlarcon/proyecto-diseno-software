/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padel;
import java.time.LocalTime;

public class Temporizador {
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    
    public void iniciar() {
        horaInicio = LocalTime.now();
    }
    
    public void detener() {
        horaFinal = LocalTime.now();
    }
    
    public double calcular() {
        if(horaInicio == null || horaFinal == null){
            return 0.0;
        }
        
        double segundosFinal = horaFinal.getHour()*3600.0 + horaFinal.getMinute() * 60.0 + horaFinal.getSecond();
        double segundosInicio = horaInicio.getHour()*3600.0 + horaInicio.getMinute() * 60.0 + horaInicio.getSecond();
                
        return segundosFinal - segundosInicio;
    }
}
