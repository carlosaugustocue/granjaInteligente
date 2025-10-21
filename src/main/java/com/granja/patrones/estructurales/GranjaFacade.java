package com.granja.patrones.estructurales;

/**
 * Facade - Simplifica la interacción con múltiples subsistemas complejos.
 */
public class GranjaFacade {
    private SistemaAlimentacion sistemaAlimentacion;
    private SistemaRiego sistemaRiego;
    private SistemaMonitoreo sistemaMonitoreo;
    private SistemaAlertas sistemaAlertas;
    private boolean modoAutomatico;

    public GranjaFacade() {
        this.sistemaAlimentacion = new SistemaAlimentacion();
        this.sistemaRiego = new SistemaRiego();
        this.sistemaMonitoreo = new SistemaMonitoreo();
        this.sistemaAlertas = new SistemaAlertas();
        this.modoAutomatico = false;
        System.out.println("\n✓ Fachada de Granja Inteligente inicializada\n");
    }

    public void alimentarCorral(String corralId, double cantidad) {
        System.out.println("\n=== Iniciando proceso de alimentación ===");
        System.out.println("Verificando estado del corral " + corralId);
        sistemaAlimentacion.distribuirAlimento(corralId, cantidad);
        sistemaAlertas.registrarEvento("Alimentación completada en corral " + corralId);
    }

    public void activarRiego(String zonaId) {
        System.out.println("\n=== Activando sistema de riego ===");
        sistemaRiego.activar(zonaId);
        sistemaAlertas.registrarEvento("Riego iniciado en zona " + zonaId);
    }

    public String obtenerEstadoGeneral() {
        StringBuilder estado = new StringBuilder();
        estado.append("\n╔════════════ ESTADO GENERAL DE LA GRANJA ════════════╗\n");
        estado.append("│ Modo Automático: ").append(modoAutomatico ? "ACTIVO" : "INACTIVO").append("\n");
        estado.append("│ Eventos registrados: ").append(sistemaAlertas.getTotalEventos()).append("\n");
        estado.append("│ Alertas emitidas: ").append(sistemaAlertas.getTotalAlertas()).append("\n");
        estado.append("│ Sensores activos: ").append(sistemaMonitoreo.obtenerDatosSensores().size()).append("\n");
        estado.append("╚═════════════════════════════════════════════════════╝\n");
        return estado.toString();
    }

    public String generarReporteDiario() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("\n╔════════════ REPORTE DIARIO ════════════╗\n");
        reporte.append("Niveles de alimento: ").append(sistemaAlimentacion.verificarNiveles()).append("\n");
        reporte.append("Horario de riego: ").append(sistemaRiego.getHorarioProgramado()).append("\n");
        reporte.append("Total de eventos: ").append(sistemaAlertas.getTotalEventos()).append("\n");
        reporte.append("╚════════════════════════════════════════╝\n");
        return reporte.toString();
    }

    public void activarModoAutomatico() {
        this.modoAutomatico = true;
        System.out.println("\n🤖 Modo automático activado");
        sistemaAlertas.registrarEvento("Modo automático activado");
    }

    public void desactivarModoAutomatico() {
        this.modoAutomatico = false;
        System.out.println("\n⛔ Modo automático desactivado");
        sistemaAlertas.registrarEvento("Modo automático desactivado");
    }

    public void procesarEmergencia(String tipo) {
        System.out.println("\n🚨 PROCESANDO EMERGENCIA: " + tipo);
        sistemaAlertas.enviarAlerta("Emergencia detectada: " + tipo, "CRITICO");
        sistemaAlertas.registrarEvento("Emergencia: " + tipo);
        // Aquí podrían tomarse acciones automáticas
    }

    // Getters para acceso a subsistemas si es necesario
    public SistemaAlimentacion getSistemaAlimentacion() {
        return sistemaAlimentacion;
    }

    public SistemaRiego getSistemaRiego() {
        return sistemaRiego;
    }

    public SistemaMonitoreo getSistemaMonitoreo() {
        return sistemaMonitoreo;
    }

    public SistemaAlertas getSistemaAlertas() {
        return sistemaAlertas;
    }

    public boolean isModoAutomatico() {
        return modoAutomatico;
    }
}
