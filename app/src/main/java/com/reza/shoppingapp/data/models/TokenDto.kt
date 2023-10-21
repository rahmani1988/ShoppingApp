package com.reza.shoppingapp.data.models

import com.squareup.moshi.Json

data class TokenDto(
    @field:Json(name = "token")
    val token: String?
)
