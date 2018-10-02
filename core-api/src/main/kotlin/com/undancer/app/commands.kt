package com.undancer.app

import org.axonframework.commandhandling.TargetAggregateIdentifier

data class CreateTodoCommand(
        @TargetAggregateIdentifier
        val id: TodoId,
        val title: String
)

data class ChangeTodoTitleCommand(
        @TargetAggregateIdentifier
        val id: TodoId,
        val title: String
)

data class DeleteTodoCommand(
        @TargetAggregateIdentifier
        val id: TodoId
)