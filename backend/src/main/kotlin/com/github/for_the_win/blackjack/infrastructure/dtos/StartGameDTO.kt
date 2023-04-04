package com.github.for_the_win.blackjack.infrastructure.dtos

data class StartGameDTO(
    val gameId: String,
    val players: List<PlayerDTO>,
)