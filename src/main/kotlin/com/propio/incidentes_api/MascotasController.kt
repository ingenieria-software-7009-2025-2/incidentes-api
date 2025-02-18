package com.propio.incidentes_api

import jakarta.annotation.PostConstruct
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@RestController
@RequestMapping("/v1/mascotas")
public class MascotasController {

    @GetMapping
    fun retriveMascotas(): ResponseEntity<Mascotas> {

        val miMascotas = Mascotas( tipo = "perro", name = "Firulais", peso = "10kg")
        return ResponseEntity.ok(miMascotas)
    }

    /*
    No se pueden dejar dos "@PostMapping" en el mismo controlador ya que se genera un error de compilación.
    Solo se puede tener un "@PostMapping" en un controlador para que no haya errores en compilación.

    En este caso quitamos el retriveMascotas" y dejamos el "crateMasctoas" para que jale, es decir en postamn en la
    parte de body y luego en raw, en un formato json ponemos la informacion que queramos de acuerdo a la estructura
    de la clase que hicimos

    @PostMapping
    fun retriveMascotas1(): ResponseEntity<Mascotas> {
        val miMascotas = Mascotas( tipo = "gato", name = "Michi", peso = "5kg")
        return ResponseEntity.ok(miMascotas)
    }
    */

    @PostMapping
    fun createMascotas(@RequestBody mascotaBody: MascotaBody): ResponseEntity<Mascotas> {

        val miMascotas = Mascotas(
            tipo = mascotaBody.tipo,
            name = mascotaBody.name,
            peso = mascotaBody.peso
        )

        return ResponseEntity.ok(miMascotas)
    }
}
