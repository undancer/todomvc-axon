package com.undancer.app.entity

import org.apache.commons.lang3.builder.ToStringBuilder
import javax.persistence.Basic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TodoItem(
        @Id
        @GeneratedValue
        var id: Long = 0,
        @Basic
        var title: String,
        @Basic
        var completed: Boolean = false
) {
    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this)
    }
}