package com.github.for_the_win.blackjack.domain

class GameState(
    val bets: MutableMap<PlayerId, Money> = mutableMapOf(),
    val deck: Deck,
    val croupierCards: MutableList<Card> = mutableListOf(),
    val playerCards: MutableMap<PlayerId, MutableList<Card>> = mutableMapOf(),
    val discardedCards: MutableList<Card> = mutableListOf(),
    val turn: PlayerId? = null,
    var stage: GameStage = GameStage.WAITING_BETS
) {


}
