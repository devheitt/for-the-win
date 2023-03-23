package com.github.for_the_win.blackjack.domain.exceptions

import com.github.for_the_win.blackjack.domain.GameId

class GameNotFoundException(gameId: GameId) : Throwable("Game not found with id: ${gameId.value}")
