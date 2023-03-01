package com.example.app.domain.api.`___`

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class AccountCreatedEvent(
    @param:JsonProperty("accountId") val accountId: UUID,
    @param:JsonProperty("emailAddress") val emailAddress: String,
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as AccountCreatedEvent
        return accountId == that.accountId && emailAddress == that.emailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(accountId, emailAddress)
    }

    override fun toString(): String {
        return "AccountCreatedEvent{" +
                "accountId=" + accountId +
                ", emailAddress='" + emailAddress + '\'' +
                '}'
    }
}
