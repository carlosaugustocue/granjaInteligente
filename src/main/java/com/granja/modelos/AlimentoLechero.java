package com.granja.modelos;

/**
 * Alimento especializado para vacas lecheras, rico en calcio.
 */
public class AlimentoLechero extends Alimento {
    private double calcio;

    public AlimentoLechero(String nombre, double cantidadKg, double calcio) {
        super(nombre, cantidadKg, "Proteínas, Calcio, Vitaminas");
        this.calcio = calcio;
    }

    @Override
    public String obtenerInfo() {
        return "Alimento Lechero: " + nombre +
               ", Cantidad: " + String.format("%.2f", cantidadKg) + " kg" +
               ", Calcio: " + String.format("%.2f", calcio) + " g";
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }
}
