package com.granja.patrones.comportamentales;

import com.granja.modelos.Animal;

/**
 * Estrategia concreta - Alimentación de invierno con mayor cantidad.
 */
public class EstrategiaInvierno implements EstrategiaAlimentacion {
    private double factorIncremento = 1.3;

    @Override
    public double calcularCantidad(Animal animal) {
        double cantidadBase = animal.getPeso() * 0.03; // 3% del peso
        return cantidadBase * factorIncremento;
    }

    @Override
    public int determinarFrecuencia() {
        return 3; // 3 veces al día
    }

    @Override
    public String obtenerTipoAlimento() {
        return "Alimento enriquecido de invierno";
    }

    @Override
    public String obtenerNombre() {
        return "Invierno";
    }
}
