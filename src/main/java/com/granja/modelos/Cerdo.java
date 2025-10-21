package com.granja.modelos;

/**
 * Clase que representa un cerdo en la granja.
 * Especializado en producción de carne.
 */
public class Cerdo extends Animal {
    private double pesoOptimo;
    private double pesoActual;

    public Cerdo(String id, String nombre, double peso, int edad) {
        super(id, nombre, peso, edad, "Producción de Carne");
        this.pesoActual = peso;
        this.pesoOptimo = 150;
    }

    @Override
    public void comer() {
        System.out.println("🐷 Cerdo " + nombre + " está comiendo concentrado");
        this.peso += 3;
        this.pesoActual += 3;
    }

    @Override
    public void dormir() {
        System.out.println("🐷 Cerdo " + nombre + " está durmiendo en el lodo");
    }

    @Override
    public void producir() {
        engordar();
    }

    public void engordar() {
        if (pesoActual < pesoOptimo) {
            double aumento = pesoOptimo - pesoActual;
            System.out.println("📈 Cerdo " + nombre + " en proceso de engorde. Falta: " +
                               String.format("%.2f", aumento) + " kg");
        } else {
            System.out.println("✓ Cerdo " + nombre + " ha alcanzado peso óptimo: " +
                               String.format("%.2f", pesoActual) + " kg");
        }
    }

    @Override
    public String obtenerInfo() {
        return toString() + ", Peso actual: " + String.format("%.2f", pesoActual) +
               " kg, Peso óptimo: " + String.format("%.2f", pesoOptimo) + " kg";
    }

    public double getPesoOptimo() {
        return pesoOptimo;
    }

    public void setPesoOptimo(double pesoOptimo) {
        this.pesoOptimo = pesoOptimo;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }
}
