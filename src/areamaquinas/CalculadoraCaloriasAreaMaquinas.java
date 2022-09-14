/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

/**
 *
 * @author Frankz
 */
public class CalculadoraCaloriasAreaMaquinas {
    
    private double caloriasQuemadas;
    
    public double calcularCaloriasQuemadas(RutinaMaquinas rutina) {
        double calorias=0.0;
        double pesoUsuario = rutina.getAreaMaquinas().getAplicacion().getUsuario().getPeso();
        for(int i=0; i < rutina.getPesos().getPesos().size(); i++){            
            int repeticiones = rutina.getNumRepeticiones().getRepeticiones().get(i);
            double peso = rutina.getPesos().getPesos().get(i).getValor();
            calorias +=  pesoUsuario * 0.0175 + (repeticiones / peso);
        }
        this.caloriasQuemadas = calorias * rutina.getCronometro().obtenerTiempo() + rutina.getMaquina().getFactorCalorias()*0.1;
        return this.caloriasQuemadas;
    }

    public double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }
    
    
}
