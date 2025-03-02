package com.propio.incidentes_api.user.controller

import com.propio.incidentes_api.user.controller.body.UserBody
import com.propio.incidentes_api.user.domain.UserD
import com.propio.incidentes_api.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/v1/users")

class UserController(val userService : UserService) {


    @PostMapping("/logout")
    fun logout(): ResponseEntity<Any> {
        val algo = userService.logout()
        return ResponseEntity.ok(algo)
    }


    @GetMapping("/all")
    fun allUsers(): ResponseEntity<Any> {
        val algo = userService.allUsers()
        return ResponseEntity.ok(algo)
    }

    @PostMapping("/create")
    fun addUser(@RequestBody userBody: UserBody): ResponseEntity<Any>{
        val usuario = UserD(mail = userBody.mail, password = userBody.password, token = userBody.token)
        val response = userService.addUser(usuario)
        return ResponseEntity.ok(response)

    }


}