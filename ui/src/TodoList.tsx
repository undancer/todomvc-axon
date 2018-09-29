import * as React from "react";
import TodoItem from "./TodoItem";
import {connect} from "react-redux";
import {RouteComponentProps} from "react-router";

const mapStateToProps = (state: any) => ({
    items: state.todo.items
});

interface TodoListProps {
    items: Todo[]
}

class TodoList extends React.Component<TodoListProps, RouteComponentProps> {
    render() {
        const {items} = this.props;
        return (
            <ul className="todo-list">
                {
                    items.map((item: Todo) => (
                        <TodoItem key={item.id} text={item.text} completed={item.completed}/>
                    ))
                }
            </ul>
        );
    }
}

export default connect(mapStateToProps)(TodoList);