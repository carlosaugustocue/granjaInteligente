#!/bin/bash

echo "╔════════════════════════════════════════╗"
echo "║  COMPILACIÓN - GRANJA INTELIGENTE      ║"
echo "╚════════════════════════════════════════╝"

mkdir -p target/classes target/test-classes

echo ""
echo "📦 Compilando código fuente..."
javac -source 11 -target 11 -d target/classes $(find src/main/java -name "*.java" -type f) 2>&1 | grep -v "warning"

if [ $? -eq 0 ]; then
    echo "✓ Compilación exitosa"
else
    echo "✗ Error en la compilación"
    exit 1
fi

echo ""
echo "🧪 Compilando pruebas..."
javac -source 11 -target 11 -cp "target/classes:lib/*" -d target/test-classes $(find src/test/java -name "*.java" -type f) 2>&1 | grep -v "warning" || true

echo ""
echo "✓ Compilación completada"
echo ""
