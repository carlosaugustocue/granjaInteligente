package com.granja.patrones.comportamentales;

/**
 * Subject - Interfaz que define el sujeto que es observado.
 */
public interface Subject {
    void agregarObservador(Observer obs);
    void eliminarObservador(Observer obs);
    void notificar();
}
