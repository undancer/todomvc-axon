package com.example.app.domain.api.`___`

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

class ChangeEmailAddressCommand(
    @field:TargetAggregateIdentifier
    val accountId: UUID,
    val updatedEmailAddress: String,
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as ChangeEmailAddressCommand
        return accountId == that.accountId && updatedEmailAddress == that.updatedEmailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(accountId, updatedEmailAddress)
    }

    override fun toString(): String {
        return "ChangeEmailAddressCommand{" +
                "accountId=" + accountId +
                ", updatedEmailAddress='" + updatedEmailAddress + '\'' +
                '}'
    }
}
