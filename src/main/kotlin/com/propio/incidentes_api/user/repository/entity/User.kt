package com.propio.incidentes_api.user.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "tb_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    var mail: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = true)
    var token: String? = ""
)


