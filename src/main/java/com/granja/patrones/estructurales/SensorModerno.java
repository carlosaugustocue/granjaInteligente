package com.granja.patrones.estructurales;

/**
 * Interfaz que define la especificación moderna para sensores.
 */
public interface SensorModerno {
    DatosSensor obtenerDatos();
    void calibrar();
    String obtenerEstado();
}
