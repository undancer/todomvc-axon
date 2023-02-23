import * as React from 'react'
import type { Dispatch } from 'redux'
import { connect } from 'react-redux'
import { toggleAll } from './actions'

const mapStateToProps = (state: { todo: { items: [] } }) => ({
  items: state.todo.items,
})

const mapDispatchToProps = (dispatch: Dispatch) => ({
  onToggleAll: (completed: boolean) => dispatch(toggleAll(completed)),
})

interface TogglePanelProps {
  items: Todo[]
  onToggleAll: (completed: boolean) => void
}

class TogglePanel extends React.Component<TogglePanelProps> {
  handleClick = () => {
    const { onToggleAll } = this.props
    onToggleAll(!this.isAllCompleted())
  }

  isAllCompleted = () => {
    const { items } = this.props
    const count = items.length
    const completed = items.filter((item: Todo) => item.completed).length
    return count === completed
  }

  render() {
    return (
            <span>
                <input
                    id="toggle-all"
                    className="toggle-all"
                    type="checkbox"
                    defaultChecked={this.isAllCompleted()}
                />
                <label
                    htmlFor="toggle-all"
                    onClick={this.handleClick}
                >
                    Mark all as complete
                </label>
            </span>
    )
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(TogglePanel)
