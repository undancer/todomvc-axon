import * as React from "react";
import TodoItem from "./TodoItem";
import {list} from './db';

const TodoList = () => (
    <ul className="todo-list">
        {
            list.map((item: Todo) => (
                <TodoItem key={item.id} text={item.text} completed={item.completed}/>
            ))
        }
    </ul>
);
export default TodoList;