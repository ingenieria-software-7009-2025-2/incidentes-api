package com.propio.incidentes_api.user.service
import com.propio.incidentes_api.user.controller.body.UpdateUserBody
import com.propio.incidentes_api.user.domain.UserD
import com.propio.incidentes_api.user.repository.entity.User
import com.propio.incidentes_api.user.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private var userRepository: UserRepository) {

    fun logout(token: String): Boolean {
        val userFound = userRepository.findByToken(token)

        if (userFound != null) {
            userFound.token = null
            userRepository.save(userFound)
            return true
        }

        return false
    }


    fun allUsers(): List<UserD> {
        val myUsers = mutableListOf<UserD>()
        val result = userRepository.findAll()
        result.forEach{ user ->
            val userFound = UserD(
                id = user.id.toString(),
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
            id = result.id.toString(),
            mail = result.mail,
            token = result.token,
            password = result.password,
        )
        return usuarioCreado
    }

    fun login(mail: String, password: String): UserD? {
        val userFound = userRepository.findByEmailAndPassword(mail, password)

        if (userFound != null) {
            val token = UUID.randomUUID().toString()
            updateTokenUser(userFound, token)
            return UserD(
                id = userFound.id.toString(),
                mail = userFound.mail,
                password = userFound.password,
                token = token
            )
        }

        return null
    }

    fun updateTokenUser(user: User, token: String){
        user.token = token
        userRepository.save(user)
    }

    fun getInfoAboutMe(token: String): UserD?{
        val userFound = userRepository.findByToken(token)

        if(userFound!= null){
            return UserD(
                id = userFound.id.toString(),
                mail = userFound.mail,
                password = userFound.password,
                token = "******"
            )
        }

        return null
    }

    fun updateUser(token: String, updateData: UpdateUserBody): UserD? {
        val userFound = userRepository.findByToken(token)

        if (userFound != null){
            updateData.mail?.let { userFound.mail = it }
            updateData.password?.let { userFound.password = it }

            val updateUser = userRepository.save(userFound)

            return UserD(
                id = updateUser.id.toString(),
                mail = updateUser.mail,
                password = updateUser.password,
                token = updateUser.token
            )
        }
        return null
    }





}