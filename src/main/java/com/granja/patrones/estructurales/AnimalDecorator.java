package com.granja.patrones.estructurales;

import com.granja.modelos.Animal;

/**
 * Decorator - Clase abstracta que define decoradores para animales.
 */
public abstract class AnimalDecorator extends Animal {
    protected Animal animalDecorado;

    public AnimalDecorator(Animal animal) {
        super(animal.getId(), animal.getNombre(), animal.getPeso(),
              animal.getEdad(), animal.getTipoProduccion());
        this.animalDecorado = animal;
    }

    @Override
    public void comer() {
        animalDecorado.comer();
    }

    @Override
    public void dormir() {
        animalDecorado.dormir();
    }

    @Override
    public void producir() {
        animalDecorado.producir();
    }
}
