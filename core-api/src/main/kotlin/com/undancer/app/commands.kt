package com.undancer.app.commands

import com.undancer.app.values.TodoId
import org.axonframework.commandhandling.TargetAggregateIdentifier

abstract class TodoListCommand(
        @TargetAggregateIdentifier
        open val todoId: TodoId
)

data class CreateTodoListCommand(
        override val todoId: TodoId
) : TodoListCommand(todoId)

data class ArchiveTodoListCommand(
        override val todoId: TodoId
) : TodoListCommand(todoId)

data class AddTodoItemCommand(
        override val todoId: TodoId,
        val title: String,
        val completed: Boolean = false
) : TodoListCommand(todoId)

data class DestroyTodoItemCommand(
        override val todoId: TodoId,
        val id: Long
) : TodoListCommand(todoId)

data class EditTodoItemCommand(
        override val todoId: TodoId,
        val id: Long,
        val title: String
) : TodoListCommand(todoId)

data class ToggleTodoItemCommand(
        override val todoId: TodoId,
        val id: Long,
        val completed: Boolean
) : TodoListCommand(todoId)