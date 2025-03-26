# Instrucciones para correr el Proyecto

## Parte del Backend

En este caso, se optó por subir la base de datos a la nube pero es necesario cargar las credenciales, dentro de la ruta "src/main", es necesario crear una carpeta que se llame "resources", dentro de "src/main/resources" se necesita un file que se nombrará como "application.properties".

Y finalmente, en "application.properties" se pegaran estás credenciales:

```javascript
spring.application.name=incidentes-api
spring.datasource.url=jdbc:postgresql://yamabiko.proxy.rlwy.net:46003/railway
spring.datasource.username=postgres
spring.datasource.password=IrTkuSBxnrczztdPVGWVeoWOMWIfVdeS
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Finalmente, no debería haber problemas para correr el proyecto en la parte del backend.

## Parte del Frontend

### Dependencias Necesarias:

Node.js (versión 16 o superior recomendada), descarga [aquí](https://nodejs.org/es/download)

npm como gestor de paquetes

### Instalación y ejecución

Sigue estos pasos para instalar y ejecutar el proyecto en tu entorno local:

1. Clonar el repositorio
```bash
 git clone https://github.com/tu-usuario/nombre-del-repositorio.git
 cd incidentes-amantesdlp-frontend
```

2. Instalar dependencias

```bash
 npm install 
``` 

3. Ejecutar el servidor de desarrollo

```bash
 npm run dev  
```