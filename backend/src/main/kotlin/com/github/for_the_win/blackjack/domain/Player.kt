package com.github.for_the_win.blackjack.domain

class Player(val name: PlayerName, val cash: PlayerCash) {
    val score: Score = Score(0)
}
