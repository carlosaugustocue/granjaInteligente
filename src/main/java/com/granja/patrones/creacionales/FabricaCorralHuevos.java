package com.granja.patrones.creacionales;

import com.granja.modelos.Animal;
import com.granja.modelos.Gallina;

/**
 * Fábrica concreta para crear gallinas ponedoras.
 */
public class FabricaCorralHuevos extends FabricaAnimales {
    @Override
    public Animal crearAnimal(String nombre) {
        return new Gallina("GALLINA-" + (contadorAnimales + 1), nombre, 2, 1);
    }
}
