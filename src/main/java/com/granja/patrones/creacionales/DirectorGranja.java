package com.granja.patrones.creacionales;

import com.granja.modelos.Animal;

/**
 * Director - Utiliza el builder para construir animales específicos.
 */
public class DirectorGranja {
    private AnimalBuilder builder;

    public DirectorGranja(AnimalBuilder builder) {
        this.builder = builder;
    }

    /**
     * Construye una vaca lechera completa según estándares de la granja.
     */
    public Animal construirVacaLechera() {
        return builder
                .construirNuevoAnimal("vaca")
                .conNombre("Bessie")
                .conPeso(450)
                .conEdad(3)
                .conHistorialMedico("Sin antecedentes")
                .conNivelActividad("Alta")
                .conVacunas("Brucelosis", "Tuberculina", "Rinotraqueítis")
                .obtener();
    }

    /**
     * Construye un cerdo de engorde completo según estándares de la granja.
     */
    public Animal construirCerdoEngorde() {
        return builder
                .construirNuevoAnimal("cerdo")
                .conNombre("Peppa")
                .conPeso(80)
                .conEdad(1)
                .conHistorialMedico("Vacunado contra influenza porcina")
                .conNivelActividad("Media")
                .conVacunas("Influenza Porcina", "Aujeszky")
                .obtener();
    }

    /**
     * Construye una gallina ponedora completa según estándares de la granja.
     */
    public Animal construirGallinaPonedora() {
        return builder
                .construirNuevoAnimal("gallina")
                .conNombre("Clucky")
                .conPeso(2)
                .conEdad(1)
                .conHistorialMedico("Saludable")
                .conNivelActividad("Alta")
                .conVacunas("Newcastle", "Bronquitis Infecciosa")
                .obtener();
    }

    public void setBuilder(AnimalBuilder builder) {
        this.builder = builder;
    }
}
