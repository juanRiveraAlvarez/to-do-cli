#!/bin/bash

# Verifica permisos
if [ "$EUID" -ne 0 ]; then
  echo "❌ Este script debe ejecutarse con sudo"
  echo "➡️  Usa: sudo ./install-to-do-global.sh"
  exit 1
fi

echo "🛠 Instalación de to-do CLI para todos los usuarios..."

# === CONFIGURACIÓN ===
JAR_NAME="to-do-cli-0.1.jar"
INSTALL_DIR="/opt/to-do"
BIN_PATH="/usr/local/bin/todo"
DATA_DIR="/var/lib/to-do"
TASK_FILE="$DATA_DIR/Task.json"
CONFIG_FILE="$INSTALL_DIR/config.properties"

# === COMPILAR PROYECTO ===
echo "🔨 Compilando con Maven..."
mvn package
if [ $? -ne 0 ]; then
  echo "❌ La compilación falló."
  exit 1
fi

# === CREAR DIRECTORIO DE INSTALACIÓN Y COPIAR .JAR ===
echo "📁 Instalando en $INSTALL_DIR..."
mkdir -p "$INSTALL_DIR"
mkdir -p /opt/to-do
cp target/*.jar "$INSTALL_DIR"

# === CREAR CONFIG PROPERTIES SI NO EXISTE ===
if [ ! -f "$CONFIG_FILE" ]; then
  echo "📝 Creando archivo de configuración predeterminado..."
  cat > "$CONFIG_FILE" <<EOF
Task.path=/var/lib/to-do/Task.json
EOF
fi

# === CREAR CARPETA DE DATOS Y ARCHIVO JSON VACÍO ===
echo "📂 Verificando carpeta de datos en $DATA_DIR..."
mkdir -p "$DATA_DIR"
chmod 755 "$DATA_DIR"

if [ ! -f "$TASK_FILE" ]; then
  echo "[]" > "$TASK_FILE"
  chmod 644 "$TASK_FILE"
  echo "✅ Archivo Task.json creado en $TASK_FILE"
else
  echo "✅ Ya existe $TASK_FILE"
fi

# === CREAR EJECUTABLE GLOBAL ===
echo "🚀 Creando ejecutable en $BIN_PATH..."
cat > "$BIN_PATH" <<EOF
#!/bin/bash
java -jar "$INSTALL_DIR/$JAR_NAME" "\$@"
EOF

chmod +x "$BIN_PATH"

echo "✅ Instalación completa."
echo "👉 Ya puedes ejecutar el programa escribiendo: todo"

