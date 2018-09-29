import * as React from "react";
import classNames from "classnames";

interface TodoItemProps {
    completed: boolean,
    text: string
}

// Create a TodoMVC template
// Rule the web

class TodoItem extends React.Component<TodoItemProps> {

    handleToggle = () => {

    };

    handleChange = () => {

    };

    render() {
        const {completed, text} = this.props;
        return (
            <li className={classNames({completed})}>
                <div className="view">
                    <input className="toggle" type="checkbox" onChange={this.handleToggle} checked={completed}/>
                    <label>{text}</label>
                    <button className="destroy"></button>
                </div>
                <input className="edit" value="Create a TodoMVC template" onChange={this.handleChange}/>
            </li>
        );
    }
}

export default TodoItem;