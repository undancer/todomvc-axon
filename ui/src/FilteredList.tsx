import * as React from "react";
import TodoList from "./TodoList";
import {applyFilter} from "./utils";
import {connect} from "react-redux";

const mapStateToProps = (state: { todo: { items: Todo[] } }) => ({
    items: state.todo.items
});

interface FilteredListProps {
    filter: string,
    items: Todo[],
}

class FilteredList extends React.Component<FilteredListProps> {
    render() {
        const {items, filter} = this.props;
        const filteredList = applyFilter(items, filter);
        return (
            <TodoList list={filteredList}/>
        )
    }
}

export default connect(mapStateToProps)(FilteredList);
