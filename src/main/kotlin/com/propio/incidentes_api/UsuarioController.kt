package com.propio.incidentes_api

import jakarta.annotation.PostConstruct
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/v1/usuarios")
class UsuarioController {

        @PostMapping("/logout")
        fun logout(): ResponseEntity<String> {
            return ResponseEntity.ok("sesion cerrada")
        }


}