package com.propio.incidentes_api.user.controller

import com.propio.incidentes_api.user.controller.body.LoginUserBody
import com.propio.incidentes_api.user.controller.body.UserBody
import com.propio.incidentes_api.user.domain.UserD
import com.propio.incidentes_api.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")

class UserController(val userService : UserService) {


    @PostMapping("/logout")
    fun logout(@RequestHeader("Authorization") token: String): ResponseEntity<String> {
        val successLogout = userService.logout(token)
        return if (!successLogout) {
            ResponseEntity.badRequest().build()
        } else {
            ResponseEntity.ok("Sesion finalizada")
        }
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

    @PostMapping("/login")
    fun login(@RequestBody loginUserBody: LoginUserBody): ResponseEntity<UserD>{
        val result = userService.login(loginUserBody.mail, loginUserBody.password)

        return if(result == null){
            ResponseEntity.notFound().build()
        } else{
            ResponseEntity.ok(result)
        }

    }

    @GetMapping("/me")
    fun me(@RequestHeader("Authorization") token: String): ResponseEntity<UserD>{
        val response = userService.getInfoAboutMe(token)
        return if(response != null) {
            ResponseEntity.ok(response)
        } else{
            ResponseEntity.status(401).build()
        }
    }




}