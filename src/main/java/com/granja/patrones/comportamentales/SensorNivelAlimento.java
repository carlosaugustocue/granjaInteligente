package com.granja.patrones.comportamentales;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern - Subject que mide el nivel de alimento y notifica a los observadores.
 */
public class SensorNivelAlimento implements Subject {
    private List<Observer> observadores;
    private double nivelActual;
    private double nivelMinimo;
    private String corralId;

    public SensorNivelAlimento(String corralId, double nivelActual, double nivelMinimo) {
        this.observadores = new ArrayList<>();
        this.corralId = corralId;
        this.nivelActual = nivelActual;
        this.nivelMinimo = nivelMinimo;
        System.out.println("✓ Sensor de nivel de alimento creado para " + corralId);
    }

    public void medirNivel() {
        System.out.println("📊 Midiendo nivel en " + corralId + ": " + String.format("%.2f", nivelActual) + " kg");
        if (nivelActual < nivelMinimo) {
            notificar();
        }
    }

    public void consumir(double cantidad) {
        nivelActual -= cantidad;
        System.out.println("🍽️ Se consumieron " + String.format("%.2f", cantidad) + " kg en " + corralId);
        if (nivelActual < nivelMinimo) {
            notificar();
        }
    }

    public void recargar(double cantidad) {
        nivelActual += cantidad;
        System.out.println("🔄 Se recargaron " + String.format("%.2f", cantidad) + " kg en " + corralId);
    }

    @Override
    public void agregarObservador(Observer obs) {
        observadores.add(obs);
        System.out.println("✓ Observador '" + obs.obtenerNombre() + "' agregado al sensor de " + corralId);
    }

    @Override
    public void eliminarObservador(Observer obs) {
        observadores.remove(obs);
        System.out.println("✓ Observador '" + obs.obtenerNombre() + "' eliminado del sensor de " + corralId);
    }

    @Override
    public void notificar() {
        System.out.println("\n🔔 Notificando a observadores...");
        for (Observer observador : observadores) {
            observador.actualizar(this);
        }
    }

    public double getNivelActual() {
        return nivelActual;
    }

    public double getNivelMinimo() {
        return nivelMinimo;
    }

    public String getCorralId() {
        return corralId;
    }

    public void setNivelMinimo(double nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }
}
