package com.granja.patrones.creacionales;

import com.granja.modelos.Animal;
import com.granja.modelos.Vaca;
import com.granja.modelos.Cerdo;
import com.granja.modelos.Gallina;

/**
 * Factory Method - Clase abstracta que define la interfaz para crear animales.
 */
public abstract class FabricaAnimales {
    protected int contadorAnimales = 0;

    /**
     * Método abstracto que debe ser implementado por las subclases
     * para crear el tipo específico de animal.
     */
    public abstract Animal crearAnimal(String nombre);

    /**
     * Método template que procesa el animal después de su creación.
     */
    public Animal procesarAnimal(String nombre) {
        Animal animal = crearAnimal(nombre);
        System.out.println("✓ Procesando nuevo animal: " + animal.obtenerInfo());
        contadorAnimales++;
        return animal;
    }

    public int getContadorAnimales() {
        return contadorAnimales;
    }
}
