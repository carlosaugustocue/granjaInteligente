package com.granja.patrones.comportamentales;

import com.granja.modelos.Animal;

/**
 * Context - Usa la estrategia de alimentación.
 */
public class ContextoAlimentacion {
    private EstrategiaAlimentacion estrategia;

    public ContextoAlimentacion(EstrategiaAlimentacion estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaAlimentacion estrategia) {
        this.estrategia = estrategia;
        System.out.println("🔄 Estrategia de alimentación cambiada a: " + estrategia.obtenerNombre());
    }

    public void ejecutarAlimentacion(Animal animal) {
        if (estrategia == null) {
            System.out.println("✗ No hay estrategia definida");
            return;
        }

        double cantidad = estrategia.calcularCantidad(animal);
        int frecuencia = estrategia.determinarFrecuencia();
        String tipo = estrategia.obtenerTipoAlimento();

        System.out.println("\n🍽️ Alimentando a " + animal.getNombre() + ":");
        System.out.println("  - Estrategia: " + estrategia.obtenerNombre());
        System.out.println("  - Tipo: " + tipo);
        System.out.println("  - Cantidad: " + String.format("%.2f", cantidad) + " kg");
        System.out.println("  - Frecuencia: " + frecuencia + " veces/día");
    }

    public String obtenerResumenEstrategia() {
        if (estrategia == null) {
            return "Sin estrategia definida";
        }
        return "Estrategia actual: " + estrategia.obtenerNombre() +
               " - Tipo de alimento: " + estrategia.obtenerTipoAlimento();
    }
}
