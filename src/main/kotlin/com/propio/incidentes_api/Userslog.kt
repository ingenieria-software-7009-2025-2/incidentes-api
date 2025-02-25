package com.propio.incidentes_api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController {


    
    data class LoginRequest(
        val mail: String,
        val password: String  
    )

    @PostMapping("/login")
    fun loginUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<String> {
        // Lógica de autenticación
        return ResponseEntity.ok("Login exitoso")
    }
}