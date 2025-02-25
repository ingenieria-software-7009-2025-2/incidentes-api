package com.propio.incidentes_api

data class UsuarioBody(
    val mail: String = "",
    val password: String = "",
    val token: String = "",
)
