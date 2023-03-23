package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*


class StartGameTest {

    @Test
    fun whenStartingAGame_thenPlayersShouldHaveScoreZero() {
        val players = getMockPlayers()
        val newGame: Game = getNewGame(players)

        newGame.players.values.forEach { p ->
            Assertions.assertEquals(0, p.score.value)
        }

    }

    @Test
    fun whenStartingAGame_thenPlayersShouldHave200Cash() {
        val players = getMockPlayers()
        val newGame: Game = getNewGame(players)

        newGame.players.values.forEach { p ->
            Assertions.assertEquals(200, p.cash.value)
        }

    }

    @Test
    fun whenStartingAGame_thenShouldHave2FullDecks() {
        val players = getMockPlayers()
        val newGame: Game = getNewGame(players)

        val deckSize = 104

        Assertions.assertEquals(deckSize, newGame.availableCards.cards.size)
    }

    @Test
    fun whenStartingAGame_thenTheGameStageShouldBeInitialBet() {
        val players = getMockPlayers()
        val newGame: Game = getNewGame(players)

        Assertions.assertEquals(GameStage.INITIAL_BET, newGame.stage)
    }

    private fun getNewGame(
        players: List<Player>,
    ) = StartGame().invoke(GameId(UUID.randomUUID()), players)

    private fun getMockPlayers(): List<Player> {
        return listOf(
            Player(PlayerId(UUID.randomUUID()), PlayerName("Jon"), Money(200)),
            Player(PlayerId(UUID.randomUUID()), PlayerName("Doe"), Money(200))
        )
    }

}