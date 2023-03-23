package com.github.for_the_win.blackjack.domain

import com.github.for_the_win.blackjack.domain.exceptions.IllegalActionException
import com.github.for_the_win.blackjack.domain.exceptions.PlayerNotFoundException

class Game(val id: GameId, val players: Map<PlayerId, Player>) {
    var stage: GameStage
    val availableCards: Deck = Deck(2)
    val bets: MutableMap<PlayerId, Money> = mutableMapOf()
    val croupierCards: MutableList<Card> = mutableListOf()

    init {
        availableCards.shuffle()
        stage = GameStage.INITIAL_BET
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
        bets[playerId] = amount
        if(bets.size == players.size)
            nextStage()
    }

    private fun assertValidGameStage() {
        if (stage != GameStage.INITIAL_BET) throw IllegalActionException()
    }

    private fun nextStage() {
        if(stage == GameStage.INITIAL_BET) {
            initGame()
        }

    }

    private fun initGame() {
        stage = GameStage.ON_GOING
        croupierCards.add(availableCards.takeCard())
        players.values.forEach{
            it.cards.add(availableCards.takeCard())
        }
        croupierCards.add(availableCards.takeCard())
        players.values.forEach{
            it.cards.add(availableCards.takeCard())
        }
        println(croupierCards)
    }

}

