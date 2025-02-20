# Requerimientos del proyecto

# 1. Introducción

## 1.1 Propósito

El Sistema de Gestión de Reportes de Accidentes Urbanos (SGRAU) facilita la recopilación, administración y validación de incidentes urbanos, promoviendo transparencia y respuesta eficiente de las autoridades.

## 1.2 Alcance

El SGRAU permitirá:

- Registrar accidentes con ubicación, evidencia fotográfica y descripción.
- Validar y gestionar reportes para asegurar su autenticidad.
- Administrar reportes y usuarios con control de estatus.

## 1.3 Definiciones y Abreviaciones

- **SGRAU**: Sistema de Gestión de Reportes de Accidentes Urbanos.
- **Usuario**: Persona que accede al sistema.
- **Administrador**: Usuario con permisos avanzados de gestión.
- **Reporte**: Registro de un accidente urbano.
- **Estatus**: Estado del reporte (Reportado, En Proceso, Resuelto).
- **Reputación**: Métrica basada en la veracidad de los reportes.
- **Validación**: Revisión de un reporte para confirmar su autenticidad.
- **Incidente**: Evento urbano reportado.

Este documento define los requerimientos para la implementación del sistema.

# 2. Requerimientos del sistema

## 2.1 Requerimientos Funcionales

### RF1: Autenticación de Usuarios

- El sistema deberá permitir el acceso mediante credenciales únicas (usuario y contraseña).
    - Deberá haber diferentes niveles de acceso: administradores y usuarios

### RF2: Gestión de Usuarios

- El sistema permitirá el registro, inicio de sesión, edición y eliminación de usuarios.
- Se podrán visualizar los datos de contacto y estado de los usuarios.
- Los administradores podrán restringir, eliminar y bloquear usuarios con comportamiento inapropiado.
- Los usuarios podrán reportar publicaciones y usuarios.

### RF3: Reporte de Incidentes

- El sistema permitirá reportar incidentes desde su cuenta proporcionando:
    - Evidencia fotográfica
    - Descripción detallada
    - Estado del Incidente
    - Ubicación
- Los administradores podrán eliminar publicaciones que no cumplan con las reglas de la comunidad.
- Si más de una persona reporta el mismo incidente habrá un histórico recopilatorio del mismo incidente.

### RF4: Gestión de Incidentes

- Se podrá reportar, editar y eliminar incidentes del tablón de incidentes.
- Cualquier usuario/administrador podrá modificar el estado de los incidentes (Reportado, En Proceso, Resuelto) si provee suficientes pruebas (evidencia fotográfica).

### RF5: Interacción con incidentes

- Los usuarios podrán visualizar mediante etiquetas el tipo de cada incidente. (Etiquetas tales como baches, iluminarias, etc.)
- Se podrán visualizar el estatus de los incidentes en un mapa interactivo (Reportado, En Proceso, Resuelto).

### RF6: Búsqueda y Consulta de Incidentes

- El usuario podrá buscar incidentes mediante ubicaciones, descripción y tipo.
- Se podrá filtrar por:
    - Tipo de Incidente
    - Antigüedad
    - Cercanía

### RF7: Notificación y Alerta de Incidentes

- Los usuarios recibirán notificaciones si hay cambios en el estado de su reporte.
- Se emitirán notificaciones sobre incidentes cercanos a los usuarios.

## 2.2 Requerimientos No Funcionales

### RNF1: Seguridad

- El sistema deberá cifrar las contraseñas de los usuarios.
- El sistema permite registrar una pregunta de seguridad en caso de que el usuario olvide su contraseña.
- El administrador al momento de cambiar de estatus un incidente, deberá de proporcionar el ID de dicho incidente, además de su pin de cuatro dígitos.

### RNF2: Rendimiento

- El sistema deberá soportar al menos 50 usuarios de manera simultánea.
- El sistema deberá tardar menos de 5 segundos en mostrar el reporte en el mapa interactivo.

### RNF3: Disponibilidad

- El sistema deberá estar disponible al menos el 99% del tiempo.

### RNF4: Usabilidad

- La interfaz deberá ser intuitiva, usable y amigable con las personas analfabetas.

# 3. Casos de Uso

## CU1. Hacer un reporte

### Actores: Usuario con sesión

### Flujo principal:

- El usuario inicia sesión.
- La aplicación registra la ubicación actual del usuario.
- El usuario toma una/varias fotografías del incidente.
- El usuario brinda una descripción del incidente.
- El usuario sube su reporte y se muestra público.

### Flujo alternativo:

- Si el usuario no tiene cuenta, o no ha iniciado sesión, se le pide que cree una o inicie sesión.
- Si el usuario sube un reporte sin fotografía, rechazar el reporte.
- Si la ubicación del incidente ya ha sido previamente reportada, agrupar los reportes en una misma ubicación.
- Si no se logra tener la ubicación del usuario automáticamente, solicitar al usuario que la brinde.

## CU2. Ver un reporte

### Actores: Usuario no necesariamente con cuenta

### Flujo principal:

- El usuario selecciona en el mapa interactivo un incidente.
- Se muestran los reportes del incidente, ya sea uno o varios (los que haya).
- Se ofrece la opción de reportar como resuelto/falso.
- El usuario puede cerrar el reporte cuando quiera.

### Flujo alternativo:

- Si el usuario desea reportar como resuelto/falso, se le pedirá iniciar sesión y pasará al menú respectivo.
- Si el usuario inicia sesión antes de ver los reportes, se mostrarán los usuarios que hicieron los reportes. En caso contrario, los reportes permanecerán anónimos y se brindará información limitada.

## CU3. Actualización de estado de reporte

### Actores: Usuario, Administrador

### Flujo principal:

- El usuario inicia sesión.
- El sistema muestra la página principal.
- El usuario selecciona la opción de ver incidentes.
- El sistema muestra el mapa interactivo con los incidentes.
- El usuario busca y selecciona el incidente en el mapa.
- El sistema muestra la información del incidente.
- El usuario selecciona la opción de actualizar.
- El sistema muestra el formulario que se debe llenar para la actualización.
- El usuario llena el formulario y lo manda a validación.
- El sistema actualiza el estado del incidente a “Esperando Validación”.
- El sistema muestra un mensaje de confirmación.

### Flujo alternativo:

- El usuario busca y selecciona el incidente por nombre.
- Si el usuario no llena completamente el formulario no puede mandarlo a validación.
- El administrador podría no necesitar llenar el formulario, pero se el sistema le muestra un mensaje para confirmar la acción.

## CU4. Crear cuenta

### Actores: Usuario

### Flujo principal:

- El usuario selecciona la opción “Registrarse”.
- El sistema muestra el formulario de registro.
- El usuario completa el formulario con sus datos.
- El usuario envía el formulario.
- El sistema valida el formato de la información.
- El sistema crea la cuenta y envía un correo de confirmación.
- El usuario recibe el correo y confirma su cuenta.
- El sistema activa la cuenta y redirige al usuario a la página de inicio de sesión.

### Flujo alternativo:

- Si el usuario ingresa un correo ya registrado, el sistema muestra un mensaje de error y sugiere iniciar sesión o recuperar la contraseña.
- Si el usuario ingresa un dato en formato inválido, el sistema le pedirá revisarlo.
- Si el usuario no completa todos los campos obligatorios, el sistema muestra un mensaje de error y solicita la información faltante.
- Si el usuario no confirma su correo, no podrá iniciar sesión.

# 4. Requisitos de Hardware y Software

## 4.1 Hardware

- Servidor con al menos 8GB de RAM y procesador Quad-Core.
- Base de datos alojada en un sistema con almacenamiento SSD.

## 4.2 Software

- Frontend : React.
- Backend: Spring Boot con Kotlin.
- Base de datos : MongoDB.
- Herramientas de prueba : Postman para testeo de API.
- IDE recomendado : IntelliJ IDEA (Community Edition / Ultimate).

# 5. Notas Finales - Justificaciones

Decidimos usar MongoDB como base de datos debido a su estructura flexible basada en documentos , lo que nos va a facilitar el almacenamiento y recuperación de reportes de accidentes. Aparte, su capacidad de escalar horizontalmente permite gestionar un alto volumen de reportes sin comprometer el rendimiento.