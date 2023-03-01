//package com.example.app.samples.controller
//
//import com.example.app.domain.api.AccountRequestData
//import com.example.app.domain.api.ChangeEmailAddressCommand
//import com.example.app.domain.api.CreateAccountCommand
//import com.example.app.domain.api.RequestEmailChangeCommand
//import org.axonframework.commandhandling.gateway.CommandGateway
//import org.springframework.web.bind.annotation.*
//import java.util.*
//import java.util.concurrent.CompletableFuture
//
//@RestController
//class AccountController(private val commandGateway: CommandGateway) {
//    @PostMapping(path = ["/accounts"])
//    fun register(@RequestBody accountRequestData: AccountRequestData): CompletableFuture<Void> {
//        val accountId = UUID.randomUUID()
//        return commandGateway.send(CreateAccountCommand(accountId, accountRequestData.getEmailAddress()))
//    }
//
//    @PutMapping(path = ["/accounts/{accountId}/requestUpdateEmailAddress"])
//    fun requestUpdateEmailAddress(
//        @RequestBody accountRequestData: AccountRequestData,
//        @PathVariable("accountId") accountId: UUID?,
//    ): CompletableFuture<Void> {
//        return commandGateway.send(RequestEmailChangeCommand(accountId, accountRequestData.getEmailAddress()))
//    }
//
//    @PutMapping(path = ["/accounts/{accountId}/updateEmailAddress"])
//    fun updateEmailAddress(
//        @RequestBody accountRequestData: AccountRequestData,
//        @PathVariable("accountId") accountId: UUID?,
//    ): CompletableFuture<Void> {
//        return commandGateway.send(ChangeEmailAddressCommand(accountId, accountRequestData.getEmailAddress()))
//    }
//}
