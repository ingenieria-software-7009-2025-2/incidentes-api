package com.propio.incidentes_api.user.repository

import com.propio.incidentes_api.user.repository.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM tb_user WHERE mail=?1", nativeQuery = true)
    fun findByEmail(mail: String): User?

    @Query(value = "SELECT * FROM tb_user WHERE mail=?1 AND password=?2", nativeQuery = true)
    fun findByEmailAndPassword(mail: String, password: String): User?

    @Query(value = "SELECT * FROM tb_user WHERE token=?1", nativeQuery = true)
    fun findByToken(token: String): User?
}

