package com.undancer.app.commands

import com.undancer.app.values.TodoId
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