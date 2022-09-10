/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areamaquinas;

import java.util.ArrayList;

/**
 *
 * @author Frankz
 */
public class ListaRepeticiones {
    private ArrayList<Integer> repeticiones;
    
    public ListaRepeticiones() {
        this.repeticiones = new ArrayList<>();
    }
    
    public void agregar(int numero) {
        this.repeticiones.add(numero);
    }
    
    public void quitar(int index) {
        this.repeticiones.remove(index);
    }
    
    public void actualizarUltimo() {
        if(this.repeticiones.size() == 0){
            this.repeticiones.add(0);
        }
        int ultimoValor = this.repeticiones.get(this.repeticiones.size() - 1);
        this.repeticiones.set(this.repeticiones.size()-1, ++ultimoValor);
    }
    
    public int calcularTotal() {
        int aux = 0;
        for(int i=0; i < this.repeticiones.size(); i++ ){
            aux += this.repeticiones.get(i);         
        }
        return aux;
    }

    public ArrayList<Integer> getRepeticiones() {
        return repeticiones;
    }   
} 
