package com.github.for_the_win.blackjack.domain

import com.github.for_the_win.blackjack.domain.exceptions.NotEnoughMoneyException
import java.util.*

class PlayerId : EntityId {
    constructor(value: String) : super(value)
    constructor(value: UUID) : super(value)
}

data class Money(val value: Int) {
    init {
        if (this.value < 0) throw Exception()
    }

    fun plus(money: Money): Money {
        return Money(this.value + money.value)
    }

    fun minus(money: Money): Money {
        return Money(this.value - money.value)
    }
}

data class PlayerName(val value: String) {}
data class PlayerScore(val value: Int) {}
data class Player(val id: PlayerId, val name: PlayerName, var cash: Money) {
    val score: PlayerScore = PlayerScore(0)
    val cards: MutableList<Card> = mutableListOf()
    private var cashBet: Money = Money(0)

    fun bet(bet: Money) {
        if (bet.value > cash.value)
            throw NotEnoughMoneyException()

        cash = cash.minus(bet)
        cashBet = cashBet.plus(bet)
    }

}

