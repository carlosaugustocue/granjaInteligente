package com.granja.patrones.comportamentales;

import com.granja.patrones.creacionales.Dispensador;

/**
 * Comando concreto - Dispensar alimento.
 */
public class DispensarAlimentoCommand implements Comando {
    private Dispensador dispensador;
    private double cantidad;
    private double nivelAnterior;

    public DispensarAlimentoCommand(Dispensador dispensador, double cantidad) {
        this.dispensador = dispensador;
        this.cantidad = cantidad;
        this.nivelAnterior = dispensador.getNivelActual();
    }

    @Override
    public void ejecutar() {
        System.out.println("▶️ Ejecutando: Dispensar " + String.format("%.2f", cantidad) +
                         " kg en dispensador " + dispensador.getId());
        dispensador.dispensar(cantidad);
    }

    @Override
    public void deshacer() {
        System.out.println("↶ Deshaciendo: Reestableciendo nivel a " +
                         String.format("%.2f", nivelAnterior) + " kg");
        dispensador.setNivelActual(nivelAnterior);
    }

    @Override
    public String obtenerDescripcion() {
        return "Dispensar " + String.format("%.2f", cantidad) + " kg en " + dispensador.getId();
    }
}
