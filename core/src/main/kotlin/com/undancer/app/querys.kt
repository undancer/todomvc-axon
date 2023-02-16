package com.undancer.app.querys

import com.undancer.app.values.TodoId
import org.axonframework.commandhandling.TargetAggregateIdentifier

abstract class TodoItemQuery(@TargetAggregateIdentifier open val id: TodoId)

class FindTodoItemQuery(
    override val id: TodoId
) : TodoItemQuery(id)
