![imagen](https://github.com/user-attachments/assets/f75192d3-53e4-45e0-8753-384b28bdb595)# Instrucciones para correr el Proyecto

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
4. Abrir http:/localhost:5173/ o en la terminal dónde estamos corriendo el proyecto poner o y darle a enter.
5. Vistas disponibles:
    - Login
      ![imagen](https://github.com/user-attachments/assets/842cef85-6840-4a3a-bd0e-8d2453e1decb)

    - Registro
       ![imagen](https://github.com/user-attachments/assets/46aaa4ee-c7c6-4626-acf8-3cea5e2df816)

    - Dashboard
      ![imagen](https://github.com/user-attachments/assets/bf4fdc83-7304-4dc0-81af-26ac5a4bc187)

    - Mi Perfil
      ![imagen](https://github.com/user-attachments/assets/43054a84-4c50-47ca-8741-ac68739ee776)


      
   

