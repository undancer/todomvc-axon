//package com.example.app.web.___.interceptor
//
//import com.example.app.domain.api.CreateAccountCommand
//import com.example.app.samples.command.persistence.EmailRepository
//import org.axonframework.commandhandling.CommandMessage
//import org.axonframework.messaging.MessageDispatchInterceptor
//import org.springframework.stereotype.Component
//import java.lang.String
//import java.util.function.BiFunction
//
///**
// * Intercepts the create account command message and throws IllegalStateException when already account aggregate with
// * email address already exists. Links to "Validation through a Dispatch Interceptor' section in in this [set based
// * validation blog](https://axoniq.io/blog-overview/set-based-validation)
// *
// * @author Yvonne Ceelie
// */
//@Component
//class AccountCreationDispatchInterceptor(emailRepository: EmailRepository) :
//    MessageDispatchInterceptor<CommandMessage<*>> {
//    private val emailRepository: EmailRepository
//
//    init {
//        this.emailRepository = emailRepository
//    }
//
//    override fun handle(list: List<CommandMessage<*>>): BiFunction<Int, CommandMessage<*>, CommandMessage<*>> {
//        return BiFunction<Int, CommandMessage<*>, CommandMessage<*>> { i: Int?, m: CommandMessage<*> ->
//            if (CreateAccountCommand::class.java == m.payloadType) {
//                val createAccountCommand: CreateAccountCommand = m.payload as CreateAccountCommand
//                check(!emailRepository.existsById(createAccountCommand.getEmailAddress())) {
//                    String.format(
//                        "Account with email address %s already exists",
//                        createAccountCommand.getEmailAddress()
//                    )
//                }
//            }
//            m
//        }
//    }
//}
