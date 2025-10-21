package com.granja.patrones.creacionales;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton - Única instancia que gestiona todos los dispensadores de alimento.
 */
public class AlimentadorGlobal {
    private static AlimentadorGlobal instancia;
    private Map<String, Dispensador> dispensadores;
    private String horarioProgramado;

    private AlimentadorGlobal() {
        this.dispensadores = new HashMap<>();
        this.horarioProgramado = "08:00, 12:00, 18:00";
        System.out.println("✓ AlimentadorGlobal inicializado (Singleton)");
    }

    /**
     * Obtiene la única instancia del AlimentadorGlobal.
     */
    public static synchronized AlimentadorGlobal obtenerInstancia() {
        if (instancia == null) {
            instancia = new AlimentadorGlobal();
        }
        return instancia;
    }

    public void registrarDispensador(String id, Dispensador dispensador) {
        dispensadores.put(id, dispensador);
        System.out.println("✓ Dispensador " + id + " registrado en AlimentadorGlobal");
    }

    public void alimentarCorral(String corralId, double cantidad) {
        Dispensador dispensador = dispensadores.get(corralId);
        if (dispensador != null) {
            dispensador.dispensar(cantidad);
        } else {
            System.out.println("✗ No existe dispensador para corral: " + corralId);
        }
    }

    public String obtenerEstadoGlobal() {
        StringBuilder estado = new StringBuilder();
        estado.append("\n═══ ESTADO GLOBAL DE DISPENSADORES ═══\n");
        for (Dispensador dispensador : dispensadores.values()) {
            estado.append(dispensador.toString()).append("\n");
        }
        estado.append("════════════════════════════════════\n");
        return estado.toString();
    }

    public void programarAlimentacion(String horario) {
        this.horarioProgramado = horario;
        System.out.println("📅 Alimentación programada a: " + horario);
    }

    public void verificarNiveles() {
        System.out.println("\n🔍 VERIFICACIÓN DE NIVELES DE ALIMENTO:");
        for (Dispensador dispensador : dispensadores.values()) {
            if (dispensador.getPorcentajeOcupacion() < 20) {
                System.out.println("⚠️ ALERTA: Dispensador " + dispensador.getId() +
                                 " por debajo del 20%: " +
                                 String.format("%.2f", dispensador.getPorcentajeOcupacion()) + "%");
            } else {
                System.out.println("✓ Dispensador " + dispensador.getId() + ": " +
                                 String.format("%.2f", dispensador.getPorcentajeOcupacion()) + "%");
            }
        }
    }

    public void recargaAutomatica() {
        System.out.println("\n🔄 INICIANDO RECARGA AUTOMÁTICA:");
        for (Dispensador dispensador : dispensadores.values()) {
            if (dispensador.getPorcentajeOcupacion() < 30) {
                dispensador.recargar();
            }
        }
    }

    public Map<String, Dispensador> obtenerDispensadores() {
        return new HashMap<>(dispensadores);
    }

    public Dispensador obtenerDispensador(String id) {
        return dispensadores.get(id);
    }

    public String getHorarioProgramado() {
        return horarioProgramado;
    }
}
