package com.undancer.app.commands

import com.undancer.app.values.TodoId
import org.axonframework.commandhandling.TargetAggregateIdentifier

abstract class TodoCommand(
    @TargetAggregateIdentifier
    open val todoId: TodoId
)

abstract class TodoListCommand(
    override val todoId: TodoId
) : TodoCommand(todoId)


abstract class TodoItemCommand(
    override val todoId: TodoId
) : TodoCommand(todoId)

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
) : TodoItemCommand(todoId)

data class DestroyTodoItemCommand(
    override val todoId: TodoId,
    val id: Long
) : TodoItemCommand(todoId)

data class EditTodoItemCommand(
    override val todoId: TodoId,
    val id: Long,
    val title: String
) : TodoItemCommand(todoId)

data class ToggleTodoItemCommand(
    override val todoId: TodoId,
    val id: Long,
    val completed: Boolean
) : TodoItemCommand(todoId)
