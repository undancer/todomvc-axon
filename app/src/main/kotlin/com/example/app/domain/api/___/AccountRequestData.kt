package com.example.app.domain.api.`___`

import java.util.*

class AccountRequestData {
    var emailAddress: String? = null

    constructor(emailAddress: String?) {
        this.emailAddress = emailAddress
    }

    constructor()

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as AccountRequestData
        return emailAddress == that.emailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(emailAddress)
    }

    override fun toString(): String {
        return "AccountRequestData{" +
                "emailAddress='" + emailAddress + '\'' +
                '}'
    }
}
