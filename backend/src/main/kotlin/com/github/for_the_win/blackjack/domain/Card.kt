package com.github.for_the_win.blackjack.domain

enum class CardSuit {
    HEARTS,
    DIAMONDS,
    CLOVERS,
    PIKES
}

open class Card(val suit:CardSuit, val value: Int, val label: String) {
    var hidden: Boolean = false

    override fun toString(): String {
        return "Card(suit=$suit, value=$value, label='$label')"
    }
}

data class AS(val cardSuit: CardSuit) : Card(cardSuit, 1, "AS") {
    val secondValue
        get()= 11
}