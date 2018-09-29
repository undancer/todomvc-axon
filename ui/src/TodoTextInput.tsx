import * as React from "react";
import {connect} from "react-redux";
import {Dispatch} from "redux";
import Input from "./Input";
import {newTodo} from "./actions";

const mapStateToProps = (state: {}) => ({});

const mapDispatchToProps = (dispatch: Dispatch) => ({
    addNew: (value: string) => dispatch(newTodo(value)),
});

interface TodoTextInputProps {
    addNew: (value: string) => void
}

class TodoTextInput extends React.Component<TodoTextInputProps> {

    handleReturn = (value: string) => {
        const {addNew} = this.props;
        addNew(value);
    };

    render() {
        return (
            <Input
                className="new-todo"
                placeholder="What needs to be done?"
                onReturn={this.handleReturn}
                autoFocus
            />
        );
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(TodoTextInput);