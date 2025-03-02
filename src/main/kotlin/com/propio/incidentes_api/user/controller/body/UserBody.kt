package com.propio.incidentes_api.user.controller.body

data class UserBody(
    val mail: String = "",
    val password: String = "",
    val token: String = "",
)