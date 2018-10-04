package com.undancer.app.evnets

import com.undancer.app.values.TodoId
import org.axonframework.commandhandling.TargetAggregateIdentifier


abstract class TodoListEvent(
        @TargetAggregateIdentifier
        open val todoId: TodoId
)

data class CreatedTodoListEvent(
        override val todoId: TodoId
) : TodoListEvent(todoId)

data class ArchivedTodoListEvent(
        override val todoId: TodoId
) : TodoListEvent(todoId)

data class AddedTodoItemEvent(
        override val todoId: TodoId,
        val title: String,
        val completed: Boolean = false
) : TodoListEvent(todoId)

data class DestroyedTodoItemEvent(
        override val todoId: TodoId,
        val id: Long
) : TodoListEvent(todoId)

data class EditedTodoItemEvent(
        override val todoId: TodoId,
        val id: Long,
        val title: String
) : TodoListEvent(todoId)

data class ToggledTodoItemEvent(
        override val todoId: TodoId,
        val id: Long,
        val completed: Boolean
) : TodoListEvent(todoId)