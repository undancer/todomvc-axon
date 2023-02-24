import type { Dispatch } from 'redux'
import * as api from '../api/TodoApi'

export const TYPE_CLEAR_COMPLETED = 'CLEAR_COMPLETED'
export const TYPE_EDIT = 'EDIT'
export const TYPE_DESTROY = 'DESTROY'
export const TYPE_CHANGE_STATUS = 'CHANGE_STATUS'
export const TYPE_CHANGE_TODO = 'CHANGE_TODO'
export const TYPE_CANCEL = 'CANCEL'
export const TYPE_ADD_NEW_TODO = 'ADD_NEW_TODO'
export const TYPE_TOGGLE_ALL = 'TOGGLE_ALL'

export const TYPE_ADD_TODO_SUCCESS = TYPE_ADD_NEW_TODO
export const TYPE_EDIT_TODO_SUCCESS = TYPE_CHANGE_TODO
export const TYPE_TOGGLE_SUCCESS = TYPE_CHANGE_STATUS
export const TYPE_DESTROY_SUCCESS = TYPE_DESTROY

export const clearCompleted = () => ({ type: TYPE_CLEAR_COMPLETED })
export const editTodo = (id: number) => ({ type: TYPE_EDIT, id })
export const cancelTodo = (id: number) => ({ type: TYPE_CANCEL, id })
export const newTodo = (value: string) => ({ type: TYPE_ADD_NEW_TODO, value })
export const toggleAll = (completed: boolean) => ({ type: TYPE_TOGGLE_ALL, completed })

const addTodo = (title: string) => {
  const request = () => ({ type: 'add-todo-request' })
  const success = (title: string) => ({ type: TYPE_ADD_TODO_SUCCESS, title })
  const failure = () => ({ type: 'edit-todo-failure' })

  return (dispatch: Dispatch, getState: () => void) => {
    dispatch(request())
    const state: any = getState()
    const { todo } = state.todo
    api.addTodo(todo, title)
      .then((response: Response) => {
        dispatch(success(title))
      }, (error: any) => {
        dispatch(failure())
      })
  }
}

const _editTodo = (id: number, title: string) => {
  const request = () => ({ type: 'edit-todo-request' })
  const success = (id: number, title: string) => ({ type: TYPE_EDIT_TODO_SUCCESS, id, title })
  const failure = () => ({ type: 'edit-todo-failure' })

  return (dispatch: Dispatch, getState: () => void) => {
    dispatch(request())
    const state: any = getState()
    const { todo } = state.todo
    api.editTodo(todo, id, title)
      .then((response: Response) => {
        dispatch(success(id, title))
      }, (error: any) => {
        dispatch(failure())
      })
  }
}

const toggleTodo = (id: number, completed: boolean) => {
  const request = () => ({ type: 'toggle-todo-request' })
  const success = (id: number, completed: boolean) => ({ type: TYPE_TOGGLE_SUCCESS, id, completed })
  const failure = () => ({ type: 'toggle-todo-failure' })

  return (dispatch: Dispatch, getState: () => void) => {
    dispatch(request())
    const state: any = getState()
    const { todo } = state.todo
    api.toggleTodo(todo, id, completed)
      .then((response: Response) => {
        dispatch(success(id, completed))
      }, (error: any) => {
        dispatch(failure())
      })
  }
}

const destroyTodo = (id: number) => {
  const request = () => ({ type: 'destroy-todo-request' })
  const success = (id: number) => ({ type: TYPE_DESTROY_SUCCESS, id })
  const failure = () => ({ type: 'destroy-todo-failure' })

  return (dispatch: Dispatch, getState: () => void) => {
    dispatch(request())
    const state: any = getState()
    const { todo } = state.todo
    api.destroyTodo(todo, id)
      .then((response: Response) => {
        dispatch(success(id))
      }, (error: any) => {
        dispatch(failure())
      })
  }
}

export const todoActions = {
  addTodo,
  editTodo: _editTodo,
  toggleTodo,
  destroyTodo,
}

export const initData = () =>
  (dispatch: Dispatch, getState: () => void) => {
    api.initApp()
      .then((response: Response) => response.json())
      .then((json: any) => {
        let todo = json.identifier
        todo = '0ce45879-1d2e-449b-9bad-8734c1e6f9ed'
        dispatch({ type: 'init', todo })
        return api.initData(todo)
      }).then((response: Response) => response.json())
      .then((items: any) => {
        dispatch({ type: 'init-data', items })
        console.log(getState())
      })
  }
