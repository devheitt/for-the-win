package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.Game
import com.github.for_the_win.blackjack.domain.GameId
import com.github.for_the_win.blackjack.domain.Player

class StartGame {
    fun invoke(gameId: GameId, players: List<Player>): Game {
        return Game.create(gameId, players)
    }

}
