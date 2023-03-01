package com.example.app.domain.api.events.`___`

import java.util.*

class UserRemoved(val userId: UUID) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as UserRemoved
        return userId == that.userId
    }

    override fun hashCode(): Int {
        return Objects.hash(userId)
    }

    override fun toString(): String {
        return "UserRemoved{" +
                "userId=" + userId +
                '}'
    }
}
