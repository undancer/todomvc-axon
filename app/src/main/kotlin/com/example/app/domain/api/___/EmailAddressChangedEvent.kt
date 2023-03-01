package com.example.app.domain.api.`___`

import java.util.*

class EmailAddressChangedEvent(val accountId: UUID, val emailAddress: String) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as EmailAddressChangedEvent
        return accountId == that.accountId && emailAddress == that.emailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(accountId, emailAddress)
    }

    override fun toString(): String {
        return "EmailAddressChangedEvent{" +
                "accountId=" + accountId +
                ", emailAddress='" + emailAddress + '\'' +
                '}'
    }
}
