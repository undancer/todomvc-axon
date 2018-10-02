package com.undancer.app.entity

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class TodoList(
        @Id
        var id: String,
        @ElementCollection
        var list: List<TodoItem>
)
