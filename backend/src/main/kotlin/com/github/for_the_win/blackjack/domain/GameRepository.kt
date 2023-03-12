package com.github.for_the_win.blackjack.domain

interface GameRepository {
    fun findById(id: GameId): Game?
}