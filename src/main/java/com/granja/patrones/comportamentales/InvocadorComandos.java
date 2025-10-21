package com.granja.patrones.comportamentales;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Invoker - Ejecuta y gestiona comandos.
 */
public class InvocadorComandos {
    private List<Comando> comandos;
    private Stack<Comando> historial;

    public InvocadorComandos() {
        this.comandos = new ArrayList<>();
        this.historial = new Stack<>();
        System.out.println("✓ Invocador de comandos inicializado");
    }

    public void agregarComando(Comando cmd) {
        comandos.add(cmd);
        System.out.println("✓ Comando agregado: " + cmd.obtenerDescripcion());
    }

    public void ejecutarComandos() {
        System.out.println("\n=== EJECUTANDO COMANDOS ===");
        for (Comando cmd : comandos) {
            cmd.ejecutar();
            historial.push(cmd);
        }
        System.out.println("=========================\n");
        comandos.clear();
    }

    public void ejecutarComando(Comando cmd) {
        System.out.println("✓ Ejecutando comando: " + cmd.obtenerDescripcion());
        cmd.ejecutar();
        historial.push(cmd);
    }

    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            Comando cmd = historial.pop();
            System.out.println("\n↶ Deshaciendo: " + cmd.obtenerDescripcion());
            cmd.deshacer();
        } else {
            System.out.println("✗ No hay comandos para deshacer");
        }
    }

    public void programarComando(Comando cmd, long tiempoMs) {
        new Thread(() -> {
            try {
                System.out.println("⏰ Comando programado para " + tiempoMs + "ms: " +
                                 cmd.obtenerDescripcion());
                Thread.sleep(tiempoMs);
                ejecutarComando(cmd);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public int getTotalComandosEnHistorial() {
        return historial.size();
    }

    public void mostrarHistorial() {
        System.out.println("\n═══ HISTORIAL DE COMANDOS ═══");
        int index = 1;
        for (int i = historial.size() - 1; i >= 0; i--) {
            System.out.println(index + ". " + historial.get(i).obtenerDescripcion());
            index++;
        }
        System.out.println("═════════════════════════════\n");
    }
}
