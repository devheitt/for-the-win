package com.github.for_the_win.blackjack.domain

import java.util.*

class GameId : EntityId {

    constructor(value: String): super(value)
    constructor(value: UUID): super(value)
}
