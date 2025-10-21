package com.granja.patrones.creacionales;

import com.granja.modelos.*;

/**
 * Abstract Factory - Interfaz para crear familias de objetos relacionados.
 */
public interface GranjaAbstractFactory {
    Animal crearAnimal();
    Alimento crearAlimento();
    Corral crearCorral(String id);
}

/**
 * Factory concreta para granjas lecheras.
 */
class GranjaLecheraFactory implements GranjaAbstractFactory {
    private int contadorVacas = 0;
    private int contadorCorrales = 0;

    @Override
    public Animal crearAnimal() {
        contadorVacas++;
        return new Vaca("VACA-" + contadorVacas, "Vaca Lechera " + contadorVacas, 450 + (contadorVacas * 10), 3);
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoLechero("Alimento Lechero Premium", 50, 850);
    }

    @Override
    public Corral crearCorral(String id) {
        contadorCorrales++;
        return new CorralLechero(id != null ? id : "CORRAL-LECHERO-" + contadorCorrales, 20);
    }
}

/**
 * Factory concreta para granjas porcinas.
 */
class GranjaPorcinaFactory implements GranjaAbstractFactory {
    private int contadorCerdos = 0;
    private int contadorCorrales = 0;

    @Override
    public Animal crearAnimal() {
        contadorCerdos++;
        return new Cerdo("CERDO-" + contadorCerdos, "Cerdo de Engorde " + contadorCerdos, 80 + (contadorCerdos * 5), 1);
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoPorcino("Alimento Porcino Premium", 60, 480);
    }

    @Override
    public Corral crearCorral(String id) {
        contadorCorrales++;
        return new CorralPorcino(id != null ? id : "CORRAL-PORCINO-" + contadorCorrales, 30);
    }
}

/**
 * Factory concreta para granjas avícolas.
 */
class GranjaAvícolaFactory implements GranjaAbstractFactory {
    private int contadorGallinas = 0;
    private int contadorCorrales = 0;

    @Override
    public Animal crearAnimal() {
        contadorGallinas++;
        return new Gallina("GALLINA-" + contadorGallinas, "Gallina Ponedora " + contadorGallinas, 2, 1);
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoLechero("Alimento Avícola Premium", 25, 350); // Reusamos AlimentoLechero para simplificar
    }

    @Override
    public Corral crearCorral(String id) {
        contadorCorrales++;
        return new CorralHuevos(id != null ? id : "CORRAL-HUEVOS-" + contadorCorrales, 100);
    }
}
