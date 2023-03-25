package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.*
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*


class StartGameTest {

    private val repository: GameRepository = mockk(relaxed = true)

    @Test
    fun whenStartingAGame_thenPlayersShouldHaveScoreZero() {
        val players = getMockPlayers()
        val newGame: Game = getNewGame(players)
        println("ID: ${newGame.id.value}")
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

        Assertions.assertEquals(deckSize, newGame.state.deck.cards.size)
    }

    @Test
    fun whenStartingAGame_thenTheGameStageShouldBeInitialBet() {
        val players = getMockPlayers()
        val newGame: Game = getNewGame(players)

        Assertions.assertEquals(GameStage.WAITING_BETS, newGame.state.stage)
    }

    @Test
    fun whenStartingAGame_thenTheGameShouldBeSaved() {
        val game = StartGame(repository).invoke(GameId(UUID.randomUUID()), getMockPlayers())

        verify(exactly = 1) { repository.save(game) }
    }

    private fun getNewGame(
        players: List<Player>,
    ) = StartGame(repository).invoke(GameId(UUID.randomUUID()), players)

    private fun getMockPlayers(): List<Player> {
        return listOf(
            Player(PlayerId(UUID.randomUUID()), PlayerName("Jon"), Money(200)),
            Player(PlayerId(UUID.randomUUID()), PlayerName("Doe"), Money(200))
        )
    }

}