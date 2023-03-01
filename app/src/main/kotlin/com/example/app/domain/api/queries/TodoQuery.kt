package com.example.app.domain.api.queries

import com.example.app.domain.api.values.TodoId
import org.axonframework.modelling.command.TargetAggregateIdentifier

class TodoQuery


abstract class TodoItemQuery(
    @TargetAggregateIdentifier
    open val id: TodoId,
)

class FindTodoItemQuery(
    override val id: TodoId,
) : TodoItemQuery(id)
