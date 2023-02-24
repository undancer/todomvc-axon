package com.undancer.app.entity

import jakarta.persistence.Basic
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.apache.commons.lang3.builder.ToStringBuilder

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
