package com.reza.shoppingapp.util

import com.reza.shoppingapp.data.models.TokenDto
import java.util.Random


private val random = Random()

fun String.appendRandom() = "$this-${random.nextInt(10000)}"

fun randomInt() = Random().nextInt()

/**
 * A function to provide [TokenDto]
 *
 * @param token
 * @return [TokenDto]
 */
fun testTokenData(
    token: String = "token".appendRandom()
) = TokenDto(
    token = token
)