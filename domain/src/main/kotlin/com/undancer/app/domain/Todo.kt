package com.undancer.app.domain

import com.undancer.app.commands.ChangeTodoTitleCommand
import com.undancer.app.commands.CreateTodoCommand
import com.undancer.app.commands.DeleteTodoCommand
import com.undancer.app.evnets.ChangedTodoTitleEvent
import com.undancer.app.evnets.CreatedTodoEvent
import com.undancer.app.evnets.DeletedTodoEvent
import com.undancer.app.values.TodoId
import org.apache.commons.lang3.builder.ToStringBuilder
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Todo {

    @AggregateIdentifier
    var id: TodoId? = null

    var title: String? = null

    val completed: Boolean = false

    constructor() {
    }

    @CommandHandler
    constructor(command: CreateTodoCommand) {
//        apply(CreatedTodoEvent(command.id, command.title), MetaData.with("name", "undancer"));
        apply(CreatedTodoEvent(command.id, command.title))
    }

    @CommandHandler
    fun on(command: ChangeTodoTitleCommand) {
        println(this)
        println(command)
        apply(ChangedTodoTitleEvent(command.id, command.title))
    }

    @CommandHandler
    fun on(command: DeleteTodoCommand) {
        apply(DeletedTodoEvent(command.id))
    }

    @EventSourcingHandler
    fun on(event: CreatedTodoEvent) {
        this.id = event.id
        this.title = event.title
    }

    @EventSourcingHandler
    fun on(event: ChangedTodoTitleEvent) {
        println("event -> $event")
        this.title = title
    }

    @EventSourcingHandler
    fun on(event: DeletedTodoEvent) {
        println("删除聚合根？？？")
    }

    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this)
    }
}