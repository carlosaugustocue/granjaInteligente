# 🚜 Granja Inteligente - Guía de Inicio Rápido

## Descripción
Sistema de simulación de una granja inteligente que implementa todos los patrones de diseño GoF (Gang of Four):
- **Patrones Creacionales**: Factory Method, Abstract Factory, Builder, Singleton
- **Patrones Estructurales**: Adapter, Decorator, Facade
- **Patrones Comportamentales**: Observer, Strategy, Command, State

## Estructura del Proyecto

```
granjaInteligente/
├── src/
│   ├── main/java/com/granja/
│   │   ├── modelos/                    # Clases de dominio
│   │   ├── patrones/
│   │   │   ├── creacionales/          # Patrones creacionales
│   │   │   ├── estructurales/         # Patrones estructurales
│   │   │   └── comportamentales/      # Patrones comportamentales
│   │   └── SistemaGranjaInteligente.java
│   └── test/java/com/granja/
│       └── SistemaGranjaInteligenteTest.java
├── pom.xml                             # Configuración Maven
├── compile.sh                          # Script de compilación
└── README.md                           # Documentación completa
```

## Compilación

### Opción 1: Usando el script de compilación (recomendado)

```bash
chmod +x compile.sh
./compile.sh
```

### Opción 2: Compilación manual con Maven (si está instalado)

```bash
mvn clean compile
```

### Opción 3: Compilación manual con javac

```bash
javac -source 11 -target 11 -d target/classes src/main/java/com/granja/**/*.java
```

## Ejecución

### Ejecutar el sistema principal

```bash
java -cp target/classes com.granja.SistemaGranjaInteligente
```

### Ejecutar las pruebas unitarias

```bash
# Si Maven está instalado
mvn test

# O manualmente (requiere JUnit en el classpath)
java -cp target/classes:target/test-classes org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## Patrones Implementados

### 1. Factory Method
**Ubicación**: `patrones/creacionales/FabricaAnimales.java`
- Crea diferentes tipos de animales según el tipo de corral
- Clases: `FabricaCorralLechero`, `FabricaCorralCarne`, `FabricaCorralHuevos`

### 2. Abstract Factory
**Ubicación**: `patrones/creacionales/GranjaAbstractFactory.java`
- Crea familias de objetos relacionados (animal, alimento, corral)
- Clases: `GranjaLecheraFactory`, `GranjaPorcinaFactory`

### 3. Builder
**Ubicación**: `patrones/creacionales/AnimalBuilder.java`
- Construye animales complejos paso a paso
- Clase: `DirectorGranja` para construcciones predefinidas

### 4. Singleton
**Ubicación**: `patrones/creacionales/AlimentadorGlobal.java`
- Una única instancia para gestionar dispensadores globales
- Gestión centralizada de alimentación

### 5. Adapter
**Ubicación**: `patrones/estructurales/AdaptadorSensor.java`
- Adapta sensores antiguos (legacy) al nuevo sistema
- Convierte datos de formato antiguo a moderno

### 6. Decorator
**Ubicación**: `patrones/estructurales/`
- Agrega funcionalidades a animales dinámicamente
- Clases: `AnimalConVacuna`, `AnimalConGPS`, `AnimalConHistorialReproductivo`

### 7. Facade
**Ubicación**: `patrones/estructurales/GranjaFacade.java`
- Simplifica interacción con subsistemas complejos
- Coordina: Alimentación, Riego, Monitoreo, Alertas

### 8. Observer
**Ubicación**: `patrones/comportamentales/`
- Monitorea niveles de alimento y notifica observadores
- Clases: `SensorNivelAlimento`, `SistemaAlertaObserver`, `RegistroEventosObserver`

### 9. Strategy
**Ubicación**: `patrones/comportamentales/`
- Diferentes estrategias de alimentación según estación
- Clases: `EstrategiaInvierno`, `EstrategiaVerano`, `EstrategiaAhorro`

### 10. Command
**Ubicación**: `patrones/comportamentales/`
- Encapsula operaciones como objetos
- Clases: `DispensarAlimentoCommand`, `EncenderRiegoCommand`, `RegistrarEventoCommand`

### 11. State
**Ubicación**: `patrones/comportamentales/`
- Gestiona diferentes estados de animales
- Clases: `EstadoSano`, `EstadoEnfermo`, `EstadoEnTratamiento`

## Flujo de Ejecución

El programa realiza el siguiente flujo integrado:

1. **Inicialización** del sistema con todos los componentes
2. **Creación de animales** usando Factory Method
3. **Construcción con Builder** para animales complejos
4. **Aplicación de Decoradores** (vacunas, GPS)
5. **Creación de Corrales** especializados
6. **Registro de Dispensadores** (Singleton)
7. **Monitoreo con Sensores** (Observer)
8. **Aplicación de Estrategias** de alimentación
9. **Ejecución de Comandos** con historial
10. **Gestión de Estados** de animales
11. **Adaptación de Sensores** antiguos
12. **Coordinación mediante Facade**
13. **Monitoreo y Reportes** finales

## Estructura de Datos en Memoria

El sistema usa:
- **HashMap** para almacenar animales, corrales y dispensadores
- **ArrayList** para listas de observadores y comandos
- **Stack** para historial de comandos (undo)

No requiere base de datos - todo está en memoria.

## Ejemplo de Uso

```java
// Crear sistema
SistemaGranjaInteligente sistema = new SistemaGranjaInteligente();

// Ejecutar ciclo completo
sistema.procesarCicloAlimentacion();  // Ejecuta todos los patrones
sistema.monitorearGranja();           // Monitorea estado
sistema.ejecutarMantenimiento();      // Tareas de mantenimiento
```

## Información de Compilación

- **Java mínimo**: Java 11
- **Maven**: 3.6+ (opcional)
- **Dependencias**: JUnit 5 (solo para pruebas)

## Salida Esperada

El programa mostrará:
- Inicialización de componentes
- Ciclo de alimentación completo
- Notificaciones del Observer
- Ejecución de comandos
- Estado de animales
- Monitoreo de granja
- Reporte diario
- Tareas de mantenimiento

## Notas Importantes

- Todos los datos se guardan en memoria (HashMap/ArrayList)
- El sistema es completamente funcional sin dependencias externas
- Las pruebas unitarias validan cada patrón
- El código está bien documentado con comentarios
- Cada patrón puede ser usado de forma independiente

## Próximos Pasos

1. Estudiar cada implementación de patrón
2. Modificar estrategias de alimentación
3. Agregar nuevos tipos de animales
4. Extender el sistema con más patrones
5. Integrar con una base de datos real

---
**Laboratorio de POO y Patrones de Diseño** - Granja Inteligente v1.0
