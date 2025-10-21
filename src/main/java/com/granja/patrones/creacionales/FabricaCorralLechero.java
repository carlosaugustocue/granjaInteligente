package com.granja.patrones.creacionales;

import com.granja.modelos.Animal;
import com.granja.modelos.Vaca;

/**
 * Fábrica concreta para crear vacas lecheras.
 */
public class FabricaCorralLechero extends FabricaAnimales {
    @Override
    public Animal crearAnimal(String nombre) {
        return new Vaca("VACA-" + (contadorAnimales + 1), nombre, 450, 3);
    }
}
