package com.example.app.domain.api.`___`

import org.axonframework.commandhandling.RoutingKey
import java.util.*

class RequestEmailChangeCommand(
    /**
     * Since this command is routed to a command handling component, the RoutingKey annotation is used. The
     * TargetAggregateIdentifier could also be used because that has the RoutingKey meta annotated
     */
    @field:RoutingKey val accountId: UUID,
    val updatedEmailAddress: String,
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as RequestEmailChangeCommand
        return accountId == that.accountId && updatedEmailAddress == that.updatedEmailAddress
    }

    override fun hashCode(): Int {
        return Objects.hash(accountId, updatedEmailAddress)
    }

    override fun toString(): String {
        return "RequestEmailChangeCommand{" +
                "accountId=" + accountId +
                ", updatedEmailAddress='" + updatedEmailAddress + '\'' +
                '}'
    }
}
