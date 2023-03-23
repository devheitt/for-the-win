package com.github.for_the_win.blackjack.infrastructure

import com.github.for_the_win.blackjack.domain.Game
import com.github.for_the_win.blackjack.domain.GameId
import com.github.for_the_win.blackjack.domain.GameRepository

class InMemoryGameRepository: GameRepository {

    private val games: MutableMap<GameId, Game> = mutableMapOf()
    override fun findById(id: GameId): Game? {
        return games[id]
    }
}