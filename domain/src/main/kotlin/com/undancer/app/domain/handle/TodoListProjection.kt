package com.undancer.app.domain.handle

import com.undancer.app.entity.TodoItem
import com.undancer.app.entity.TodoList
import com.undancer.app.entity.jpa.TodoItemJpaRepository
import com.undancer.app.entity.jpa.TodoListJpaRepository
import com.undancer.app.evnets.*
import com.undancer.app.querys.FindTodoItemQuery
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TodoListProjection {

    @Autowired
    lateinit var todoListJpaRepository: TodoListJpaRepository
    @Autowired
    lateinit var todoItemJpaRepository: TodoItemJpaRepository

    @QueryHandler
    fun on(query: FindTodoItemQuery): List<TodoItem> {
        var todoList = todoListJpaRepository.findTodoListById(query.id.identifier)
        return todoList.list
    }

    @EventHandler
    fun on(event: CreatedTodoListEvent) {
        var obj: TodoList = TodoList(event.todoId.identifier)
        obj.save()
    }

    @EventHandler
    fun on(event: AddedTodoItemEvent) {
        event.toTodoList().apply {
            this.list += TodoItem(title = event.title, completed = event.completed).save()
        }.save()
    }

    @EventHandler
    fun on(event: EditedTodoItemEvent) {
        event.toTodoList()
                .apply {
                    this.list
                            .find { it -> event.id == it.id }
                            .apply { this?.title = event.title }
                }
                .save()
    }

    @EventHandler
    fun on(event: ToggledTodoItemEvent) {
        event.toTodoList()
                .apply {
                    this.list
                            .find { it -> event.id == it.id }
                            .apply { this?.completed = event.completed }
                }
                .save()
    }

    @EventHandler
    fun on(event: DestroyedTodoItemEvent) {
        event.toTodoList().apply {
            this.list
                    .filter { it -> event.id == it.id }
                    .forEach { it ->
                        this.list -= it.delete()
                    }
        }.save()
    }

    fun TodoListEvent.toTodoList(): TodoList {
        return todoListJpaRepository.findTodoListById(this.todoId.identifier)
    }

    fun TodoItem.save(): TodoItem {
        return todoItemJpaRepository.save(this)
    }

    fun TodoList.save(): TodoList {
        return todoListJpaRepository.save(this)
    }

    fun TodoItem.delete(): TodoItem {
        todoItemJpaRepository.delete(this)
        return this
    }
}