package com.granja.patrones.estructurales;

import com.granja.modelos.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Decorator concreto - Agrega historial reproductivo a un animal.
 */
public class AnimalConHistorialReproductivo extends AnimalDecorator {
    private List<String> crias;
    private List<Date> fechasGestacion;

    public AnimalConHistorialReproductivo(Animal animal) {
        super(animal);
        this.crias = new ArrayList<>();
        this.fechasGestacion = new ArrayList<>();
    }

    public void registrarCria(String nombrCria) {
        crias.add(nombrCria);
        fechasGestacion.add(new Date());
        System.out.println("👶 Cría '" + nombrCria + "' de " + nombre +
                         " registrada");
    }

    public List<String> getCrias() {
        return new ArrayList<>(crias);
    }

    public int getTotalCrias() {
        return crias.size();
    }

    @Override
    public String obtenerInfo() {
        return animalDecorado.obtenerInfo() +
               "\n  Total de crías: " + crias.size() +
               "\n  Crías: " + crias;
    }

    @Override
    public String toString() {
        return "Animal con Historial Reproductivo: " + animalDecorado.toString() +
               ", Crías: " + crias.size();
    }
}
