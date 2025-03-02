package com.propio.incidentes_api.user.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "tb_user", schema = "schema_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val mail: String = "",

    @Column(nullable = false)
    val password: String = "",

    @Column(nullable = false)
    val token: String = ""
)


