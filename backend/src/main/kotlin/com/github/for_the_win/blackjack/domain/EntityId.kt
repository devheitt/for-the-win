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

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EntityId

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}