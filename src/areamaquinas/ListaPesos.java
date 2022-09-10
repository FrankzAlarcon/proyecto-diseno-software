/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import java.util.ArrayList;
import main.Peso;

/**
 *
 * @author Frankz
 */
public class ListaPesos {
    private ArrayList<Peso> pesos;

    public ListaPesos() {
        this.pesos = new ArrayList<>();
        this.pesos.add(new Peso(4.0));
    }
    
    public void agregar(Peso peso) {        
        this.pesos.add(peso);
    }
    
    public void quitar(int index) {
        this.pesos.remove(index);
    }
    
    public double calcularPromedio() {
        double aux = 0.0;
        for(int i=0; i < this.pesos.size(); i++ ){
            aux += this.pesos.get(i).getValor();        
        }
        aux = aux / this.pesos.size();
        return aux;
    }

    public ArrayList<Peso> getPesos() {
        return pesos;
    }        
}
