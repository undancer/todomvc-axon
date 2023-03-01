package com.example.app.domain.api.events.`___`

import java.util.*

class UserRegistered(val userId: UUID, val email: String) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as UserRegistered
        return userId == that.userId && email == that.email
    }

    override fun hashCode(): Int {
        return Objects.hash(userId, email)
    }

    override fun toString(): String {
        return "CreateAccount{" +
                "accountID=" + userId +
                ", email='" + email + '\'' +
                '}'
    }
}
