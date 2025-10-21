package com.granja.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un corral en la granja.
 */
public abstract class Corral {
    protected String id;
    protected int capacidad;
    protected String tipo;
    protected List<Animal> animales;

    public Corral(String id, int capacidad, String tipo) {
        this.id = id;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.animales = new ArrayList<>();
    }

    public boolean agregarAnimal(Animal animal) {
        if (animales.size() < capacidad) {
            animales.add(animal);
            System.out.println("✓ Animal " + animal.getNombre() + " agregado al corral " + id);
            return true;
        }
        System.out.println("✗ Corral " + id + " está lleno. No se puede agregar " + animal.getNombre());
        return false;
    }

    public List<Animal> obtenerAnimales() {
        return new ArrayList<>(animales);
    }

    public String getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getOcupacion() {
        return animales.size();
    }

    public String getTipo() {
        return tipo;
    }

    public abstract String obtenerInfo();

    @Override
    public String toString() {
        return "Corral{" +
                "id='" + id + '\'' +
                ", capacidad=" + capacidad +
                ", ocupacion=" + animales.size() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
