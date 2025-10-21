package com.granja.patrones.estructurales;

import java.util.HashMap;
import java.util.Map;

/**
 * Subsistema - Sistema de alimentación.
 */
public class SistemaAlimentacion {
    private Map<String, Double> nivelesAlimento;

    public SistemaAlimentacion() {
        this.nivelesAlimento = new HashMap<>();
        System.out.println("✓ Sistema de Alimentación iniciado");
    }

    public void distribuirAlimento(String corralId, double cantidad) {
        nivelesAlimento.put(corralId, nivelesAlimento.getOrDefault(corralId, 0.0) + cantidad);
        System.out.println("🥗 Distribuyendo " + String.format("%.2f", cantidad) +
                         " kg de alimento en corral " + corralId);
    }

    public Map<String, Double> verificarNiveles() {
        System.out.println("🔍 Verificando niveles de alimento...");
        return new HashMap<>(nivelesAlimento);
    }

    public double obtenerNivel(String corralId) {
        return nivelesAlimento.getOrDefault(corralId, 0.0);
    }
}
