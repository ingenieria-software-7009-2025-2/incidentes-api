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

