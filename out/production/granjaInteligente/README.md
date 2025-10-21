# 🚜 Sistema Granja Inteligente - Patrones de Diseño

## 📋 Descripción del Proyecto

Sistema de simulación para una granja inteligente que implementa los principales patrones de diseño GoF (Gang of Four) para automatizar la gestión de animales, alimentación y monitoreo.

## 🎯 Objetivos

- Aplicar patrones de diseño creacionales, estructurales y comportamentales
- Integrar múltiples patrones en un sistema coherente
- Desarrollar software escalable y mantenible
- Trabajar colaborativamente usando Git

## 📁 Estructura del Proyecto

```
granja-inteligente/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── modelos/
│   │   │   │   ├── Animal.java
│   │   │   │   ├── Vaca.java
│   │   │   │   ├── Cerdo.java
│   │   │   │   └── Gallina.java
│   │   │   ├── patrones/
│   │   │   │   ├── creacionales/
│   │   │   │   │   ├── FabricaAnimales.java
│   │   │   │   │   ├── AnimalBuilder.java
│   │   │   │   │   └── AlimentadorGlobal.java
│   │   │   │   ├── estructurales/
│   │   │   │   │   ├── AnimalDecorator.java
│   │   │   │   │   ├── AdaptadorSensor.java
│   │   │   │   │   └── GranjaFacade.java
│   │   │   │   └── comportamentales/
│   │   │   │       ├── Observer.java
│   │   │   │       ├── EstrategiaAlimentacion.java
│   │   │   │       ├── Comando.java
│   │   │   │       └── EstadoAnimal.java
│   │   │   └── SistemaGranjaInteligente.java
│   └── test/
│       └── java/
│           └── PatronesTest.java
├── docs/
│   ├── diagramas/
│   │   └── sistema-completo.puml
│   └── arquitectura.md
├── README.md
└── pom.xml / build.gradle
```

## 🔧 Patrones Implementados

### Patrones Creacionales

#### 1. Factory Method
- **Propósito**: Crear animales según el tipo de corral
- **Clases**: `FabricaAnimales`, `FabricaCorralLechero`, `FabricaCorralCarne`
- **Uso**: 
```java
FabricaAnimales fabrica = new FabricaCorralLechero();
Animal vaca = fabrica.crearAnimal("vaca");
```

#### 2. Abstract Factory
- **Propósito**: Crear familias de objetos relacionados
- **Clases**: `GranjaAbstractFactory`, `GranjaLecheraFactory`
- **Uso**: Crea conjuntos coherentes de animal + alimento + corral

#### 3. Builder
- **Propósito**: Construir animales con configuración compleja
- **Clases**: `AnimalBuilder`, `DirectorGranja`
- **Uso**:
```java
Animal vaca = new AnimalBuilder()
    .construirNuevoAnimal("vaca")
    .conPeso(450)
    .conEdad(3)
    .conNombre("Bessie")
    .obtener();
```

#### 4. Singleton
- **Propósito**: Una única instancia del sistema de alimentación
- **Clase**: `AlimentadorGlobal`
- **Uso**: `AlimentadorGlobal.obtenerInstancia()`

### Patrones Estructurales

#### 1. Adapter
- **Propósito**: Compatibilizar sensores antiguos con el sistema nuevo
- **Clases**: `AdaptadorSensor`, `SensorLegacy`

#### 2. Decorator
- **Propósito**: Añadir funcionalidades dinámicamente a los animales
- **Clases**: `AnimalConVacuna`, `AnimalConGPS`
- **Ejemplo**:
```java
Animal vaca = new Vaca(...);
vaca = new AnimalConVacuna(vaca);
vaca = new AnimalConGPS(vaca);
```

#### 3. Facade
- **Propósito**: Simplificar la interacción con subsistemas complejos
- **Clase**: `GranjaFacade`
- **Subsistemas**: Alimentación, Riego, Monitoreo, Alertas

### Patrones Comportamentales

#### 1. Observer
- **Propósito**: Notificar cambios en niveles de alimento
- **Clases**: `SensorNivelAlimento`, `SistemaAlertaObserver`

#### 2. Strategy
- **Propósito**: Cambiar estrategias de alimentación según la estación
- **Clases**: `EstrategiaInvierno`, `EstrategiaVerano`, `EstrategiaAhorro`

#### 3. Command
- **Propósito**: Encapsular operaciones como objetos
- **Clases**: `DispensarAlimentoCommand`, `EncenderRiegoCommand`

#### 4. State
- **Propósito**: Manejar estados de salud de los animales
- **Clases**: `EstadoSano`, `EstadoEnfermo`, `EstadoEnTratamiento`

## 🚀 Flujo de Integración

El sistema integra todos los patrones en un flujo automatizado:

1. **Sensor** (Observer) detecta nivel bajo de alimento
2. **Fábrica** (Factory Method) crea animales según el corral
3. **Estrategia** (Strategy) determina cantidad según estación
4. **Comando** (Command) ejecuta la dispensación
5. **Facade** coordina todo el proceso

## 🛠️ Configuración del Proyecto

### Prerequisitos
- Java 11+ o Python 3.8+
- Git
- Maven o Gradle (para Java)

### Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/granja-inteligente.git
cd granja-inteligente
```

2. Para Java con Maven:
```bash
mvn clean install
mvn compile
```

3. Para Java con Gradle:
```bash
gradle build
```

4. Ejecutar el programa principal:
```bash
java -cp target/classes SistemaGranjaInteligente
```

## 👥 Trabajo en Equipo con Git

### Estrategia de Ramas

```
main
├── develop
│   ├── feature/patrones-creacionales
│   ├── feature/patrones-estructurales
│   ├── feature/patrones-comportamentales
│   └── feature/integracion-sistema
```

### Asignación de Trabajo

#### Desarrollador 1 - Patrones Creacionales
```bash
git checkout -b feature/patrones-creacionales
# Implementar: Factory Method, Abstract Factory, Builder, Singleton
git add .
git commit -m "feat: implementar patrones creacionales"
git push origin feature/patrones-creacionales
```

#### Desarrollador 2 - Patrones Estructurales
```bash
git checkout -b feature/patrones-estructurales
# Implementar: Adapter, Decorator, Facade
git add .
git commit -m "feat: implementar patrones estructurales"
git push origin feature/patrones-estructurales
```

#### Desarrollador 3 - Patrones Comportamentales
```bash
git checkout -b feature/patrones-comportamentales
# Implementar: Observer, Strategy, Command, State
git add .
git commit -m "feat: implementar patrones comportamentales"
git push origin feature/patrones-comportamentales
```

#### Desarrollador 4 - Integración y Testing
```bash
git checkout -b feature/integracion-sistema
# Integrar todos los patrones, crear main, testing
git add .
git commit -m "feat: integrar sistema completo"
git push origin feature/integracion-sistema
```

### Flujo de Trabajo

1. **Crear rama desde develop**:
```bash
git checkout develop
git pull origin develop
git checkout -b feature/nombre-funcionalidad
```

2. **Desarrollar y hacer commits**:
```bash
git add .
git commit -m "tipo: descripción"
```

Tipos de commit:
- `feat`: nueva funcionalidad
- `fix`: corrección de bugs
- `docs`: documentación
- `refactor`: refactorización
- `test`: pruebas

3. **Crear Pull Request**:
```bash
git push origin feature/nombre-funcionalidad
```
Luego crear PR en GitHub/GitLab

4. **Merge después de revisión**:
```bash
git checkout develop
git merge feature/nombre-funcionalidad
git push origin develop
```

## 📊 Ejecución y Resultados

### Salida Esperada

```
╔════════════════════════════════════════╗
║   SISTEMA GRANJA INTELIGENTE v1.0     ║
╚════════════════════════════════════════╝

========== CICLO DE ALIMENTACIÓN ==========

1. DETECCIÓN DE SENSORES:
Nivel de alimento en CORRAL-01: 15.0 kg
⚠️ ALERTA CRÍTICO: Nivel bajo en CORRAL-01 - 15.0 kg

2. CREACIÓN DE ANIMALES:
Procesando nuevo animal: Animal: Vaca-1, ID: VACA-1, Peso: 450.00 kg, Edad: 3 años

3. ESTRATEGIA DE ALIMENTACIÓN:
Alimentando a Vaca-1:
  - Tipo: Alimento enriquecido de invierno
  - Cantidad: 17.55 kg
  - Frecuencia: 3 veces/día

4. EJECUCIÓN DE COMANDOS:
Dispensado 30.0 kg. Nivel actual: 970.0

5. COORDINACIÓN CON FACADE:
=== Iniciando proceso de alimentación ===
Verificando estado del corral CORRAL-01
Distribuyendo 50.0 kg de alimento en corral CORRAL-01
Evento registrado: Alimentación completada en corral CORRAL-01
```

## 📈 Métricas de Evaluación

| Criterio | Descripción | Ponderación |
|----------|-------------|-------------|
| Patrones Creacionales | Implementación correcta | 20% |
| Patrones Estructurales | Integración funcional | 20% |
| Patrones Comportamentales | Flujo coherente | 25% |
| Integración del Sistema | Funcionamiento completo | 20% |
| Documentación | Claridad y diagramas | 15% |

## 📝 Documentación Adicional

### Generar Diagrama PlantUML

1. Copiar contenido del archivo `.puml`
2. Ir a [PlantUML Online](http://www.plantuml.com/plantuml/uml/)
3. Pegar y generar diagrama

### Ejecutar Tests
```bash
mvn test
# o
gradle test
```

## 🤝 Contribuciones

1. Fork el proyecto
2. Crear rama de feature (`git checkout -b feature/AmazingFeature`)
3. Commit cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir Pull Request

## 📄 Licencia

Este proyecto es con fines educativos - Laboratorio de Programación Orientada a Objetos

## ✨ Conclusiones

Este laboratorio demuestra cómo los patrones de diseño:
- Mejoran la modularidad y reusabilidad del código
- Facilitan el mantenimiento y escalabilidad
- Promueven las buenas prácticas de programación
- Permiten trabajo colaborativo efectivo

## 📞 Contacto

Para dudas o consultas sobre el laboratorio, contactar al docente del curso.
