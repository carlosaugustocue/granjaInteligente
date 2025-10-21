package com.granja.patrones.comportamentales;

import com.granja.modelos.Animal;

/**
 * Estrategia concreta - Alimentación de ahorro con reducción de costos.
 */
public class EstrategiaAhorro implements EstrategiaAlimentacion {
    private double porcentajeAhorro = 0.2;

    @Override
    public double calcularCantidad(Animal animal) {
        double cantidadBase = animal.getPeso() * 0.03; // 3% del peso
        return cantidadBase * (1 - porcentajeAhorro);
    }

    @Override
    public int determinarFrecuencia() {
        return 1; // 1 vez al día
    }

    @Override
    public String obtenerTipoAlimento() {
        return "Alimento económico";
    }

    @Override
    public String obtenerNombre() {
        return "Ahorro";
    }
}
