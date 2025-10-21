package com.granja.modelos;

/**
 * Clase que representa una vaca en la granja.
 * Especializada en producción de leche.
 */
public class Vaca extends Animal {
    private double litrosLeche;

    public Vaca(String id, String nombre, double peso, int edad) {
        super(id, nombre, peso, edad, "Producción de Leche");
        this.litrosLeche = 0;
    }

    @Override
    public void comer() {
        System.out.println("🐄 Vaca " + nombre + " está comiendo hierba");
        this.peso += 2;
    }

    @Override
    public void dormir() {
        System.out.println("🐄 Vaca " + nombre + " está durmiendo");
    }

    @Override
    public void producir() {
        ordeñar();
    }

    public double ordeñar() {
        double cantidad = peso > 400 ? 25 : 15;
        this.litrosLeche = cantidad;
        System.out.println("🥛 Vaca " + nombre + " ordeñada: " + String.format("%.2f", cantidad) + " litros");
        return cantidad;
    }

    @Override
    public String obtenerInfo() {
        return toString() + ", Litros de leche: " + String.format("%.2f", litrosLeche);
    }

    public double getLitrosLeche() {
        return litrosLeche;
    }

    public void setLitrosLeche(double litrosLeche) {
        this.litrosLeche = litrosLeche;
    }
}
