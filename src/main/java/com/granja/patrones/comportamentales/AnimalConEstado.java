package com.granja.patrones.comportamentales;

import com.granja.modelos.Animal;

/**
 * Context - Contexto que utiliza diferentes estados.
 */
public class AnimalConEstado {
    private EstadoAnimal estado;
    private Animal animal;

    public AnimalConEstado(Animal animal) {
        this.animal = animal;
        this.estado = new EstadoSano(); // Estado inicial
        System.out.println("✓ Animal con estado creado: " + animal.getNombre() +
                         " - Estado inicial: " + estado.obtenerDescripcion());
    }

    public void cambiarEstado(EstadoAnimal nuevoEstado) {
        System.out.println("🔄 Cambiando estado de " + animal.getNombre() +
                         " de " + estado.obtenerDescripcion() +
                         " a " + nuevoEstado.obtenerDescripcion());
        this.estado = nuevoEstado;
    }

    public void realizarAccion(String accion) {
        switch(accion.toLowerCase()) {
            case "comer":
                estado.comer(this);
                break;
            case "dormir":
                estado.dormir(this);
                break;
            case "mover":
                estado.mover(this);
                break;
            default:
                System.out.println("✗ Acción no reconocida: " + accion);
        }
    }

    public String obtenerEstadoActual() {
        return animal.getNombre() + " - Estado: " + estado.obtenerDescripcion();
    }

    public Animal getAnimal() {
        return animal;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return obtenerEstadoActual();
    }
}
