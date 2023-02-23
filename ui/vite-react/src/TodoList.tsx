import * as React from 'react'
import { connect } from 'react-redux'
import TodoItem from './TodoItem'

const mapStateToProps = (state: any) => ({
  editing: state.todo.editing,
})

interface TodoListProps {
  editing: number
  list: Todo[]
}

class TodoList extends React.Component<TodoListProps> {
  render() {
    const { list, editing } = this.props
    return (
            <ul className="todo-list">
                {
                    list.map((item: Todo) => (
                        <TodoItem
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            completed={item.completed}
                            editing={editing === item.id}
                        />
                    ))
                }
            </ul>
    )
  }
}

export default connect(mapStateToProps)(TodoList)
