/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Frankz
 */
public class Usuario {
    private String name;
    private int edad;
    private double peso;
    private double altura;
    private char sexo;

    public Usuario(String name, int edad, double peso, double altura, char sexo) {
        this.name = name;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public static void iniciarAplicacion(){
        new Aplicacion().iniciar();
    }

    public static void main(String[] args) {
        Usuario.iniciarAplicacion();
    }
    
}
