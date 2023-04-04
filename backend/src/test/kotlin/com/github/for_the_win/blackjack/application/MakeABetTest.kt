package com.github.for_the_win.blackjack.application

import com.github.for_the_win.blackjack.domain.*
import com.github.for_the_win.blackjack.domain.exceptions.NotEnoughMoneyException
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class MakeABetTest {

    private val player1 = Player(PlayerId(UUID.randomUUID()), PlayerName("Cris"), Money(200))
    private val player2 = Player(PlayerId(UUID.randomUUID()), PlayerName("Jon"), Money(200))
    private val testPlayers: List<Player> = listOf(player1, player2)
    private val repository: GameRepository = mockk()
    private lateinit var makeABet: MakeABet

    @BeforeEach
    fun setUp() {
        makeABet = MakeABet(repository)
    }

    @Test
    fun `when a player makes a bet then should reduce his cash`() {
        val testGame = Game.create(GameId(UUID.randomUUID()), testPlayers)
        every { repository.findById(testGame.id) } returns testGame

        makeABet.invoke(testGame.id, player1.id, Money(100))

        val expected = 100
        val actual = testGame.players[player1.id]!!.cash.value
        assertEquals(expected, actual)
    }

    @Test
    fun `given a player with 200 cash when makes a bet of 300 then should throw NotEnoughMoneyException`() {
        val testGame = Game.create(GameId(UUID.randomUUID()), testPlayers)
        every { repository.findById(testGame.id) } returns testGame

        assertThrows(NotEnoughMoneyException::class.java) { makeABet.invoke(testGame.id, player1.id, Money(300)) }

    }

    @Test
    fun `when every player makes a bet then should deal 2 cards to every one`() {
        val testGame = Game.create(GameId(UUID.randomUUID()), testPlayers)
        every { repository.findById(testGame.id) } returns testGame

        makeABet.invoke(testGame.id, player1.id, Money(100))
        makeABet.invoke(testGame.id, player2.id, Money(100))

        val actual = testGame.players[player1.id]!!.cards.size
        val actual2 = testGame.players[player1.id]!!.cards.size
        assertEquals(2, actual)
        assertEquals(2, actual2)
    }

}