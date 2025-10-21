package com.granja.patrones.comportamentales;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Observer concreto - Registra eventos en un registro.
 */
public class RegistroEventosObserver implements Observer {
    private String archivo;
    private List<String> eventos;
    private DateTimeFormatter formatter;

    public RegistroEventosObserver() {
        this.archivo = "registro_alimentos.log";
        this.eventos = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("✓ Registro de eventos inicializado: " + archivo);
    }

    @Override
    public void actualizar(Object datos) {
        if (datos instanceof SensorNivelAlimento) {
            SensorNivelAlimento sensor = (SensorNivelAlimento) datos;
            registrarEvento("Alerta de nivel bajo en " + sensor.getCorralId() +
                          ": " + String.format("%.2f", sensor.getNivelActual()) + " kg");
        }
    }

    private void registrarEvento(String evento) {
        String timestamp = LocalDateTime.now().format(formatter);
        String eventoCompleto = "[" + timestamp + "] " + evento;
        eventos.add(eventoCompleto);
        System.out.println("📝 Evento registrado en " + archivo + ": " + evento);
    }

    @Override
    public String obtenerNombre() {
        return "RegistroEventosObserver";
    }

    public List<String> obtenerEventos() {
        return new ArrayList<>(eventos);
    }

    public void mostrarRegistro() {
        System.out.println("\n═══ REGISTRO DE EVENTOS ═══");
        for (String evento : eventos) {
            System.out.println(evento);
        }
        System.out.println("═══════════════════════════\n");
    }
}
