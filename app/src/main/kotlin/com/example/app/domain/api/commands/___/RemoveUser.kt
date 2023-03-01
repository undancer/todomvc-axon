package com.example.app.domain.api.commands.`___`

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

class RemoveUser(@field:TargetAggregateIdentifier val userId: UUID) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as RemoveUser
        return userId == that.userId
    }

    override fun hashCode(): Int {
        return Objects.hash(userId)
    }
}
