package com.granja.patrones.estructurales;

/**
 * Clase heredada (Legacy) que usa una interfaz antigua.
 * Representa un sensor antiguo que no es compatible con el sistema nuevo.
 */
public class SensorLegacy {
    private String datos;
    private int estado;

    public SensorLegacy() {
        this.datos = "TEMP:25.5|HUM:65.3|TIME:1634567890";
        this.estado = 1; // 1 = OK, 0 = Error
    }

    public String readData() {
        System.out.println("📡 Leyendo datos del sensor legacy...");
        return datos;
    }

    public int getStatus() {
        return estado;
    }

    public void setData(String data) {
        this.datos = data;
    }

    public void setStatus(int status) {
        this.estado = status;
    }
}
