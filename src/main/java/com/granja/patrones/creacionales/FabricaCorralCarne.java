package com.granja.patrones.creacionales;

import com.granja.modelos.Animal;
import com.granja.modelos.Cerdo;

/**
 * Fábrica concreta para crear cerdos de engorde.
 */
public class FabricaCorralCarne extends FabricaAnimales {
    @Override
    public Animal crearAnimal(String nombre) {
        return new Cerdo("CERDO-" + (contadorAnimales + 1), nombre, 80, 1);
    }
}
