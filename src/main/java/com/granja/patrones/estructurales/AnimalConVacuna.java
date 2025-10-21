package com.granja.patrones.estructurales;

import com.granja.modelos.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Decorator concreto - Agrega vacunas a un animal.
 */
public class AnimalConVacuna extends AnimalDecorator {
    private List<String> vacunas;
    private Date fechaVacunacion;

    public AnimalConVacuna(Animal animal) {
        super(animal);
        this.vacunas = new ArrayList<>();
        this.fechaVacunacion = new Date();
    }

    public void agregarVacuna(String vacuna) {
        vacunas.add(vacuna);
        System.out.println("💉 Vacuna '" + vacuna + "' aplicada a " + nombre +
                         " el " + fechaVacunacion);
    }

    public List<String> getVacunas() {
        return new ArrayList<>(vacunas);
    }

    @Override
    public String obtenerInfo() {
        StringBuilder info = new StringBuilder();
        info.append(animalDecorado.obtenerInfo());
        if (!vacunas.isEmpty()) {
            info.append("\n  Vacunas: ").append(vacunas);
        }
        return info.toString();
    }

    @Override
    public String toString() {
        return "Animal Vacunado: " + animalDecorado.toString() +
               ", Vacunas: " + vacunas.size();
    }
}
