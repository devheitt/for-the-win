package com.github.for_the_win.blackjack.domain

import com.github.for_the_win.blackjack.domain.exceptions.EmptyDeckException

class Deck(numberOfDecks: Int = 1) {
    val size: Int
        get() = cards.size
    val cards: MutableList<Card> = mutableListOf()

    init {
        for(i in 1..numberOfDecks) {
            for (cardSuit in CardSuit.values()) {
                cards.add(AS(cardSuit))

                for (i in 2..10) {
                    cards.add(Card(cardSuit, i, i.toString()))
                }

                cards.add(Card(cardSuit, 10, "J"))
                cards.add(Card(cardSuit, 10, "Q"))
                cards.add(Card(cardSuit, 10, "K"))
            }
        }
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun takeCard(): Card {
        try {
            return cards.removeFirst()
        } catch (e: NoSuchElementException) {
            throw EmptyDeckException()
        }
    }

}