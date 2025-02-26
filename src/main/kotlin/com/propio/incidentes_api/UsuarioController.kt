package com.propio.incidentes_api

import jakarta.annotation.PostConstruct
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/v1/users")
public class UsuarioController{

    /**2.1
    *Un metodo Post para crear un usuario:
    *El endpoint debe debe de aceptar en el body del request la representación del modelo Usuario en JSON, despues
     * crear el objeto Usuario y devolverlo con un 200 ok.
    *Hint: Revisen el ejemplo del MascotaController que recibe la info de una mascota, es idéntico.*/

    @PostMapping
    fun retriveUsuarios(@RequestBody usuarioBody: UsuarioBody): ResponseEntity<UsuarioBody> {

        val user = UsuarioBody(
            mail = usuarioBody.mail,
            password = usuarioBody.password,
            token = usuarioBody.token
        )

        return ResponseEntity.ok(user)
    }

    /**2.2
     *Un metodo Post para inciar sesión (/v1/users/login)
     * Este endpoint recibe en el body un JSON con el campo mail y password. Únicamente debe de devolver (por ahora) un código 200 ok con la creación de un objeto Usuario.
     */
    @PostMapping("/login")
    fun loginUsuarios(@RequestBody usuarioBody: UsuarioBody): ResponseEntity<Usuario>{

        val usuario = Usuario(
            mail = usuarioBody.mail,
            password = usuarioBody.password,
        )
        return ResponseEntity.ok(usuario)
    }


    /**2.3
     *Un metodo Post para cerrar sesión (/v1/user/logout)
     * Este endpoint unicamente debe de devolver (por ahora) un código 200 ok  y un String con la frase "sesion cerrada"
     */
    @PostMapping("/logout")
    fun logoutUsuarios(): ResponseEntity<String>{
        return ResponseEntity.ok("Sesion cerrada")
    }

    /**2.3
     *Un metodo Get para obtener la información de un usuario (/v1/users/me)
     * Este endpoint unicamente debe de regresar un objeto Usuario con la información hardcodeada de un usuario.
     */
    @GetMapping("/me")
    fun getUsuario(): ResponseEntity<Usuario>{
        val usuario = Usuario(
            mail = "kkkk",
            password = "1234",
            token = "12345"
        )
        return ResponseEntity.ok(usuario)
    }

}
