package com.github.for_the_win.blackjack.domain

class Game(val id: GameId, val players: List<Player>) {
    val availableCards: Deck = Deck(2)

    init {
        availableCards.shuffle()
    }

    companion object {
        fun create(gameId: GameId, players: List<Player>): Game {
            return Game(gameId, players)
        }
    }

}
