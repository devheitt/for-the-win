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
        val newGame: Game = StartGame().invoke(testGameId,players)

        newGame.players.forEach { p ->
            Assertions.assertEquals(0, p.score.value)
        }

    }

    private fun getMockPlayers(): List<Player> {
        return listOf(Player(PlayerName("Jon")), Player(PlayerName("Doe")))
    }

}