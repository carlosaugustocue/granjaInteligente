package com.granja.patrones.estructurales;

import com.granja.modelos.Animal;

/**
 * Decorator concreto - Agrega un GPS a un animal para rastrearlo.
 */
public class AnimalConGPS extends AnimalDecorator {
    private double latitud;
    private double longitud;
    private String dispositivoGPS;

    public AnimalConGPS(Animal animal) {
        super(animal);
        this.dispositivoGPS = "GPS-" + animal.getId();
        this.latitud = 0.0;
        this.longitud = 0.0;
    }

    public String obtenerUbicacion() {
        return "Ubicación de " + nombre + ": Lat " + latitud + "°, Lon " + longitud + "°";
    }

    public void actualizarUbicacion(double lat, double lon) {
        this.latitud = lat;
        this.longitud = lon;
        System.out.println("📍 GPS de " + nombre + " actualizado: " + obtenerUbicacion());
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDispositivoGPS() {
        return dispositivoGPS;
    }

    @Override
    public String obtenerInfo() {
        return animalDecorado.obtenerInfo() +
               "\n  Dispositivo GPS: " + dispositivoGPS +
               "\n  " + obtenerUbicacion();
    }

    @Override
    public String toString() {
        return "Animal con GPS: " + animalDecorado.toString() +
               ", Dispositivo: " + dispositivoGPS;
    }
}
