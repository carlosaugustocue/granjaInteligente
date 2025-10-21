package com.granja.modelos;

/**
 * Clase que representa una gallina en la granja.
 * Especializada en producción de huevos.
 */
public class Gallina extends Animal {
    private int huevosPorDia;
    private int huevosProducidos;

    public Gallina(String id, String nombre, double peso, int edad) {
        super(id, nombre, peso, edad, "Producción de Huevos");
        this.huevosPorDia = 1;
        this.huevosProducidos = 0;
    }

    @Override
    public void comer() {
        System.out.println("🐔 Gallina " + nombre + " está comiendo granos");
        this.peso += 0.1;
    }

    @Override
    public void dormir() {
        System.out.println("🐔 Gallina " + nombre + " está durmiendo en el gallinero");
    }

    @Override
    public void producir() {
        ponerHuevo();
    }

    public void ponerHuevo() {
        for (int i = 0; i < huevosPorDia; i++) {
            huevosProducidos++;
            System.out.println("🥚 Gallina " + nombre + " ha puesto un huevo. Total: " + huevosProducidos);
        }
    }

    @Override
    public String obtenerInfo() {
        return toString() + ", Huevos por día: " + huevosPorDia +
               ", Total producido: " + huevosProducidos;
    }

    public int getHuevosPorDia() {
        return huevosPorDia;
    }

    public void setHuevosPorDia(int huevosPorDia) {
        this.huevosPorDia = huevosPorDia;
    }

    public int getHuevosProducidos() {
        return huevosProducidos;
    }

    public void setHuevosProducidos(int huevosProducidos) {
        this.huevosProducidos = huevosProducidos;
    }
}
