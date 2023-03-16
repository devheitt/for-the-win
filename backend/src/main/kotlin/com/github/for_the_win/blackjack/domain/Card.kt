package com.github.for_the_win.blackjack.domain

open class Card(val suit:CardSuit, val value: Int, val label: String) {}

data class AS(val cardSuit: CardSuit) : Card(cardSuit, 1, "AS") {
    val secondValue
        get()= 11
}