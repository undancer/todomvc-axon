package com.undancer.app.domain

import com.undancer.app.commands.*
import com.undancer.app.evnets.*
import com.undancer.app.values.TodoId
import org.axonframework.commandhandling.CommandHandler
//import org.axonframework.commandhandling.model.AggregateIdentifier
//import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle.apply
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class TodoList {

    @AggregateIdentifier
    lateinit var id: TodoId

    var archived: Boolean = false

    constructor() {}

    @CommandHandler
    constructor(command: CreateTodoListCommand) {
        apply(CreatedTodoListEvent(command.todoId))
    }

    @EventSourcingHandler
    fun on(event: CreatedTodoListEvent) {
        this.id = event.todoId
    }

    @CommandHandler
    fun on(command: AddTodoItemCommand) {
        apply(AddedTodoItemEvent(command.todoId, command.title))
    }

    @CommandHandler
    fun on(command: EditTodoItemCommand) {
        apply(EditedTodoItemEvent(command.todoId, command.id, command.title))
    }

    @CommandHandler
    fun on(command: ToggleTodoItemCommand) {
        apply(ToggledTodoItemEvent(command.todoId, command.id, command.completed))
    }

    @CommandHandler
    fun on(command: ArchiveTodoListCommand) {
        apply(ArchivedTodoListEvent(command.todoId))
    }

    @EventSourcingHandler
    fun on(event: ArchivedTodoListEvent) {
        this.archived = true
    }

    @CommandHandler
    fun on(command: DestroyTodoItemCommand) {
        apply(DestroyedTodoItemEvent(command.todoId, command.id))
    }
}
