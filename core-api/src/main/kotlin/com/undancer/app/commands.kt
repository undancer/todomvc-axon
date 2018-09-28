package com.undancer.app

import org.axonframework.commandhandling.model.AggregateIdentifier

data class CreateTodo(
        @AggregateIdentifier
        var id: String,
        var text: String
)