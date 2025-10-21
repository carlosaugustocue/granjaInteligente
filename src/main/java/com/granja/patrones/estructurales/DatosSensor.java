package com.granja.patrones.estructurales;

/**
 * Clase que representa los datos normalizados de un sensor.
 */
public class DatosSensor {
    private double temperatura;
    private double humedad;
    private long timestamp;
    private String tipoSensor;

    public DatosSensor(double temperatura, double humedad, long timestamp, String tipoSensor) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.timestamp = timestamp;
        this.tipoSensor = tipoSensor;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    @Override
    public String toString() {
        return "DatosSensor{" +
                "temperatura=" + String.format("%.2f", temperatura) + "°C" +
                ", humedad=" + String.format("%.2f", humedad) + "%" +
                ", timestamp=" + timestamp +
                ", tipoSensor='" + tipoSensor + '\'' +
                '}';
    }
}
