package com.granja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.granja.modelos.*;
import com.granja.patrones.creacionales.*;
import com.granja.patrones.estructurales.*;
import com.granja.patrones.comportamentales.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para el Sistema Granja Inteligente.
 */
public class SistemaGranjaInteligenteTest {
    private SistemaGranjaInteligente sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaGranjaInteligente();
    }

    // ==================== PATRONES CREACIONALES ====================

    @Test
    public void testSingletonAlimentadorGlobal() {
        AlimentadorGlobal instancia1 = AlimentadorGlobal.obtenerInstancia();
        AlimentadorGlobal instancia2 = AlimentadorGlobal.obtenerInstancia();
        assertSame(instancia1, instancia2, "Singleton debe retornar la misma instancia");
    }

    @Test
    public void testFactory() {
        FabricaCorralLechero fabricaLechero = new FabricaCorralLechero();
        Animal vaca = fabricaLechero.crearAnimal("Bessie");
        assertNotNull(vaca, "Factory debe crear un animal");
        assertTrue(vaca instanceof Vaca, "Factory debe crear una Vaca");
    }

    @Test
    public void testBuilder() {
        AnimalBuilder builder = new AnimalBuilder();
        Animal animal = builder.construirNuevoAnimal("vaca")
                .conNombre("Test")
                .conPeso(450)
                .conEdad(3)
                .obtener();
        assertNotNull(animal, "Builder debe construir un animal");
        assertEquals("Test", animal.getNombre(), "El nombre debe ser 'Test'");
    }

    @Test
    public void testDispensador() {
        Dispensador dispensador = new Dispensador("TEST-01", 100);
        assertEquals(100, dispensador.getNivelActual(), "Nivel inicial debe ser 100");
        dispensador.dispensar(30);
        assertEquals(70, dispensador.getNivelActual(), "Nivel debe reducirse a 70");
    }

    // ==================== PATRONES ESTRUCTURALES ====================

    @Test
    public void testDecorador() {
        Animal vaca = new Vaca("VACA-1", "Bessie", 450, 3);
        AnimalConVacuna vacaVacunada = new AnimalConVacuna(vaca);
        vacaVacunada.agregarVacuna("Brucelosis");
        assertEquals(1, vacaVacunada.getVacunas().size(),
                   "Debe tener una vacuna");
    }

    @Test
    public void testAdaptadorSensor() {
        SensorLegacy sensorLegacy = new SensorLegacy();
        AdaptadorSensor adaptador = new AdaptadorSensor(sensorLegacy);
        DatosSensor datos = adaptador.obtenerDatos();
        assertNotNull(datos, "Adaptador debe convertir datos");
        assertTrue(datos.getTemperatura() > 0, "Temperatura debe ser positiva");
    }

    @Test
    public void testCorral() {
        CorralLechero corral = new CorralLechero("CORRAL-01", 20);
        Animal vaca = new Vaca("VACA-1", "Bessie", 450, 3);
        boolean agregado = corral.agregarAnimal(vaca);
        assertTrue(agregado, "Animal debe agregarse al corral");
        assertEquals(1, corral.getOcupacion(), "Ocupación debe ser 1");
    }

    @Test
    public void testFacade() {
        GranjaFacade facade = new GranjaFacade();
        assertFalse(facade.isModoAutomatico(), "Modo automático debe estar desactivado");
        facade.activarModoAutomatico();
        assertTrue(facade.isModoAutomatico(), "Modo automático debe estar activado");
    }

    // ==================== PATRONES COMPORTAMENTALES ====================

    @Test
    public void testObserver() {
        SensorNivelAlimento sensor = new SensorNivelAlimento("CORRAL-01", 15, 20);
        SistemaAlertaObserver alerta = new SistemaAlertaObserver();
        sensor.agregarObservador(alerta);
        assertEquals(1, sensor.agregarObservador(alerta));
        // La prueba verifica que el observador se agregó correctamente
    }

    @Test
    public void testStrategy() {
        ContextoAlimentacion contexto = new ContextoAlimentacion(new EstrategiaInvierno());
        Animal vaca = new Vaca("VACA-1", "Bessie", 450, 3);
        // Solo verificamos que la estrategia se ejecute sin errores
        contexto.ejecutarAlimentacion(vaca);
        assertNotNull(contexto.obtenerResumenEstrategia());
    }

    @Test
    public void testComando() {
        Dispensador dispensador = new Dispensador("DISP-01", 100);
        Comando comando = new DispensarAlimentoCommand(dispensador, 30);
        comando.ejecutar();
        assertEquals(70, dispensador.getNivelActual(), "Nivel debe ser 70 después de dispensar");
        comando.deshacer();
        assertEquals(100, dispensador.getNivelActual(), "Nivel debe volver a 100 al deshacer");
    }

    @Test
    public void testEstado() {
        Animal vaca = new Vaca("VACA-1", "Bessie", 450, 3);
        AnimalConEstado animalConEstado = new AnimalConEstado(vaca);
        assertTrue(animalConEstado.obtenerEstadoActual().contains("SANO"),
                 "Estado inicial debe ser SANO");

        animalConEstado.cambiarEstado(new EstadoEnfermo());
        assertTrue(animalConEstado.obtenerEstadoActual().contains("ENFERMO"),
                 "Estado debe cambiar a ENFERMO");
    }

    // ==================== PRUEBAS DE INTEGRACIÓN ====================

    @Test
    public void testSistemaIntegrado() {
        assertNotNull(sistema, "Sistema debe estar inicializado");
        // No debe lanzar excepciones
        sistema.procesarCicloAlimentacion();
        sistema.monitorearGranja();
        sistema.ejecutarMantenimiento();
    }

    @Test
    public void testAnimalesYCorrales() {
        CorralLechero corral = new CorralLechero("CORRAL-01", 5);
        for (int i = 0; i < 5; i++) {
            Animal vaca = new Vaca("VACA-" + i, "Vaca" + i, 450, 3);
            assertTrue(corral.agregarAnimal(vaca), "Debe agregarse el animal " + i);
        }
        assertEquals(5, corral.getOcupacion(), "Ocupación debe ser 5");

        // Intenta agregar más allá de la capacidad
        Animal vacaExtra = new Vaca("VACA-6", "VacaExtra", 450, 3);
        assertFalse(corral.agregarAnimal(vacaExtra),
                   "No debe agregarse animal cuando corral está lleno");
    }
}
