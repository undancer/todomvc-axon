package com.undancer.app.entity.jpa

import com.undancer.app.entity.TodoList
import org.springframework.data.jpa.repository.JpaRepository

interface TodoListJpaRepository : JpaRepository<TodoList, String> {
    fun findTodoListById(id: String): TodoList
}