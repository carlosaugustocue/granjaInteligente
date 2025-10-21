package com.granja.patrones.comportamentales;

import com.granja.modelos.Animal;

/**
 * Strategy - Interfaz que define diferentes estrategias de alimentación.
 */
public interface EstrategiaAlimentacion {
    double calcularCantidad(Animal animal);
    int determinarFrecuencia();
    String obtenerTipoAlimento();
    String obtenerNombre();
}
