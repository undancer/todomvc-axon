package com.undancer.app

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