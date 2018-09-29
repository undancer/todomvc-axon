import * as React from "react";
import {ChangeEvent, FocusEvent, KeyboardEvent, MouseEvent} from "react";
import classNames from "classnames";
import {connect} from "react-redux";
import {Dispatch} from "redux";
import {KEY_ESCAPE, KEY_RETURN} from "keycode-js";
import {cancelTodo, destroyTodo, editTodo, saveTodo, toggleTodo} from "./actions";

const mapStateToProps = (state: {}) => ({});

const mapDispatchToProps = (dispatch: Dispatch) => ({

    changeStatus: (id: number, completed: boolean) => dispatch(toggleTodo(id, completed)),

    onEdit: (id: number) => dispatch(editTodo(id)),

    onSave: (id: number, text: string) => dispatch(saveTodo(id, text)),

    onCancel: (id: number) => dispatch(cancelTodo(id)),

    onDestroy: (id: number) => dispatch(destroyTodo(id)),
});

interface TodoItemProps {
    id: number;
    title: string;
    completed: boolean;
    changeStatus: (id: number, completed: boolean) => void;
    editing: boolean,
    onEdit: (id: number) => void;
    onSave: (id: number, text: string) => void;
    onCancel: (id: number) => void;
    onDestroy: (id: number) => void;
}


interface TodoItemState {
    editValue: string;
}

// Create a TodoMVC template
// Rule the web

class TodoItem extends React.Component<TodoItemProps, TodoItemState> {

    constructor(props: TodoItemProps) {
        super(props);
        this.state = {
            editValue: this.props.title
        }
    }

    handleToggle = (event: ChangeEvent<HTMLInputElement>) => {
        const {id, completed, changeStatus} = this.props;
        changeStatus(id, !completed);
    };

    handleBlur = (event: FocusEvent<HTMLInputElement>) => {
        const editValue = this.state.editValue;
        const {id, onSave, onDestroy} = this.props;
        if (editValue) {
            onSave(id, editValue);
        } else {
            onDestroy(id);
        }
    };

    handleChange = (event: ChangeEvent<HTMLInputElement>) => {
        const {value} = event.target;
        this.setState({editValue: value});
    };

    handleKeyUp = (event: KeyboardEvent<HTMLInputElement>) => {
        switch (event.keyCode) {
            case KEY_RETURN: {
                const {editValue} = this.state;
                const {id, onSave} = this.props;
                onSave(id, editValue);
            }
                break;
            case KEY_ESCAPE: {
                const {id, title, onCancel} = this.props;
                this.setState({editValue: title});
                onCancel(id);
            }
                break;
            default:
                break;
        }
    };

    handleClick = (event: MouseEvent<HTMLButtonElement>) => {
        const {id, onDestroy} = this.props;
        onDestroy(id);
    };

    handleDoubleClick = (event: MouseEvent<HTMLLabelElement>) => {
        const {id, onEdit} = this.props;
        onEdit(id);
    };

    render() {
        const {editing, title, completed} = this.props;
        const {editValue} = this.state;
        return (
            <li className={classNames({completed, editing})}>
                <div className="view">
                    <input
                        className="toggle"
                        type="checkbox"
                        checked={completed}
                        onChange={this.handleToggle}
                    />
                    <label
                        onDoubleClick={this.handleDoubleClick}
                    >
                        {title}
                    </label>
                    <button
                        className="destroy"
                        onClick={this.handleClick}
                    />
                </div>
                <input
                    className="edit"
                    value={editValue}
                    onBlur={this.handleBlur}
                    onChange={this.handleChange}
                    onKeyUp={this.handleKeyUp}
                />
            </li>
        )
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(TodoItem);