package com.undancer.app.querys

import com.undancer.app.values.TodoId
import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class TodoItemQuery(@TargetAggregateIdentifier open val id: TodoId)

class FindTodoItemQuery(
    override val id: TodoId
) : TodoItemQuery(id)
