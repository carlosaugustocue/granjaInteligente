package com.granja.patrones.estructurales;

/**
 * Adapter - Adapta la interfaz antigua del sensor a la nueva interfaz moderna.
 */
public class AdaptadorSensor implements SensorModerno {
    private SensorLegacy sensorAntiguo;

    public AdaptadorSensor(SensorLegacy sensorAntiguo) {
        this.sensorAntiguo = sensorAntiguo;
        System.out.println("✓ Adaptador de sensor creado");
    }

    @Override
    public DatosSensor obtenerDatos() {
        String datosAntiguos = sensorAntiguo.readData();
        return convertirDatos(datosAntiguos);
    }

    @Override
    public void calibrar() {
        System.out.println("🔧 Calibrando sensor adaptado...");
        // Simular calibración
    }

    @Override
    public String obtenerEstado() {
        int estado = sensorAntiguo.getStatus();
        return estado == 1 ? "Funcionando correctamente" : "Error en sensor";
    }

    /**
     * Convierte los datos del formato antiguo al formato nuevo.
     */
    private DatosSensor convertirDatos(String datosAntiguos) {
        // Parsear datos del formato: "TEMP:25.5|HUM:65.3|TIME:1634567890"
        String[] partes = datosAntiguos.split("\\|");

        double temperatura = 0;
        double humedad = 0;
        long timestamp = 0;

        for (String parte : partes) {
            if (parte.startsWith("TEMP:")) {
                temperatura = Double.parseDouble(parte.substring(5));
            } else if (parte.startsWith("HUM:")) {
                humedad = Double.parseDouble(parte.substring(4));
            } else if (parte.startsWith("TIME:")) {
                timestamp = Long.parseLong(parte.substring(5));
            }
        }

        return new DatosSensor(temperatura, humedad, timestamp, "SensorLegacy");
    }
}
