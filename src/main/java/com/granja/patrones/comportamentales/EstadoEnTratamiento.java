package com.granja.patrones.comportamentales;

/**
 * Estado concreto - Animal en tratamiento.
 */
public class EstadoEnTratamiento implements EstadoAnimal {
    private int diasTratamiento;

    public EstadoEnTratamiento() {
        this.diasTratamiento = 0;
    }

    public EstadoEnTratamiento(int dias) {
        this.diasTratamiento = dias;
    }

    @Override
    public void comer(AnimalConEstado contexto) {
        System.out.println("📋 Animal en tratamiento " + contexto.getAnimal().getNombre() +
                         " come bajo supervisión");
    }

    @Override
    public void dormir(AnimalConEstado contexto) {
        System.out.println("📋 Animal en tratamiento " + contexto.getAnimal().getNombre() +
                         " duerme en área de recuperación");
    }

    @Override
    public void mover(AnimalConEstado contexto) {
        System.out.println("📋 Animal en tratamiento " + contexto.getAnimal().getNombre() +
                         " se mueve lentamente bajo supervisión");
    }

    @Override
    public String obtenerDescripcion() {
        return "EN_TRATAMIENTO (Día " + diasTratamiento + ")";
    }

    public int getDiasTratamiento() {
        return diasTratamiento;
    }

    public void incrementarDias() {
        diasTratamiento++;
    }
}
