package com.propio.incidentes_api

data class UsuariosBody(
    val mail: String = "",
    val password: String = "",
    val token: String = "",
)
