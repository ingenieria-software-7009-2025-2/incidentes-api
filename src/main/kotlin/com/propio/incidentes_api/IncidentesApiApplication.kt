package com.propio.incidentes_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IncidentesApiApplication
//Fooo
fun main(args: Array<String>) {
	runApplication<IncidentesApiApplication>(*args)
}


/*

25/02/25

cada atributo de la clase es una columna de la tabla

los @ de la foto sirven para relacionar entre la tabla y spring
annotation, le agregamos el nombre de la columna

ejem @table("users")usuarios{}

para obteneer inf de la BD utilizamos la fun repository -> conectarse a la BD
cual sea el tipo, con ayuda de las entidades

UserRepository tiene que heredar de CRUDRepository = User. Int (llave prim)

Queremos invocar a repository desde Uusaripcontroller para poder interactuar con nuestra BD

en el usercontroler hay que usar el parametro de UserRepository (inyeccion de dependencias(?))

Aunque tengamos vacio el UserRepository pero podemos llamar de otro lado nos da todas las funciones que puede hacer

Podemos generar queries customizadas aparte de las del CRUD repository @Query

SI CAMBIAMOS A POSTGRES HAY QUE REVISAR POM Y APPLICATION PROPERTIES


Del controler tiene que pasar a un ente(SERVICE) y de ahi al repository

Tenemos que tener un usuario dominante por si nos cambian el req\

El Service se comporta igual que Userrepository(?)

Que esperamos con el login-> que el correo y la contra hagan match


 */