# Sistema de Notificaciones Multicanal

Proyecto Java 17 con Maven. Simula el envío por correo, SMS y chat/push, con registro de usuarios, preferencias, plantillas, envío urgente e informativo e historial.

## Ejecutar en IntelliJ IDEA
1. Abrir la carpeta del proyecto o el archivo `pom.xml`.
2. Esperar a que Maven descargue dependencias.
3. Para consola, ejecutar `co.unilibre.notificaciones.vista.consola.Consola`.
4. Para interfaz gráfica, ejecutar `co.unilibre.notificaciones.vista.gui.Ventana`.

También se puede ejecutar desde terminal:
- `mvn test`
- `mvn compile`

## Funcionalidades
- Registrar usuarios y su canal preferido.
- Envío urgente por todos los canales.
- Envío informativo por el canal preferido.
- Plantillas con variable `{nombre}`.
- Historial en memoria.
- Canales simulados: Correo, SMS y Chat/Push.

## Organización
- `modelo`: Usuario y Mensaje.
- `canales`: interfaz, adaptadores y fábrica.
- `estrategias`: reglas de envío y reintentos.
- `nucleo`: Facade que coordina el sistema.
- `vista.consola` y `vista.gui`: interfaces que utilizan el mismo núcleo.
- `test`: pruebas unitarias.
