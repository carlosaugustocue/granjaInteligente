package com.granja.patrones.comportamentales;

/**
 * Observer concreto - Sistema que procesa alertas.
 */
public class SistemaAlertaObserver implements Observer {
    private String tipoAlerta;

    public SistemaAlertaObserver() {
        this.tipoAlerta = "CRÍTICA";
    }

    @Override
    public void actualizar(Object datos) {
        if (datos instanceof SensorNivelAlimento) {
            SensorNivelAlimento sensor = (SensorNivelAlimento) datos;
            procesarAlerta(sensor.getNivelActual());
        }
    }

    private void procesarAlerta(double nivel) {
        System.out.println("🚨 ALERTA [" + tipoAlerta + "]: Nivel de alimento crítico!");
        System.out.println("   Nivel actual: " + String.format("%.2f", nivel) + " kg");
        System.out.println("   Se requiere recarga inmediata");
    }

    @Override
    public String obtenerNombre() {
        return "SistemaAlertaObserver";
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }
}
