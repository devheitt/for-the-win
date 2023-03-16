package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*


class StartGameTest {

    @Test
    fun whenStartingAGame_thenPlayersShouldHaveScoreZero() {
        val players = getMockPlayers()
        val testGameId = GameId(UUID.randomUUID())
        val newGame: Game = StartGame().invoke(testGameId, players)

        newGame.players.forEach { p ->
            Assertions.assertEquals(0, p.score.value)
        }

    }

    @Test
    fun whenStartingAGame_thenPlayersShouldHave200Cash() {
        val players = getMockPlayers()
        val testGameId = GameId(UUID.randomUUID())
        val newGame: Game = StartGame().invoke(testGameId, players)

        newGame.players.forEach { p ->
            Assertions.assertEquals(200, p.cash.value)
        }

    }

    @Test
    fun whenStartingAGame_thenShouldHave2FullDecks() {
        val players = getMockPlayers()
        val testGameId = GameId(UUID.randomUUID())
        val newGame: Game = StartGame().invoke(testGameId, players)

        val deckSize = 104

        Assertions.assertEquals(deckSize, newGame.availableCards.cards.size)
    }

    private fun getMockPlayers(): List<Player> {
        return listOf(Player(PlayerName("Jon"), PlayerCash(200)), Player(PlayerName("Doe"), PlayerCash(200)))
    }

}