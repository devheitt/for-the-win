package com.github.for_the_win.blackjack.domain

import com.github.for_the_win.blackjack.domain.exceptions.IllegalActionException
import com.github.for_the_win.blackjack.domain.exceptions.PlayerNotFoundException

class Game(val id: GameId, val players: Map<PlayerId, Player>) {
    var state: GameState

    init {
        val deck = Deck(2).apply { shuffle() }
        state = GameState(deck = deck)
    }

    companion object {
        fun create(gameId: GameId, players: List<Player>): Game {
            return Game(gameId, players.associateBy { it.id })
        }
    }

    fun placeABet(playerId: PlayerId, amount: Money) {
        val player = players[playerId] ?: throw PlayerNotFoundException()
        assertValidGameStage()
        player.bet(amount)
        state.bets[playerId] = amount
        if (state.bets.size == players.size)
            nextStage()
    }

    private fun assertValidGameStage() {
        if (state.stage != GameStage.WAITING_BETS) throw IllegalActionException()
    }

    private fun nextStage() {
        if (state.stage == GameStage.WAITING_BETS) {
            initGame()
        }

    }

    private fun croupierHasAs(): Boolean = state.croupierCards[1] is AS

    private fun initGame() {
        state.stage = GameStage.PLAYING
        state.croupierCards.add(state.deck.takeCard())
        players.values.forEach {
            it.cards.add(state.deck.takeCard())
        }
        state.croupierCards.add(state.deck.takeCard())
        players.values.forEach {
            it.cards.add(state.deck.takeCard())
        }
        if (state.croupierCards[1] is AS) {
            state.croupierCards[0].hidden = true
        }
    }

}

