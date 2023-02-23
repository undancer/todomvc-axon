import * as React from 'react'
import { connect } from 'react-redux'
import type { Dispatch } from 'redux'
import Input from './Input'
import { todoActions } from './actions'

const mapStateToProps = (state: {}) => ({})

const mapDispatchToProps = (dispatch: Dispatch) => ({
// @ts-expect-error
  addNew: (title: string) => dispatch(todoActions.addTodo(title)),
})

interface TodoTextInputProps {
  addNew: (title: string) => void
}

class TodoTextInput extends React.Component<TodoTextInputProps> {
  handleReturn = (value: string) => {
    const { addNew } = this.props
    addNew(value)
  }

  render() {
    return (
            <Input
                className="new-todo"
                placeholder="What needs to be done?"
                onReturn={this.handleReturn}
                autoFocus
            />
    )
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(TodoTextInput)
