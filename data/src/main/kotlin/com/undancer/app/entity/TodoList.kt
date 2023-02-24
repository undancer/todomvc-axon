package com.undancer.app.entity

import com.google.common.collect.Lists
import jakarta.persistence.*

@Entity
@Table(name = "todo")
class TodoList(

    @Id
    var id: String,

    @ElementCollection
    @JoinTable(
        name = "todo_list",
        joinColumns = [JoinColumn(name = "todo_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "todo_item_id", referencedColumnName = "id")]
    )
    var list: List<TodoItem> = Lists.newArrayList()

)
