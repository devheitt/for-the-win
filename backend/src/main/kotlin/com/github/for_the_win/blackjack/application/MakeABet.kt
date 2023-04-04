package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.*
import com.github.for_the_win.blackjack.domain.exceptions.GameNotFoundException

class MakeABet(
    private val repository: GameRepository,
) {

    fun invoke(gameId: GameId, playerId: PlayerId, amount: Money) {
        val game = repository.findById(gameId) ?: throw GameNotFoundException(gameId)
        game.placeABet(playerId, amount)
    }

}