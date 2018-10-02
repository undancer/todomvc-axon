package com.undancer.app.web;

import com.undancer.app.commands.ChangeTodoTitleCommand;
import com.undancer.app.commands.CreateTodoCommand;
import com.undancer.app.commands.DeleteTodoCommand;
import com.undancer.app.entity.TodoEntity;
import com.undancer.app.querys.FindTodoQuery;
import com.undancer.app.querys.GetTodoQuery;
import com.undancer.app.values.TodoId;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseType;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/todo")
public class TodoController {

    @Autowired
    CommandGateway commandGateway;

    @Autowired
    QueryGateway queryGateway;

//    @Autowired
//    TodoJpaRepository todoJpaRepository;

    @GetMapping
    public Flux<TodoEntity> getTodo() {
        GetTodoQuery query = new GetTodoQuery();
        CompletableFuture<List<TodoEntity>> future = queryGateway.query(
                query,
                ResponseTypes.multipleInstancesOf(TodoEntity.class)
        );
        return Mono.fromFuture(future).flatMapMany(Flux::fromIterable);
    }

    //    @GetMapping
//    public Flux<Todo> getTodo1() {
//        GetTodoQuery query = new GetTodoQuery();
//        ResponseType responseType = ResponseTypes.multipleInstancesOf(Todo.class);
//        if (true) {
//            CompletableFuture<List<Todo>> future = queryGateway.query(query, responseType);
//            return Mono.fromFuture(future).flatMapMany(Flux::fromIterable);
//        } else {
//            ResponseType initialResponseType = responseType;
//            ResponseType updateResponseType = ResponseTypes.instanceOf(Todo.class);
//            return queryGateway.subscriptionQuery(query, initialResponseType, updateResponseType).updates();
//        }
//    }

    @PutMapping
    public Mono<TodoEntity> edit(
            @RequestParam String id,
            @RequestParam(required = true) String title
    ) {
        TodoId todoId = new TodoId(id);
        ChangeTodoTitleCommand command = new ChangeTodoTitleCommand(todoId, title);
        FindTodoQuery query = new FindTodoQuery(todoId);
        CompletableFuture future = this.commandGateway.send(command);
        Mono<TodoEntity> mono = Mono.fromFuture(future)
                .transform(
                        (__) ->
                        {
                            System.out.println(__);
                            return Mono.fromFuture(
                                    queryGateway.query(query, ResponseTypes.instanceOf(TodoEntity.class))
                            );
                        }
                );
        return mono;
    }

//    PostMapping
//    public Mono<ResponseEntity<OrderResponse>> createOrder(CreateOrderRequest request)
//    {
//        CreateOrderCommand command = CreateOrderCommand.fromRequest(request); //1
//
//        return this.commandGateway.send(command) //2
//                .flatMap(id -> queryGateway.send(new FindOrderSummaryQuery(id))) //3
//                .retryWhen(errors -> errors.delayElements(Duration.of(100, MILLIS)) //4
//            .take(10)).concatWith(Mono.error(new RuntimeException())).next() //5
//            .onErrorReturn(new OrderResponse(orderID, OrderStatus.CREATED)) //6
//            .map(orderResponse -> ResponseEntity.ok().body(orderResponse)); //7
//    }


    @PostMapping
    public Mono<TodoEntity> addNew(
            @RequestParam(required = true) String title
    ) {
        CreateTodoCommand command = new CreateTodoCommand(new TodoId(), title);
        CompletableFuture<TodoId> future = commandGateway.send(command);
        return Mono.fromFuture(future)
                .flatMap(id -> {
                    System.out.println(id);
                    return Mono.fromFuture(
                            queryGateway.query(
                                    new FindTodoQuery(id),
                                    ResponseTypes.instanceOf(TodoEntity.class)
                            )
                    );
                });
//        Mono<TodoEntity> mono = Mono.fromFuture(future)
//                .flatMap(id -> Mono.fromFuture(queryGateway.query(new FindTodoQuery(id), TodoEntity.class)))
//                .retryWhen(errors -> errors.delayElements(Duration.of(100, ChronoUnit.MILLIS)).take(1));
//        return mono;
    }

    @DeleteMapping
    public void destroy(
            @RequestParam(required = true) String id
    ) {
        CompletableFuture future = commandGateway.send(new DeleteTodoCommand(new TodoId(id)));
        Mono mono = Mono.fromFuture(future);
        System.out.println(mono);
    }

}
