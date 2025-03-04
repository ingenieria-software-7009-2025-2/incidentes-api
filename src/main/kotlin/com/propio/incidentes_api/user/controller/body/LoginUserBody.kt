package com.propio.incidentes_api.user.controller.body

data class LoginUserBody(
    val mail: String,
    val password: String
)