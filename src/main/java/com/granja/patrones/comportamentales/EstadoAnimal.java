package com.granja.patrones.comportamentales;

/**
 * State - Interfaz que define los diferentes estados de un animal.
 */
public interface EstadoAnimal {
    void comer(AnimalConEstado contexto);
    void dormir(AnimalConEstado contexto);
    void mover(AnimalConEstado contexto);
    String obtenerDescripcion();
}
