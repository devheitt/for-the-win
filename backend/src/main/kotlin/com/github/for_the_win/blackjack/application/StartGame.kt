package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.Game
import com.github.for_the_win.blackjack.domain.GameId
import com.github.for_the_win.blackjack.domain.GameRepository
import com.github.for_the_win.blackjack.domain.Player
import org.springframework.stereotype.Service

@Service
class StartGame(private val repository: GameRepository) {
    fun invoke(gameId: GameId, players: List<Player>): Game {

        return Game.create(gameId, players).also { repository.save(it) }
    }

}
