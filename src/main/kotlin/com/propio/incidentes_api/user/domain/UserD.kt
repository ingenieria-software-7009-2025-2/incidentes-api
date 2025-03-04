package com.propio.incidentes_api.user.domain

data class UserD(
    val id: String? = null,
    val mail: String,
    val password: String,
    var token: String? = null,
)