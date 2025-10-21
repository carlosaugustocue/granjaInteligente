package com.granja;

import com.granja.modelos.*;
import com.granja.patrones.creacionales.*;
import com.granja.patrones.estructurales.*;
import com.granja.patrones.comportamentales.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Sistema principal que integra todos los patrones de diseño GoF
 * para gestionar una granja inteligente.
 */
public class SistemaGranjaInteligente {
    private GranjaFacade facade;
    private AlimentadorGlobal alimentadorGlobal;
    private InvocadorComandos invocador;
    private Map<String, FabricaAnimales> fabricas;
    private Map<String, Corral> corrales;
    private Map<String, SensorNivelAlimento> sensores;
    private DirectorGranja director;

    public SistemaGranjaInteligente() {
        inicializar();
    }

    /**
     * Inicializa todos los componentes del sistema.
     */
    public void inicializar() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA GRANJA INTELIGENTE v1.0     ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Patrones Creacionales
        this.facade = new GranjaFacade();
        this.alimentadorGlobal = AlimentadorGlobal.obtenerInstancia();
        this.invocador = new InvocadorComandos();

        // Factory Method
        this.fabricas = new HashMap<>();
        fabricas.put("lechero", new FabricaCorralLechero());
        fabricas.put("carne", new FabricaCorralCarne());
        fabricas.put("huevos", new FabricaCorralHuevos());

        // Builder
        this.director = new DirectorGranja(new AnimalBuilder());

        // Modelos
        this.corrales = new HashMap<>();
        this.sensores = new HashMap<>();

        System.out.println("✓ Sistema inicializado correctamente\n");
    }

    /**
     * Demuestra el ciclo de alimentación integrando todos los patrones.
     */
    public void procesarCicloAlimentacion() {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║      CICLO DE ALIMENTACIÓN AUTOMÁTICO     ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");

        // 1. CREACIÓN DE ANIMALES CON FACTORY METHOD
        System.out.println("1️⃣ CREACIÓN DE ANIMALES CON FACTORY METHOD:");
        Animal vaca1 = fabricas.get("lechero").procesarAnimal("Bessie");
        Animal cerdo1 = fabricas.get("carne").procesarAnimal("Peppa");
        Animal gallina1 = fabricas.get("huevos").procesarAnimal("Clucky");

        // 2. CONSTRUCCIÓN CON BUILDER Y DIRECTOR
        System.out.println("\n2️⃣ CONSTRUCCIÓN CON BUILDER Y DIRECTOR:");
        Animal vacaLechera = director.construirVacaLechera();
        System.out.println("   Creada: " + vacaLechera.obtenerInfo());

        // 3. DECORADORES
        System.out.println("\n3️⃣ APLICANDO DECORADORES:");
        Animal vacaVacunada = new AnimalConVacuna(vaca1);
        ((AnimalConVacuna) vacaVacunada).agregarVacuna("Brucelosis");
        ((AnimalConVacuna) vacaVacunada).agregarVacuna("Tuberculina");

        Animal vacaConGPS = new AnimalConGPS(vaca1);
        ((AnimalConGPS) vacaConGPS).actualizarUbicacion(4.7110, -74.0721);

        // 4. CREACIÓN DE CORRALES
        System.out.println("\n4️⃣ CREACIÓN DE CORRALES:");
        CorralLechero corralLechero = new CorralLechero("CORRAL-01", 20);
        CorralPorcino corralPorcino = new CorralPorcino("CORRAL-02", 30);
        CorralHuevos corralHuevos = new CorralHuevos("CORRAL-03", 100);

        corrales.put("CORRAL-01", corralLechero);
        corrales.put("CORRAL-02", corralPorcino);
        corrales.put("CORRAL-03", corralHuevos);

        System.out.println("   " + corralLechero.obtenerInfo());
        System.out.println("   " + corralPorcino.obtenerInfo());
        System.out.println("   " + corralHuevos.obtenerInfo());

        // 5. AGREGAR ANIMALES A CORRALES
        corralLechero.agregarAnimal(vaca1);
        corralPorcino.agregarAnimal(cerdo1);
        corralHuevos.agregarAnimal(gallina1);

        // 6. SINGLETON - REGISTRO DE DISPENSADORES
        System.out.println("\n5️⃣ SINGLETON - DISPENSADORES DE ALIMENTO:");
        Dispensador disp1 = new Dispensador("DISP-01", 100);
        Dispensador disp2 = new Dispensador("DISP-02", 150);

        alimentadorGlobal.registrarDispensador("CORRAL-01", disp1);
        alimentadorGlobal.registrarDispensador("CORRAL-02", disp2);

        System.out.println(alimentadorGlobal.obtenerEstadoGlobal());

        // 7. OBSERVER - SENSORES Y ALERTAS
        System.out.println("\n6️⃣ OBSERVER - SENSORES Y ALERTAS:");
        SensorNivelAlimento sensor1 = new SensorNivelAlimento("CORRAL-01", 15, 20);
        SistemaAlertaObserver alerta = new SistemaAlertaObserver();
        RegistroEventosObserver registro = new RegistroEventosObserver();

        sensor1.agregarObservador(alerta);
        sensor1.agregarObservador(registro);
        sensores.put("CORRAL-01", sensor1);

        sensor1.medirNivel();

        // 8. STRATEGY - DIFERENTES ESTRATEGIAS DE ALIMENTACIÓN
        System.out.println("\n7️⃣ STRATEGY - ESTRATEGIAS DE ALIMENTACIÓN:");
        ContextoAlimentacion contextoAlimentacion = new ContextoAlimentacion(
                new EstrategiaInvierno());
        contextoAlimentacion.ejecutarAlimentacion(vaca1);
        contextoAlimentacion.setEstrategia(new EstrategiaVerano());
        contextoAlimentacion.ejecutarAlimentacion(cerdo1);

        // 9. COMMAND - EJECUCIÓN DE COMANDOS
        System.out.println("\n8️⃣ COMMAND - EJECUCIÓN DE COMANDOS:");
        invocador.agregarComando(new DispensarAlimentoCommand(disp1, 30));
        invocador.agregarComando(new EncenderRiegoCommand(facade.getSistemaRiego(), "ZONA-A"));
        invocador.agregarComando(new RegistrarEventoCommand(facade.getSistemaAlertas(),
                "Ciclo de alimentación completado"));

        invocador.ejecutarComandos();

        // 10. STATE - GESTIÓN DE ESTADOS
        System.out.println("\n9️⃣ STATE - GESTIÓN DE ESTADOS DE ANIMALES:");
        AnimalConEstado vacaConEstado = new AnimalConEstado(vaca1);
        vacaConEstado.realizarAccion("comer");
        vacaConEstado.realizarAccion("dormir");

        // Cambiar a estado enfermo
        vacaConEstado.cambiarEstado(new EstadoEnfermo());
        vacaConEstado.realizarAccion("comer");

        // 11. ADAPTER - SENSOR LEGACY
        System.out.println("\n🔟 ADAPTER - ADAPTACIÓN DE SENSOR LEGACY:");
        SensorLegacy sensorAntiguo = new SensorLegacy();
        AdaptadorSensor adaptador = new AdaptadorSensor(sensorAntiguo);
        DatosSensor datosModernos = adaptador.obtenerDatos();
        System.out.println("   Datos modernizados: " + datosModernos);

        // 12. FACADE - COORDINACIÓN
        System.out.println("\n1️⃣1️⃣ FACADE - COORDINACIÓN DEL SISTEMA:");
        facade.alimentarCorral("CORRAL-01", 50);
        facade.activarRiego("ZONA-A");
        facade.activarModoAutomatico();
        System.out.println(facade.obtenerEstadoGeneral());
    }

    /**
     * Monitorea la granja.
     */
    public void monitorearGranja() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      MONITOREO DE LA GRANJA              ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        alimentadorGlobal.verificarNiveles();

        System.out.println("\n📊 ESTADO DE CORRALES:");
        for (Corral corral : corrales.values()) {
            System.out.println("   " + corral.obtenerInfo());
        }

        System.out.println("\n📡 SENSORES ACTIVOS:");
        for (SensorNivelAlimento sensor : sensores.values()) {
            System.out.println("   " + sensor.getCorralId() + ": " +
                             String.format("%.2f", sensor.getNivelActual()) + " kg");
        }
    }

    /**
     * Genera un reporte del sistema.
     */
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append(facade.generarReporteDiario());
        reporte.append("\n📊 HISTORIAL DE COMANDOS:");
        invocador.mostrarHistorial();
        return reporte.toString();
    }

    /**
     * Ejecuta tareas de mantenimiento.
     */
    public void ejecutarMantenimiento() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      MANTENIMIENTO DEL SISTEMA           ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        alimentadorGlobal.recargaAutomatica();

        System.out.println("\n🧹 Limpieza de corrales...");
        for (Corral corral : corrales.values()) {
            System.out.println("   ✓ Corral " + corral.getId() + " limpio");
        }

        System.out.println("\n✓ Mantenimiento completado");
    }

    /**
     * Main - Punto de entrada del sistema.
     */
    public static void main(String[] args) {
        SistemaGranjaInteligente sistema = new SistemaGranjaInteligente();

        // Ejecutar ciclo completo
        sistema.procesarCicloAlimentacion();
        sistema.monitorearGranja();
        System.out.println(sistema.generarReporte());
        sistema.ejecutarMantenimiento();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   FIN DE LA EJECUCIÓN DEL SISTEMA      ║");
        System.out.println("╚════════════════════════════════════════╝\n");
    }
}
