package com.granja.patrones.comportamentales;

import com.granja.modelos.Animal;

/**
 * Estrategia concreta - Alimentación de verano con menor cantidad.
 */
public class EstrategiaVerano implements EstrategiaAlimentacion {
    private double factorReduccion = 0.9;

    @Override
    public double calcularCantidad(Animal animal) {
        double cantidadBase = animal.getPeso() * 0.03; // 3% del peso
        return cantidadBase * factorReduccion;
    }

    @Override
    public int determinarFrecuencia() {
        return 2; // 2 veces al día
    }

    @Override
    public String obtenerTipoAlimento() {
        return "Alimento ligero de verano";
    }

    @Override
    public String obtenerNombre() {
        return "Verano";
    }
}
