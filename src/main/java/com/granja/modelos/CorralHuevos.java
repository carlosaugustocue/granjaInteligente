package com.granja.modelos;

/**
 * Corral especializado para gallinas ponedoras.
 */
public class CorralHuevos extends Corral {
    private int huevosProducidos;

    public CorralHuevos(String id, int capacidad) {
        super(id, capacidad, "Huevos");
        this.huevosProducidos = 0;
    }

    @Override
    public String obtenerInfo() {
        return "Corral de Huevos: " + id +
               ", Capacidad: " + capacidad +
               ", Ocupación: " + animales.size() +
               ", Huevos producidos: " + huevosProducidos;
    }

    public int getHuevosProducidos() {
        return huevosProducidos;
    }

    public void procesarProduccionHuevos() {
        for (Animal animal : animales) {
            if (animal instanceof Gallina) {
                Gallina gallina = (Gallina) animal;
                gallina.ponerHuevo();
                huevosProducidos += gallina.getHuevosPorDia();
            }
        }
    }
}
