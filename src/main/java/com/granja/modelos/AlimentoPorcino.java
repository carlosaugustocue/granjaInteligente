package com.granja.modelos;

/**
 * Alimento especializado para cerdos, rico en proteínas.
 */
public class AlimentoPorcino extends Alimento {
    private double proteinas;

    public AlimentoPorcino(String nombre, double cantidadKg, double proteinas) {
        super(nombre, cantidadKg, "Proteínas, Carbohidratos, Minerales");
        this.proteinas = proteinas;
    }

    @Override
    public String obtenerInfo() {
        return "Alimento Porcino: " + nombre +
               ", Cantidad: " + String.format("%.2f", cantidadKg) + " kg" +
               ", Proteínas: " + String.format("%.2f", proteinas) + " g";
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }
}
