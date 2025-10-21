package com.granja.patrones.comportamentales;

/**
 * Estado concreto - Animal enfermo.
 */
public class EstadoEnfermo implements EstadoAnimal {
    @Override
    public void comer(AnimalConEstado contexto) {
        System.out.println("⚠️ Animal enfermo " + contexto.getAnimal().getNombre() +
                         " no puede comer normalmente");
    }

    @Override
    public void dormir(AnimalConEstado contexto) {
        System.out.println("⚠️ Animal enfermo " + contexto.getAnimal().getNombre() +
                         " duerme inquietamente");
    }

    @Override
    public void mover(AnimalConEstado contexto) {
        System.out.println("⚠️ Animal enfermo " + contexto.getAnimal().getNombre() +
                         " apenas puede moverse");
    }

    @Override
    public String obtenerDescripcion() {
        return "ENFERMO";
    }
}
