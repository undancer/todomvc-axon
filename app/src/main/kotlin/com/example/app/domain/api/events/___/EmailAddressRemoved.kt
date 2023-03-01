package com.example.app.domain.api.events.`___`

import java.util.*

class EmailAddressRemoved(val emailAddress: String, val userId: UUID) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as EmailAddressRemoved
        return emailAddress == that.emailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(emailAddress)
    }

    override fun toString(): String {
        return "EmailAddressRemoved{" +
                "emailAddress='" + emailAddress + '\'' +
                '}'
    }
}
