import * as React from "react";
import {MouseEvent} from "react";
import {Dispatch} from "redux";
import {clearCompleted} from "./actions";
import {connect} from "react-redux";
import {RouteComponentProps, withRouter} from "react-router";
import {NavLink} from "react-router-dom";


const mapStateToProps = (state: { todo: { items: Todo[] } }) => ({
    items: state.todo.items,
});

const mapDispatchToProps = (dispatch: Dispatch) => ({
    onClearCompleted: () => dispatch(clearCompleted()),
});

interface FooterProps {
    items: Todo[],
    onClearCompleted: () => void,
}

class Footer extends React.Component<FooterProps & RouteComponentProps> {

    handleClick = (event: MouseEvent<HTMLButtonElement>) => {
        const {onClearCompleted} = this.props;
        onClearCompleted();
    };

    render() {
        const {items} = this.props;
        const count = items.length;
        return (
            <footer className="footer">
                <span className="todo-count"><strong>{count}</strong> item left</span>
                <ul className="filters">
                    <li>
                        <NavLink
                            exact
                            activeClassName="selected"
                            to="/">All</NavLink>
                    </li>
                    <li>
                        <NavLink
                            activeClassName="selected"
                            to="/active">Active</NavLink>
                    </li>
                    <li>
                        <NavLink
                            activeClassName="selected"
                            to="/completed">Completed</NavLink>
                    </li>
                </ul>
                <button
                    className="clear-completed"
                    onClick={this.handleClick}
                >
                    Clear completed
                </button>
            </footer>
        );
    }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Footer));