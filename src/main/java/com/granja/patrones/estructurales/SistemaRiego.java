package com.granja.patrones.estructurales;

import java.util.HashMap;
import java.util.Map;

/**
 * Subsistema - Sistema de riego.
 */
public class SistemaRiego {
    private Map<String, Boolean> riegosActivos;
    private String horarioProgramado;

    public SistemaRiego() {
        this.riegosActivos = new HashMap<>();
        this.horarioProgramado = "06:00, 18:00";
        System.out.println("✓ Sistema de Riego iniciado");
    }

    public void activar(String zona) {
        riegosActivos.put(zona, true);
        System.out.println("💧 Riego activado en zona: " + zona);
    }

    public void desactivar(String zona) {
        riegosActivos.put(zona, false);
        System.out.println("⛔ Riego desactivado en zona: " + zona);
    }

    public void programarRiego(String horario) {
        this.horarioProgramado = horario;
        System.out.println("📅 Riego programado a: " + horario);
    }

    public boolean obtenerEstado(String zona) {
        return riegosActivos.getOrDefault(zona, false);
    }

    public String getHorarioProgramado() {
        return horarioProgramado;
    }
}
