package com.granja.patrones.comportamentales;

import com.granja.patrones.estructurales.SistemaRiego;

/**
 * Comando concreto - Encender riego.
 */
public class EncenderRiegoCommand implements Comando {
    private SistemaRiego sistemaRiego;
    private String zona;
    private boolean estadoAnterior;

    public EncenderRiegoCommand(SistemaRiego sistemaRiego, String zona) {
        this.sistemaRiego = sistemaRiego;
        this.zona = zona;
        this.estadoAnterior = sistemaRiego.obtenerEstado(zona);
    }

    @Override
    public void ejecutar() {
        System.out.println("▶️ Ejecutando: Encender riego en zona " + zona);
        sistemaRiego.activar(zona);
    }

    @Override
    public void deshacer() {
        System.out.println("↶ Deshaciendo: Restaurando estado anterior del riego en " + zona);
        if (!estadoAnterior) {
            sistemaRiego.desactivar(zona);
        }
    }

    @Override
    public String obtenerDescripcion() {
        return "Encender riego en zona " + zona;
    }
}
