package com.github.for_the_win.blackjack.infrastructure.dtos

data class PlayerDTO(
    val id: String,
    val name: String,
    val cash: Int,
)