package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.GameId
import com.github.for_the_win.blackjack.domain.GameRepository
import com.github.for_the_win.blackjack.domain.GameState
import com.github.for_the_win.blackjack.domain.exceptions.GameNotFoundException
import org.springframework.stereotype.Service

@Service
class GetGameState(private val repository: GameRepository) {
    fun invoke(id: GameId): GameState {
        val game = repository.findById(id) ?: throw GameNotFoundException(id)
        return game.state
    }

}