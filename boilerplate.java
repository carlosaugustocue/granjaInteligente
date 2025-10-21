// ============================================
// PATRONES CREACIONALES
// ============================================

import java.util.*;
import java.time.LocalDateTime;

// === MODELO BASE ===
abstract class Animal {
    protected String id;
    protected double peso;
    protected int edad;
    protected String nombre;
    protected String tipoProduccion;
    
    public Animal(String id, double peso, int edad, String nombre) {
        this.id = id;
        this.peso = peso;
        this.edad = edad;
        this.nombre = nombre;
    }
    
    public abstract void comer();
    public abstract void dormir();
    public abstract void producir();
    
    public String obtenerInfo() {
        return String.format("Animal: %s, ID: %s, Peso: %.2f kg, Edad: %d años", 
                           nombre, id, peso, edad);
    }
    
    // Getters y setters
    public double getPeso() { return peso; }
    public String getNombre() { return nombre; }
}

class Vaca extends Animal {
    private double litrosLeche;
    
    public Vaca(String id, double peso, int edad, String nombre) {
        super(id, peso, edad, nombre);
        this.tipoProduccion = "Leche";
        this.litrosLeche = 0;
    }
    
    @Override
    public void comer() {
        System.out.println("Vaca " + nombre + " está comiendo pasto y alimento balanceado");
    }
    
    @Override
    public void dormir() {
        System.out.println("Vaca " + nombre + " está descansando");
    }
    
    @Override
    public void producir() {
        litrosLeche = 20 + Math.random() * 10;
        System.out.println("Vaca " + nombre + " produjo " + litrosLeche + " litros de leche");
    }
    
    public double ordeñar() {
        double lecheOrdeñada = litrosLeche;
        litrosLeche = 0;
        return lecheOrdeñada;
    }
}

class Cerdo extends Animal {
    private double pesoOptimo;
    
    public Cerdo(String id, double peso, int edad, String nombre) {
        super(id, peso, edad, nombre);
        this.tipoProduccion = "Carne";
        this.pesoOptimo = 120.0;
    }
    
    @Override
    public void comer() {
        peso += 0.5;
        System.out.println("Cerdo " + nombre + " está comiendo. Peso actual: " + peso + " kg");
    }
    
    @Override
    public void dormir() {
        System.out.println("Cerdo " + nombre + " está durmiendo");
    }
    
    @Override
    public void producir() {
        if (peso >= pesoOptimo) {
            System.out.println("Cerdo " + nombre + " ha alcanzado el peso óptimo para producción");
        }
    }
}

class Gallina extends Animal {
    private int huevosPorDia;
    
    public Gallina(String id, double peso, int edad, String nombre) {
        super(id, peso, edad, nombre);
        this.tipoProduccion = "Huevos";
        this.huevosPorDia = 1;
    }
    
    @Override
    public void comer() {
        System.out.println("Gallina " + nombre + " está picoteando granos");
    }
    
    @Override
    public void dormir() {
        System.out.println("Gallina " + nombre + " está en el gallinero");
    }
    
    @Override
    public void producir() {
        System.out.println("Gallina " + nombre + " puso " + huevosPorDia + " huevo(s)");
    }
}

// === FACTORY METHOD ===
abstract class FabricaAnimales {
    public abstract Animal crearAnimal(String tipo);
    
    public Animal procesarAnimal(String tipo) {
        Animal animal = crearAnimal(tipo);
        System.out.println("Procesando nuevo animal: " + animal.obtenerInfo());
        return animal;
    }
}

class FabricaCorralLechero extends FabricaAnimales {
    private int contadorId = 1;
    
    @Override
    public Animal crearAnimal(String tipo) {
        return new Vaca("VACA-" + contadorId++, 450.0, 3, "Vaca-" + contadorId);
    }
}

class FabricaCorralCarne extends FabricaAnimales {
    private int contadorId = 1;
    
    @Override
    public Animal crearAnimal(String tipo) {
        return new Cerdo("CERDO-" + contadorId++, 50.0, 1, "Cerdo-" + contadorId);
    }
}

// === BUILDER ===
class AnimalBuilder {
    private Animal animal;
    private Map<String, String> atributosAdicionales = new HashMap<>();
    
    public AnimalBuilder construirNuevoAnimal(String tipo) {
        switch(tipo.toLowerCase()) {
            case "vaca":
                animal = new Vaca(UUID.randomUUID().toString(), 0, 0, "");
                break;
            case "cerdo":
                animal = new Cerdo(UUID.randomUUID().toString(), 0, 0, "");
                break;
            case "gallina":
                animal = new Gallina(UUID.randomUUID().toString(), 0, 0, "");
                break;
        }
        return this;
    }
    
    public AnimalBuilder conPeso(double peso) {
        if (animal != null) animal.peso = peso;
        return this;
    }
    
    public AnimalBuilder conEdad(int edad) {
        if (animal != null) animal.edad = edad;
        return this;
    }
    
    public AnimalBuilder conNombre(String nombre) {
        if (animal != null) animal.nombre = nombre;
        return this;
    }
    
    public AnimalBuilder conHistorialMedico(String historial) {
        atributosAdicionales.put("historialMedico", historial);
        return this;
    }
    
    public AnimalBuilder conVacunas(List<String> vacunas) {
        atributosAdicionales.put("vacunas", String.join(",", vacunas));
        return this;
    }
    
    public Animal obtener() {
        return animal;
    }
}

// === SINGLETON ===
class AlimentadorGlobal {
    private static AlimentadorGlobal instancia;
    private Map<String, Dispensador> dispensadores;
    
    private AlimentadorGlobal() {
        dispensadores = new HashMap<>();
    }
    
    public static AlimentadorGlobal obtenerInstancia() {
        if (instancia == null) {
            synchronized (AlimentadorGlobal.class) {
                if (instancia == null) {
                    instancia = new AlimentadorGlobal();
                }
            }
        }
        return instancia;
    }
    
    public void registrarDispensador(String id, Dispensador dispensador) {
        dispensadores.put(id, dispensador);
    }
    
    public void alimentarCorral(String corralId, double cantidad) {
        Dispensador dispensador = dispensadores.get(corralId);
        if (dispensador != null) {
            dispensador.dispensar(cantidad);
            System.out.println("Alimentando corral " + corralId + " con " + cantidad + " kg");
        }
    }
    
    public String obtenerEstadoGlobal() {
        StringBuilder estado = new StringBuilder("Estado Global de Alimentación:\n");
        for (Map.Entry<String, Dispensador> entry : dispensadores.entrySet()) {
            estado.append("Dispensador ").append(entry.getKey())
                  .append(": ").append(entry.getValue().obtenerEstado()).append("\n");
        }
        return estado.toString();
    }
}

class Dispensador {
    private String id;
    private double capacidad;
    private double nivelActual;
    
    public Dispensador(String id, double capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.nivelActual = capacidad;
    }
    
    public void dispensar(double cantidad) {
        if (nivelActual >= cantidad) {
            nivelActual -= cantidad;
            System.out.println("Dispensado " + cantidad + " kg. Nivel actual: " + nivelActual);
        } else {
            System.out.println("No hay suficiente alimento. Nivel actual: " + nivelActual);
        }
    }
    
    public void recargar() {
        nivelActual = capacidad;
        System.out.println("Dispensador " + id + " recargado");
    }
    
    public String obtenerEstado() {
        return String.format("%.2f/%.2f kg", nivelActual, capacidad);
    }
    
    public double getNivelActual() {
        return nivelActual;
    }
}

// ============================================
// PATRONES ESTRUCTURALES
// ============================================

// === DECORATOR ===
abstract class AnimalDecorator extends Animal {
    protected Animal animalDecorado;
    
    public AnimalDecorator(Animal animal) {
        super(animal.id, animal.peso, animal.edad, animal.nombre);
        this.animalDecorado = animal;
    }
    
    @Override
    public void comer() {
        animalDecorado.comer();
    }
    
    @Override
    public void dormir() {
        animalDecorado.dormir();
    }
    
    @Override
    public void producir() {
        animalDecorado.producir();
    }
}

class AnimalConVacuna extends AnimalDecorator {
    private List<String> vacunas;
    private Date fechaVacunacion;
    
    public AnimalConVacuna(Animal animal) {
        super(animal);
        this.vacunas = new ArrayList<>();
        this.fechaVacunacion = new Date();
    }
    
    public void agregarVacuna(String vacuna) {
        vacunas.add(vacuna);
        System.out.println("Vacuna " + vacuna + " aplicada a " + nombre);
    }
    
    @Override
    public String obtenerInfo() {
        return animalDecorado.obtenerInfo() + ", Vacunas: " + vacunas;
    }
}

class AnimalConGPS extends AnimalDecorator {
    private double latitud;
    private double longitud;
    
    public AnimalConGPS(Animal animal) {
        super(animal);
    }
    
    public void actualizarUbicacion(double lat, double lon) {
        this.latitud = lat;
        this.longitud = lon;
    }
    
    @Override
    public String obtenerInfo() {
        return animalDecorado.obtenerInfo() + 
               String.format(", GPS: (%.4f, %.4f)", latitud, longitud);
    }
}

// === FACADE ===
class GranjaFacade {
    private SistemaAlimentacion sistemaAlimentacion;
    private SistemaRiego sistemaRiego;
    private SistemaMonitoreo sistemaMonitoreo;
    private SistemaAlertas sistemaAlertas;
    
    public GranjaFacade() {
        this.sistemaAlimentacion = new SistemaAlimentacion();
        this.sistemaRiego = new SistemaRiego();
        this.sistemaMonitoreo = new SistemaMonitoreo();
        this.sistemaAlertas = new SistemaAlertas();
    }
    
    public void alimentarCorral(String corralId) {
        System.out.println("\n=== Iniciando proceso de alimentación ===");
        sistemaMonitoreo.verificarEstado(corralId);
        sistemaAlimentacion.distribuirAlimento(corralId, 50.0);
        sistemaAlertas.registrarEvento("Alimentación completada en corral " + corralId);
    }
    
    public void activarRiego(String zonaId) {
        System.out.println("\n=== Activando sistema de riego ===");
        sistemaRiego.activar(zonaId);
        sistemaAlertas.registrarEvento("Riego activado en zona " + zonaId);
    }
    
    public String obtenerEstadoGeneral() {
        return "Estado General:\n" +
               sistemaAlimentacion.obtenerEstado() + "\n" +
               sistemaRiego.obtenerEstado() + "\n" +
               sistemaMonitoreo.obtenerEstado();
    }
}

class SistemaAlimentacion {
    public void distribuirAlimento(String corralId, double cantidad) {
        System.out.println("Distribuyendo " + cantidad + " kg de alimento en corral " + corralId);
    }
    
    public String obtenerEstado() {
        return "Sistema de alimentación: Operativo";
    }
}

class SistemaRiego {
    public void activar(String zona) {
        System.out.println("Activando riego en zona " + zona);
    }
    
    public String obtenerEstado() {
        return "Sistema de riego: Activo";
    }
}

class SistemaMonitoreo {
    public void verificarEstado(String corralId) {
        System.out.println("Verificando estado del corral " + corralId);
    }
    
    public String obtenerEstado() {
        return "Sistema de monitoreo: Funcionando";
    }
}

class SistemaAlertas {
    private List<String> eventos = new ArrayList<>();
    
    public void enviarAlerta(String mensaje, String nivel) {
        System.out.println("[" + nivel + "] " + mensaje);
    }
    
    public void registrarEvento(String evento) {
        eventos.add(LocalDateTime.now() + " - " + evento);
        System.out.println("Evento registrado: " + evento);
    }
}

// ============================================
// PATRONES COMPORTAMENTALES
// ============================================

// === OBSERVER ===
interface Observer {
    void actualizar(Object datos);
}

interface Subject {
    void agregarObservador(Observer obs);
    void eliminarObservador(Observer obs);
    void notificar();
}

class SensorNivelAlimento implements Subject {
    private List<Observer> observadores = new ArrayList<>();
    private double nivelActual;
    private double nivelMinimo = 20.0;
    private String corralId;
    
    public SensorNivelAlimento(String corralId) {
        this.corralId = corralId;
        this.nivelActual = 100.0;
    }
    
    public void medirNivel() {
        // Simular medición
        nivelActual -= Math.random() * 10;
        System.out.println("Nivel de alimento en " + corralId + ": " + nivelActual + " kg");
        
        if (nivelActual < nivelMinimo) {
            notificar();
        }
    }
    
    @Override
    public void agregarObservador(Observer obs) {
        observadores.add(obs);
    }
    
    @Override
    public void eliminarObservador(Observer obs) {
        observadores.remove(obs);
    }
    
    @Override
    public void notificar() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("corralId", corralId);
        datos.put("nivel", nivelActual);
        
        for (Observer obs : observadores) {
            obs.actualizar(datos);
        }
    }
    
    public void setNivelActual(double nivel) {
        this.nivelActual = nivel;
    }
}

class SistemaAlertaObserver implements Observer {
    private String tipoAlerta;
    
    public SistemaAlertaObserver(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }
    
    @Override
    public void actualizar(Object datos) {
        Map<String, Object> info = (Map<String, Object>) datos;
        System.out.println("⚠️ ALERTA " + tipoAlerta + ": Nivel bajo en " + 
                          info.get("corralId") + " - " + info.get("nivel") + " kg");
    }
}

// === STRATEGY ===
interface EstrategiaAlimentacion {
    double calcularCantidad(Animal animal);
    int determinarFrecuencia();
    String obtenerTipoAlimento();
}

class EstrategiaInvierno implements EstrategiaAlimentacion {
    private double factorIncremento = 1.3;
    
    @Override
    public double calcularCantidad(Animal animal) {
        double cantidadBase = animal.getPeso() * 0.03;
        return cantidadBase * factorIncremento;
    }
    
    @Override
    public int determinarFrecuencia() {
        return 3; // 3 veces al día
    }
    
    @Override
    public String obtenerTipoAlimento() {
        return "Alimento enriquecido de invierno";
    }
}

class EstrategiaVerano implements EstrategiaAlimentacion {
    private double factorReduccion = 0.9;
    
    @Override
    public double calcularCantidad(Animal animal) {
        double cantidadBase = animal.getPeso() * 0.03;
        return cantidadBase * factorReduccion;
    }
    
    @Override
    public int determinarFrecuencia() {
        return 2; // 2 veces al día
    }
    
    @Override
    public String obtenerTipoAlimento() {
        return "Alimento ligero de verano";
    }
}

class ContextoAlimentacion {
    private EstrategiaAlimentacion estrategia;
    
    public void setEstrategia(EstrategiaAlimentacion estrategia) {
        this.estrategia = estrategia;
    }
    
    public void ejecutarAlimentacion(Animal animal) {
        if (estrategia != null) {
            double cantidad = estrategia.calcularCantidad(animal);
            String tipo = estrategia.obtenerTipoAlimento();
            int frecuencia = estrategia.determinarFrecuencia();
            
            System.out.println("Alimentando a " + animal.getNombre() + ":");
            System.out.println("  - Tipo: " + tipo);
            System.out.println("  - Cantidad: " + String.format("%.2f kg", cantidad));
            System.out.println("  - Frecuencia: " + frecuencia + " veces/día");
        }
    }
}

// === COMMAND ===
interface Comando {
    void ejecutar();
    void deshacer();
}

class DispensarAlimentoCommand implements Comando {
    private Dispensador dispensador;
    private double cantidad;
    private double cantidadAnterior;
    
    public DispensarAlimentoCommand(Dispensador dispensador, double cantidad) {
        this.dispensador = dispensador;
        this.cantidad = cantidad;
    }
    
    @Override
    public void ejecutar() {
        cantidadAnterior = dispensador.getNivelActual();
        dispensador.dispensar(cantidad);
    }
    
    @Override
    public void deshacer() {
        System.out.println("Deshaciendo dispensación de " + cantidad + " kg");
        // En un caso real, recargaríamos el dispensador
    }
}

class InvocadorComandos {
    private Queue<Comando> comandos = new LinkedList<>();
    private Stack<Comando> historial = new Stack<>();
    
    public void agregarComando(Comando cmd) {
        comandos.offer(cmd);
    }
    
    public void ejecutarComandos() {
        while (!comandos.isEmpty()) {
            Comando cmd = comandos.poll();
            cmd.ejecutar();
            historial.push(cmd);
        }
    }
    
    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            Comando cmd = historial.pop();
            cmd.deshacer();
        }
    }
}

// === STATE ===
interface EstadoAnimal {
    void comer(AnimalConEstado contexto);
    void dormir(AnimalConEstado contexto);
    String obtenerDescripcion();
}

class EstadoSano implements EstadoAnimal {
    @Override
    public void comer(AnimalConEstado contexto) {
        System.out.println("Animal sano comiendo normalmente");
    }
    
    @Override
    public void dormir(AnimalConEstado contexto) {
        System.out.println("Animal sano durmiendo tranquilamente");
    }
    
    @Override
    public String obtenerDescripcion() {
        return "SANO";
    }
}

class EstadoEnfermo implements EstadoAnimal {
    @Override
    public void comer(AnimalConEstado contexto) {
        System.out.println("Animal enfermo come poco");
        // Posible transición a tratamiento
        contexto.cambiarEstado(new EstadoEnTratamiento());
    }
    
    @Override
    public void dormir(AnimalConEstado contexto) {
        System.out.println("Animal enfermo descansa más de lo normal");
    }
    
    @Override
    public String obtenerDescripcion() {
        return "ENFERMO";
    }
}

class EstadoEnTratamiento implements EstadoAnimal {
    private int diasTratamiento = 0;
    
    @Override
    public void comer(AnimalConEstado contexto) {
        diasTratamiento++;
        System.out.println("Animal en tratamiento, día " + diasTratamiento);
        
        if (diasTratamiento >= 5) {
            contexto.cambiarEstado(new EstadoSano());
        }
    }
    
    @Override
    public void dormir(AnimalConEstado contexto) {
        System.out.println("Animal en recuperación");
    }
    
    @Override
    public String obtenerDescripcion() {
        return "EN_TRATAMIENTO";
    }
}

class AnimalConEstado {
    private EstadoAnimal estado;
    private Animal animal;
    
    public AnimalConEstado(Animal animal) {
        this.animal = animal;
        this.estado = new EstadoSano();
    }
    
    public void cambiarEstado(EstadoAnimal nuevoEstado) {
        System.out.println("Cambiando estado de " + estado.obtenerDescripcion() + 
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
        }
    }
}

// ============================================
// SISTEMA PRINCIPAL DE INTEGRACIÓN
// ============================================

public class SistemaGranjaInteligente {
    private GranjaFacade facade;
    private AlimentadorGlobal alimentadorGlobal;
    private InvocadorComandos invocador;
    private Map<String, FabricaAnimales> fabricas;
    private List<SensorNivelAlimento> sensores;
    private ContextoAlimentacion contextoAlimentacion;
    
    public SistemaGranjaInteligente() {
        this.facade = new GranjaFacade();
        this.alimentadorGlobal = AlimentadorGlobal.obtenerInstancia();
        this.invocador = new InvocadorComandos();
        this.fabricas = new HashMap<>();
        this.sensores = new ArrayList<>();
        this.contextoAlimentacion = new ContextoAlimentacion();
        
        inicializar();
    }
    
    private void inicializar() {
        // Configurar fábricas
        fabricas.put("lechero", new FabricaCorralLechero());
        fabricas.put("carne", new FabricaCorralCarne());
        
        // Configurar dispensadores
        alimentadorGlobal.registrarDispensador("CORRAL-01", new Dispensador("D01", 1000));
        alimentadorGlobal.registrarDispensador("CORRAL-02", new Dispensador("D02", 1000));
        
        // Configurar sensores con observadores
        SensorNivelAlimento sensor1 = new SensorNivelAlimento("CORRAL-01");
        sensor1.agregarObservador(new SistemaAlertaObserver("CRÍTICO"));
        sensores.add(sensor1);
        
        System.out.println("Sistema Granja Inteligente inicializado");
    }
    
    public void procesarCicloAlimentacion() {
        System.out.println("\n========== CICLO DE ALIMENTACIÓN ==========");
        
        // 1. Sensor detecta nivel bajo
        System.out.println("\n1. DETECCIÓN DE SENSORES:");
        sensores.get(0).setNivelActual(15); // Simular nivel bajo
        sensores.get(0).medirNivel();
        
        // 2. Factory crea animales
        System.out.println("\n2. CREACIÓN DE ANIMALES:");
        Animal vaca = fabricas.get("lechero").procesarAnimal("vaca");
        
        // 3. Aplicar estrategia según estación
        System.out.println("\n3. ESTRATEGIA DE ALIMENTACIÓN:");
        contextoAlimentacion.setEstrategia(new EstrategiaInvierno());
        contextoAlimentacion.ejecutarAlimentacion(vaca);
        
        // 4. Ejecutar comando de dispensación
        System.out.println("\n4. EJECUCIÓN DE COMANDOS:");
        Dispensador disp = alimentadorGlobal.dispensadores.get("CORRAL-01");
        invocador.agregarComando(new DispensarAlimentoCommand(disp, 30));
        invocador.ejecutarComandos();
        
        // 5. Coordinar desde facade
        System.out.println("\n5. COORDINACIÓN CON FACADE:");
        facade.alimentarCorral("CORRAL-01");
    }
    
    public void demostrarDecoradores() {
        System.out.println("\n========== DECORADORES ==========");
        
        Animal vaca = new Vaca("V001", 450, 3, "Bessie");
        System.out.println("Animal base: " + vaca.obtenerInfo());
        
        Animal vacaConVacuna = new AnimalConVacuna(vaca);
        ((AnimalConVacuna)vacaConVacuna).agregarVacuna("Aftosa");
        System.out.println("Con vacuna: " + vacaConVacuna.obtenerInfo());
        
        Animal vacaCompleta = new AnimalConGPS(vacaConVacuna);
        ((AnimalConGPS)vacaCompleta).actualizarUbicacion(4.7110, -74.0721);
        System.out.println("Con GPS: " + vacaCompleta.obtenerInfo());
    }
    
    public void demostrarEstados() {
        System.out.println("\n========== ESTADOS DE SALUD ==========");
        
        Animal cerdo = new Cerdo("C001", 80, 2, "Porky");
        AnimalConEstado animalConEstado = new AnimalConEstado(cerdo);
        
        animalConEstado.realizarAccion("comer");
        animalConEstado.cambiarEstado(new EstadoEnfermo());
        animalConEstado.realizarAccion("comer");
        animalConEstado.realizarAccion("dormir");
    }
    
    public static void main(String[] args) {
        SistemaGranjaInteligente sistema = new SistemaGranjaInteligente();
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA GRANJA INTELIGENTE v1.0     ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        // Demostrar flujo principal
        sistema.procesarCicloAlimentacion();
        
        // Demostrar decoradores
        sistema.demostrarDecoradores();
        
        // Demostrar estados
        sistema.demostrarEstados();
        
        // Estado final del sistema
        System.out.println("\n========== ESTADO FINAL ==========");
        System.out.println(sistema.alimentadorGlobal.obtenerEstadoGlobal());
        System.out.println(sistema.facade.obtenerEstadoGeneral());
    }
}
