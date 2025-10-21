package com.granja.patrones.comportamentales;

/**
 * Command - Interfaz que define un comando ejecutable.
 */
public interface Comando {
    void ejecutar();
    void deshacer();
    String obtenerDescripcion();
}
