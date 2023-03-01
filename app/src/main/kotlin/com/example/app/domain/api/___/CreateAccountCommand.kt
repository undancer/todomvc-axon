package com.example.app.domain.api.`___`

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

class CreateAccountCommand(@field:TargetAggregateIdentifier val accountId: UUID, val emailAddress: String) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as CreateAccountCommand
        return accountId == that.accountId && emailAddress == that.emailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(accountId, emailAddress)
    }

    override fun toString(): String {
        return "CreateAccountCommand{" +
                "accountId=" + accountId +
                ", emailAddress='" + emailAddress + '\'' +
                '}'
    }
}
