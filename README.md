📌 to-do-cli

to-do-cli es una aplicación de terminal para gestionar tareas personales, escrita en Java con arquitectura hexagonal (puertos y adaptadores) y sin frameworks como Spring.

Permite añadir, listar y eliminar tareas, guardándolas de forma persistente en un archivo Task.json.
🧠 Características principales

    📦 Arquitectura limpia basada en puertos y adaptadores

    💾 Persistencia en archivo Task.json

    🧪 Proyecto listo para testing unitario

    🖥️ Interfaz completamente en terminal

    🐧 Compatible con Linux, y fácil de instalar como comando global

🚀 Instalación
1. Clona el proyecto

git clone https://github.com/tuusuario/to-do-cli.git
cd to-do-cli

2. Compila el proyecto

mvn clean package

3. Ejecuta el script de instalación

Esto instalará el .jar globalmente y configurará el comando todo.

sudo ./install-to-do-global.sh

    Esto copiará el .jar a /opt/to-do/ y creará un lanzador global en /usr/local/bin/todo.

🧑‍💻 Uso

Una vez instalado, puedes ejecutar el comando:

todo

📚 Comandos disponibles:

    todo add "comprar pan" – Añade una nueva tarea

    todo list – Lista todas las tareas

    todo delete <id> – Elimina una tarea por ID

    Las tareas se guardan en /var/lib/to-do/Task.json. Si no existe, se crea automáticamente.

⚙️ Configuración

La ruta de almacenamiento puede configurarse en el archivo config.properties:

Task.path=/var/lib/to-do/Task.json

El archivo puede estar en resources/ o en el directorio classes, y se puede acceder desde la aplicación con:

props.load(App.class.getClassLoader().getResourceAsStream("config.properties"));

🧪 Testing

El proyecto incluye pruebas unitarias con JUnit 5. Para ejecutarlas:

mvn test

🖼️ Integración con Rofi (opcional)

Puedes ejecutar todo desde Rofi con un archivo .desktop:

[Desktop Entry]
Name=To-Do CLI
Comment=Gestor de tareas por terminal
Exec=gnome-terminal -- bash -c "todo; exec bash"
Icon=utilities-terminal
Terminal=false
Type=Application
Categories=Utility;

Guarda este archivo como:

~/.local/share/applications/todo.desktop

🧱 Arquitectura

Este proyecto sigue una estructura hexagonal:

📦 to-do-cli/
├── domain/               # Modelos de dominio y repositorios
├── infrastructure/       # Adaptadores y puertos
├── classes/              # Archivos de configuración
├── App.java              # Punto de entrada
└── config.properties     # Ruta de configuración del archivo JSON

🛠 Requisitos

    Java 17+

    Maven

    Un emulador de terminal (Alacritty, Gnome Terminal, Xterm, etc.)

📝 Licencia

Este proyecto está licenciado bajo los términos de la **GNU General Public License v3.0**.


