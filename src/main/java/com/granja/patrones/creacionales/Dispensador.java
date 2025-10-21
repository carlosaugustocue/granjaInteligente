package com.granja.patrones.creacionales;

/**
 * Clase que representa un dispensador de alimento.
 */
public class Dispensador {
    private String id;
    private double capacidad;
    private double nivelActual;
    private boolean activo;

    public Dispensador(String id, double capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.nivelActual = capacidad;
        this.activo = true;
    }

    public void dispensar(double cantidad) {
        if (nivelActual >= cantidad && activo) {
            nivelActual -= cantidad;
            System.out.println("📦 Dispensador " + id + ": Dispensado " +
                               String.format("%.2f", cantidad) + " kg. Nivel actual: " +
                               String.format("%.2f", nivelActual) + " kg");
        } else if (!activo) {
            System.out.println("✗ Dispensador " + id + " está inactivo");
        } else {
            System.out.println("⚠️ Nivel insuficiente en dispensador " + id);
        }
    }

    public void recargar() {
        System.out.println("🔄 Recargando dispensador " + id);
        nivelActual = capacidad;
        System.out.println("✓ Dispensador " + id + " recargado a " + capacidad + " kg");
    }

    public String getId() {
        return id;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public double getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(double nivelActual) {
        this.nivelActual = Math.min(nivelActual, capacidad);
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPorcentajeOcupacion() {
        return (nivelActual / capacidad) * 100;
    }

    @Override
    public String toString() {
        return "Dispensador{" +
                "id='" + id + '\'' +
                ", capacidad=" + capacidad +
                ", nivelActual=" + nivelActual +
                ", ocupacion=" + String.format("%.2f", getPorcentajeOcupacion()) + "%" +
                ", activo=" + activo +
                '}';
    }
}
