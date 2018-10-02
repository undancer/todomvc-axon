package com.undancer.app.domain;

import com.undancer.app.*;
import com.undancer.app.commands.ChangeTodoTitleCommand;
import com.undancer.app.commands.CreateTodoCommand;
import com.undancer.app.commands.DeleteTodoCommand;
import com.undancer.app.evnets.ChangedTodoTitleEvent;
import com.undancer.app.evnets.CreatedTodoEvent;
import com.undancer.app.evnets.DeletedTodoEvent;
import com.undancer.app.values.TodoId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Todo {

    @AggregateIdentifier
    private TodoId id;

    private String title;

    private boolean compiled;

    private Todo() {

    }

    @CommandHandler
    public Todo(CreateTodoCommand command) {
//        apply(new CreatedTodoEvent(command.getId(), command.getTitle()), MetaData.with("name", "undancer"));
        apply(new CreatedTodoEvent(command.getId(), command.getTitle()));
    }

    @CommandHandler
    public void on(ChangeTodoTitleCommand command) {
        System.out.println(this);
        System.out.println(command);
        apply(new ChangedTodoTitleEvent(id, command.getTitle()));
    }

    @CommandHandler
    public void on(DeleteTodoCommand command) {
        apply(new DeletedTodoEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(CreatedTodoEvent event) {
        this.id = event.getId();
        this.title = event.getTitle();
    }

    @EventSourcingHandler
    public void on(ChangedTodoTitleEvent event) {
        System.out.println("event -> " + event);
        this.title = title;
    }

    @EventSourcingHandler
    public void on(DeletedTodoEvent event) {
        System.out.println("删除聚合根？？？");
    }


    public TodoId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompiled() {
        return compiled;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
