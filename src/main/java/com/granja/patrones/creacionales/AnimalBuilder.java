package com.granja.patrones.creacionales;

import com.granja.modelos.Animal;
import com.granja.modelos.Vaca;
import com.granja.modelos.Cerdo;
import com.granja.modelos.Gallina;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder - Construye animales complejos paso a paso.
 */
public class AnimalBuilder {
    private String id;
    private String nombre;
    private double peso;
    private int edad;
    private String tipo;
    private String historialMedico;
    private String nivelActividad;
    private List<String> vacunas;

    public AnimalBuilder construirNuevoAnimal(String tipo) {
        this.tipo = tipo;
        this.vacunas = new ArrayList<>();
        this.id = tipo.toUpperCase() + "-" + System.currentTimeMillis();
        return this;
    }

    public AnimalBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public AnimalBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AnimalBuilder conPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public AnimalBuilder conEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public AnimalBuilder conHistorialMedico(String historial) {
        this.historialMedico = historial;
        return this;
    }

    public AnimalBuilder conNivelActividad(String nivel) {
        this.nivelActividad = nivel;
        return this;
    }

    public AnimalBuilder conVacunas(String... vacunasArray) {
        this.vacunas = new ArrayList<>();
        for (String vacuna : vacunasArray) {
            this.vacunas.add(vacuna);
        }
        return this;
    }

    public Animal obtener() {
        Animal animal = null;

        switch (tipo.toLowerCase()) {
            case "vaca":
                animal = new Vaca(id, nombre, peso, edad);
                break;
            case "cerdo":
                animal = new Cerdo(id, nombre, peso, edad);
                break;
            case "gallina":
                animal = new Gallina(id, nombre, peso, edad);
                break;
            default:
                throw new IllegalArgumentException("Tipo de animal no válido: " + tipo);
        }

        return animal;
    }

    @Override
    public String toString() {
        return "AnimalBuilder{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", edad=" + edad +
                ", tipo='" + tipo + '\'' +
                ", historialMedico='" + historialMedico + '\'' +
                ", nivelActividad='" + nivelActividad + '\'' +
                ", vacunas=" + vacunas +
                '}';
    }
}
