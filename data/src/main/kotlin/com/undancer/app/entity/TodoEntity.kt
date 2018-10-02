package com.undancer.app.entity

import org.apache.commons.lang3.builder.ToStringBuilder

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class TodoEntity(
        @Id
        var id: String,
        var title: String
) {
    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this)
    }
}