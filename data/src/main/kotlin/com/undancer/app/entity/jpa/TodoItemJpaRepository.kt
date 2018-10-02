package com.undancer.app.entity.jpa

import com.undancer.app.entity.TodoItem
import org.springframework.data.jpa.repository.JpaRepository

interface TodoItemJpaRepository : JpaRepository<TodoItem, Long>