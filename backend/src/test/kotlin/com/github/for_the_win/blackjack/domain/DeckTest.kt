package com.github.for_the_win.blackjack.domain

import com.github.for_the_win.blackjack.domain.exceptions.EmptyDeckException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun whenCreatingADeck_ShouldHave52Cards() {
        val newDeck = Deck()

        assertEquals(52, newDeck.cards.size)
    }

    @Test
    fun whenCreatingADeck_ShouldHave4AS() {
        val newDeck = Deck()

        assertEquals(4, newDeck.cards.filter { c -> c.label == "AS" }.toList().size)
    }

    @Test
    fun whenTakingACard_ShouldDecreaseTheDeckSize() {
        val newDeck = Deck()

        val initialSize = newDeck.size
        newDeck.takeCard()
        assertEquals(initialSize - 1, newDeck.size)
    }

    @Test()
    fun givenAnEmptyDeck_whenTakingACard_ShouldThrowEmptyDeckException() {
        val newDeck = Deck()

        val initialSize = newDeck.size

        for(i in 1..initialSize)
            newDeck.takeCard()

        assertThrows(EmptyDeckException::class.java) { newDeck.takeCard() }
    }

}