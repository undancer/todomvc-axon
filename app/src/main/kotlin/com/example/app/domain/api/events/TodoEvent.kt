package com.example.app.domain.api.events

import com.example.app.domain.api.values.TodoId
import org.axonframework.modelling.command.TargetAggregateIdentifier


abstract class TodoEvent(
    @TargetAggregateIdentifier
    open val todoId: TodoId,
)

abstract class TodoListEvent(
    override val todoId: TodoId,
) : TodoEvent(todoId)

abstract class TodoItemEvent(
    override val todoId: TodoId,
) : TodoEvent(todoId)

data class CreatedTodoListEvent(
    override val todoId: TodoId,
) : TodoListEvent(todoId)

data class ArchivedTodoListEvent(
    override val todoId: TodoId,
) : TodoListEvent(todoId)

data class AddedTodoItemEvent(
    override val todoId: TodoId,
    val title: String,
    val completed: Boolean = false,
) : TodoItemEvent(todoId)

data class DestroyedTodoItemEvent(
    override val todoId: TodoId,
    val id: Long,
) : TodoItemEvent(todoId)

data class EditedTodoItemEvent(
    override val todoId: TodoId,
    val id: Long,
    val title: String,
) : TodoItemEvent(todoId)

data class ToggledTodoItemEvent(
    override val todoId: TodoId,
    val id: Long,
    val completed: Boolean,
) : TodoItemEvent(todoId)

