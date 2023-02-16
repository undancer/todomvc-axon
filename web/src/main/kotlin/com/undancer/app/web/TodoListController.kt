package com.undancer.app.web

import com.undancer.app.commands.*
import com.undancer.app.entity.TodoItem
import com.undancer.app.querys.FindTodoItemQuery
import com.undancer.app.values.TodoId
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@RestController
@RequestMapping(path = ["/todo"])
class TodoListController {

    @Autowired
    lateinit var commandGateway: CommandGateway

    @Autowired
    lateinit var queryGateway: QueryGateway

    @GetMapping
    fun getTodoItem(
        todo: String
    ): Flux<TodoItem> {
        var flux = queryGateway.query(
            FindTodoItemQuery(TodoId(todo)),
            ResponseTypes.multipleInstancesOf(TodoItem::class.java)
        ).toMono().flatMapMany { it -> Flux.fromIterable(it) }
        return flux
    }

    @PostMapping
    fun init(): Mono<TodoId> {
        return commandGateway.send<TodoId>(CreateTodoListCommand(TodoId())).toMono()
    }

    @PostMapping(params = ["todo", "title"])
    fun add(
        todo: String,
        title: String
    ): Mono<Any> {
        return commandGateway.send<Any>(AddTodoItemCommand(TodoId(todo), title)).toMono()
    }

    @PutMapping(params = ["todo", "id", "title"])
    fun edit(
        todo: String,
        id: Long,
        title: String
    ): Mono<Any> {
        var mono = commandGateway.send<Any>(EditTodoItemCommand(TodoId(todo), id, title)).toMono()
        return mono
    }

    @PutMapping(params = ["todo", "id", "completed"])
    fun toggle(
        todo: String,
        id: Long,
        completed: Boolean
    ): Mono<Any> {
        var mono = commandGateway.send<Any>(ToggleTodoItemCommand(TodoId(todo), id, completed)).toMono()
        return mono
    }

    @DeleteMapping(params = ["todo", "id"])
    fun destroy(
        todo: String,
        id: Long
    ): Mono<Any> {
        var mono = commandGateway.send<Any>(DestroyTodoItemCommand(TodoId(todo), id)).toMono()
        return mono
    }

}
