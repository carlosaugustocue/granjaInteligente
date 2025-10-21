package com.granja.modelos;

/**
 * Corral especializado para vacas lecheras.
 */
public class CorralLechero extends Corral {
    private String sistemaOrdeño;
    private double litrosProducidos;

    public CorralLechero(String id, int capacidad) {
        super(id, capacidad, "Lechero");
        this.sistemaOrdeño = "Automático";
        this.litrosProducidos = 0;
    }

    @Override
    public String obtenerInfo() {
        return "Corral Lechero: " + id +
               ", Capacidad: " + capacidad +
               ", Ocupación: " + animales.size() +
               ", Sistema de Ordeño: " + sistemaOrdeño +
               ", Litros producidos: " + String.format("%.2f", litrosProducidos);
    }

    public String getSistemaOrdeño() {
        return sistemaOrdeño;
    }

    public void setSistemaOrdeño(String sistemaOrdeño) {
        this.sistemaOrdeño = sistemaOrdeño;
    }

    public double getLitrosProducidos() {
        return litrosProducidos;
    }

    public void setLitrosProducidos(double litrosProducidos) {
        this.litrosProducidos = litrosProducidos;
    }

    public void procesarOrdeño() {
        for (Animal animal : animales) {
            if (animal instanceof Vaca) {
                Vaca vaca = (Vaca) animal;
                litrosProducidos += vaca.ordeñar();
            }
        }
    }
}
