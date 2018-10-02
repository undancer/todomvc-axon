package com.undancer.app.evnets

import com.undancer.app.values.TodoId

data class CreatedTodoEvent(
        val id: TodoId,
        val title: String
)

data class ChangedTodoTitleEvent(
        val id: TodoId,
        val title: String
)

data class DeletedTodoEvent(
        val id: TodoId
)