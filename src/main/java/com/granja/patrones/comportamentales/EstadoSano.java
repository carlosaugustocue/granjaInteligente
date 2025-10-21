package com.granja.patrones.comportamentales;

/**
 * Estado concreto - Animal sano.
 */
public class EstadoSano implements EstadoAnimal {
    @Override
    public void comer(AnimalConEstado contexto) {
        System.out.println("✓ Animal sano " + contexto.getAnimal().getNombre() + " está comiendo normalmente");
        contexto.getAnimal().comer();
    }

    @Override
    public void dormir(AnimalConEstado contexto) {
        System.out.println("✓ Animal sano " + contexto.getAnimal().getNombre() + " está durmiendo profundamente");
        contexto.getAnimal().dormir();
    }

    @Override
    public void mover(AnimalConEstado contexto) {
        System.out.println("✓ Animal sano " + contexto.getAnimal().getNombre() + " se mueve con energía");
    }

    @Override
    public String obtenerDescripcion() {
        return "SANO";
    }
}
