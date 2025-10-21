package com.granja.patrones.comportamentales;

import com.granja.patrones.estructurales.SistemaAlertas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Comando concreto - Registrar evento.
 */
public class RegistrarEventoCommand implements Comando {
    private SistemaAlertas sistema;
    private String evento;
    private long timestamp;

    public RegistrarEventoCommand(SistemaAlertas sistema, String evento) {
        this.sistema = sistema;
        this.evento = evento;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public void ejecutar() {
        System.out.println("▶️ Ejecutando: Registrar evento - " + evento);
        sistema.registrarEvento(evento);
    }

    @Override
    public void deshacer() {
        System.out.println("↶ Deshaciendo: No se puede deshacer registro de evento permanente");
        // Los eventos de registro generalmente no se pueden deshacer
    }

    @Override
    public String obtenerDescripcion() {
        return "Registrar evento: " + evento;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
