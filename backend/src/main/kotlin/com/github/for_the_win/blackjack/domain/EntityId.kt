package com.github.for_the_win.blackjack.domain

import java.util.UUID

open class EntityId(val value: UUID) {

    constructor(value: String) : this(UUID.fromString(value))

    companion object {
        fun fromValue(value: String): EntityId {
            return EntityId(UUID.fromString(value))
        }

        fun new(): EntityId {
            return EntityId(UUID.randomUUID())
        }
    }

}