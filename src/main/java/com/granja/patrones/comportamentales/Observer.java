package com.granja.patrones.comportamentales;

/**
 * Observer - Interfaz que define los observadores.
 */
public interface Observer {
    void actualizar(Object datos);
    String obtenerNombre();
}
