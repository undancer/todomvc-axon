//package com.example.app.web.___.controller
//
//import com.example.app.domain.api.commands.RegisterUserWithUniqueEmailAddress
//import com.example.app.domain.api.dto.RegisterUserDto
//import com.example.app.domain.api.dto.UpdateEmailFromUserDto
//import org.axonframework.commandhandling.gateway.CommandGateway
//import org.slf4j.LoggerFactory
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.PutMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RestController
//import java.lang.invoke.MethodHandles
//import java.util.*
//import java.util.concurrent.CompletableFuture
//
//@RestController
//class UserController(private val commandGateway: CommandGateway) {
//    @PostMapping(path = ["/users"])
//    fun register(@RequestBody registerUserDto: RegisterUserDto): CompletableFuture<Void> {
//        val generatedUserId = UUID.randomUUID()
//        logger.info("UUID [{}]", generatedUserId)
//        return commandGateway.send(
//            RegisterUserWithUniqueEmailAddress(
//                registerUserDto.getEmailAddress(),
//                generatedUserId
//            )
//        )
//    }
//
//    @PutMapping(path = ["/users"])
//    fun changeEmailAddress(@RequestBody updateEmailFromUserDto: UpdateEmailFromUserDto): CompletableFuture<Void> {
//        val generatedUserId = UUID.randomUUID()
//        commandGateway.sendAndWait(
//            RegisterUserWithUniqueEmailAddress(
//                updateEmailFromUserDto.getEmailAddress(),
//                generatedUserId
//            )
//        )
//        return commandGateway.send(
//            RemoveUserWithUniqueEmailAddress(
//                updateEmailFromUserDto.getFormerEmailAddress(),
//                updateEmailFromUserDto.getUserId()
//            )
//        )
//    }
//
//    companion object {
//        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
//    }
//}
