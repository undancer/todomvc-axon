package com.undancer.app.entity

import javax.persistence.Basic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TodoItem(
        @Id
        @GeneratedValue
        var id: Long,
        @Basic
        var title: String,
        @Basic
        var completed: Boolean
)