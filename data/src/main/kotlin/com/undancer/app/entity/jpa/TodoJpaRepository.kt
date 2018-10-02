package com.undancer.app.entity.jpa

import com.undancer.app.entity.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository


interface TodoJpaRepository : JpaRepository<TodoEntity, String> {

    fun findTodoById(id: String): TodoEntity
}