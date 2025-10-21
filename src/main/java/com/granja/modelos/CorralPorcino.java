package com.granja.modelos;

/**
 * Corral especializado para cerdos.
 */
public class CorralPorcino extends Corral {
    private String sistemaPesaje;
    private double pesoTotalAnimales;

    public CorralPorcino(String id, int capacidad) {
        super(id, capacidad, "Porcino");
        this.sistemaPesaje = "Digital";
        this.pesoTotalAnimales = 0;
    }

    @Override
    public String obtenerInfo() {
        return "Corral Porcino: " + id +
               ", Capacidad: " + capacidad +
               ", Ocupación: " + animales.size() +
               ", Sistema de Pesaje: " + sistemaPesaje +
               ", Peso total: " + String.format("%.2f", pesoTotalAnimales) + " kg";
    }

    public String getSistemaPesaje() {
        return sistemaPesaje;
    }

    public void setSistemaPesaje(String sistemaPesaje) {
        this.sistemaPesaje = sistemaPesaje;
    }

    public double getPesoTotalAnimales() {
        return pesoTotalAnimales;
    }

    public void calcularPesoTotal() {
        pesoTotalAnimales = 0;
        for (Animal animal : animales) {
            pesoTotalAnimales += animal.getPeso();
        }
    }

    public void procesarEngorde() {
        calcularPesoTotal();
        for (Animal animal : animales) {
            if (animal instanceof Cerdo) {
                Cerdo cerdo = (Cerdo) animal;
                cerdo.engordar();
            }
        }
    }
}
