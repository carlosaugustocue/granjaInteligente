package com.granja.patrones.estructurales;

import com.granja.modelos.Animal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Subsistema - Sistema de monitoreo.
 */
public class SistemaMonitoreo {
    private List<DatosSensor> datosSensores;
    private Map<String, String> saludAnimales;

    public SistemaMonitoreo() {
        this.datosSensores = new ArrayList<>();
        this.saludAnimales = new HashMap<>();
        System.out.println("✓ Sistema de Monitoreo iniciado");
    }

    public void agregarDatosSensor(DatosSensor datos) {
        datosSensores.add(datos);
        System.out.println("📊 Datos de sensor registrados: " + datos);
    }

    public List<DatosSensor> obtenerDatosSensores() {
        return new ArrayList<>(datosSensores);
    }

    public void analizarSalud(String animalId) {
        String estado = "Saludable";
        if (Math.random() < 0.2) {
            estado = "Requiere atención";
        }
        saludAnimales.put(animalId, estado);
        System.out.println("🏥 Análisis de salud para " + animalId + ": " + estado);
    }

    public String obtenerEstadoSalud(String animalId) {
        return saludAnimales.getOrDefault(animalId, "Desconocido");
    }
}
