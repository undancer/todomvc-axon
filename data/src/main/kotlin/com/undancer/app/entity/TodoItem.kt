package com.undancer.app.entity

import javax.persistence.Basic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TodoItem {
    @Id
    @GeneratedValue
    var id: Long? = null
    @Basic
    var title: String? = null
    @Basic
    var compiled: Boolean? = null
}
