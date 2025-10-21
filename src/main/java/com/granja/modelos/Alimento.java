package com.granja.modelos;

/**
 * Clase abstracta que representa un tipo de alimento para la granja.
 */
public abstract class Alimento {
    protected String nombre;
    protected double cantidadKg;
    protected String nutrientes;

    public Alimento(String nombre, double cantidadKg, String nutrientes) {
        this.nombre = nombre;
        this.cantidadKg = cantidadKg;
        this.nutrientes = nutrientes;
    }

    public abstract String obtenerInfo();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public String getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(String nutrientes) {
        this.nutrientes = nutrientes;
    }
}
