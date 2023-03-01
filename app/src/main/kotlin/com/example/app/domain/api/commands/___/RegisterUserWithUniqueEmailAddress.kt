package com.example.app.domain.api.commands.`___`

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

class RegisterUserWithUniqueEmailAddress(@field:TargetAggregateIdentifier val email: String, val userId: UUID) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as RegisterUserWithUniqueEmailAddress
        return email == that.email && userId == that.userId
    }

    override fun hashCode(): Int {
        return Objects.hash(email, userId)
    }

    override fun toString(): String {
        return "CreateAccountWithUniqueEmailAddress{" +
                "email='" + email + '\'' +
                ", accountID=" + userId +
                '}'
    }
}
