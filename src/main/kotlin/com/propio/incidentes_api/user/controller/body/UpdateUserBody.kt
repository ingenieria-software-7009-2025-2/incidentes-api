package com.propio.incidentes_api.user.controller.body

data class UpdateUserBody(
    val mail: String? = null,
    val password: String? = null
)
