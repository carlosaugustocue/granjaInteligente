package com.granja.patrones.estructurales;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Subsistema - Sistema de alertas.
 */
public class SistemaAlertas {
    private List<String> eventos;
    private List<String> alertas;

    public SistemaAlertas() {
        this.eventos = new ArrayList<>();
        this.alertas = new ArrayList<>();
        System.out.println("✓ Sistema de Alertas iniciado");
    }

    public void enviarAlerta(String mensaje, String nivel) {
        String alerta = "[" + nivel.toUpperCase() + "] " + mensaje;
        alertas.add(alerta);
        System.out.println("⚠️ ALERTA: " + alerta);
    }

    public void registrarEvento(String evento) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String eventoRegistrado = "[" + timestamp + "] " + evento;
        eventos.add(eventoRegistrado);
        System.out.println("📝 Evento registrado: " + eventoRegistrado);
    }

    public List<String> obtenerEventos() {
        return new ArrayList<>(eventos);
    }

    public List<String> obtenerAlertas() {
        return new ArrayList<>(alertas);
    }

    public int getTotalEventos() {
        return eventos.size();
    }

    public int getTotalAlertas() {
        return alertas.size();
    }
}
