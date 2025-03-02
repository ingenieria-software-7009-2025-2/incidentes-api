package com.propio.incidentes_api.user.service
import com.propio.incidentes_api.user.domain.UserD
import com.propio.incidentes_api.user.repository.entity.User
import com.propio.incidentes_api.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private var userRepository: UserRepository) {

    fun logout(): String {
        return "Sesion cerrada"
    }

    fun allUsers(): List<UserD> {
        // Muestra todos los usuarios de la base
        val myUsers = mutableListOf<UserD>()
        val result = userRepository.findAll()
        result.forEach{ user ->
            val userFound = UserD(
                mail = user.mail,
                password = user.password,
                token = user.token
            )
            myUsers.add(userFound)
        }

        return myUsers
    }

    fun addUser(usuario: UserD): UserD {

        val usuarioDB =
            User(mail = usuario.mail, password = usuario.password, token = usuario.token)

        val result = userRepository.save(usuarioDB)

        val usuarioCreado = UserD(
            mail = result.mail,
            token = result.token,
            password = result.password,
        )
        return usuarioCreado
    }



}