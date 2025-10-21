package com.granja.modelos;

import java.io.Serializable;

/**
 * Clase abstracta que representa un animal en la granja.
 * Actúa como base para los diferentes tipos de animales.
 */
public abstract class Animal implements Serializable {
    protected String id;
    protected double peso;
    protected int edad;
    protected String nombre;
    protected String tipoProduccion;

    public Animal(String id, String nombre, double peso, int edad, String tipoProduccion) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.tipoProduccion = tipoProduccion;
    }

    public abstract void comer();
    public abstract void dormir();
    public abstract void producir();
    public abstract String obtenerInfo();

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    @Override
    public String toString() {
        return "Animal: " + nombre +
                ", ID: " + id +
                ", Peso: " + String.format("%.2f", peso) + " kg" +
                ", Edad: " + edad + " años" +
                ", Tipo: " + tipoProduccion;
    }
}
