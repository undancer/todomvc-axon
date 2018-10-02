package com.undancer.app.domain.handle

import com.undancer.app.entity.TodoEntity
import com.undancer.app.entity.jpa.TodoJpaRepository
import com.undancer.app.evnets.ChangedTodoTitleEvent
import com.undancer.app.evnets.CreatedTodoEvent
import com.undancer.app.querys.FindTodoQuery
import com.undancer.app.querys.GetTodoQuery
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class TodoProjection {

    @Autowired
    lateinit var todoJpaRepository: TodoJpaRepository

    @QueryHandler //获取所有
    fun on(query: GetTodoQuery): List<TodoEntity> {
        println("query : $query")
//        return todoList.stream().collect(Collectors.toList());
        return todoJpaRepository.findAll()
    }

    @QueryHandler //获取一个
    fun on(query: FindTodoQuery): TodoEntity {
        //        Aggregate<com.undancer.app.domain.Todo> aggregate = repository.load(query.getId().getIdentifier());
        return todoJpaRepository.findById(query.id.identifier).get()
    }

    @EventHandler
    fun on(event: CreatedTodoEvent) {
        println("projection - $event")
        todoJpaRepository.save(TodoEntity(event.id.identifier, event.title))

        //        queryUpdateEmitter.emit(
        //                com.undancer.app.domain.Todo.class,
        //                todo -> todo.getId().getIdentifier().equals(event.getId().getIdentifier()),
        //                entity
        //        );
    }

    @EventHandler
    fun on(event: ChangedTodoTitleEvent): TodoEntity {
        val entity = todoJpaRepository.findTodoById(event.id.identifier)
        entity.title = event.title
        todoJpaRepository.save(entity)
        return entity
    }

}
