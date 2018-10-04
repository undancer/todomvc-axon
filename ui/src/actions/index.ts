import {Dispatch} from "redux";
import * as api from "../api/TodoApi";

export const TYPE_CLEAR_COMPLETED = 'CLEAR_COMPLETED';
export const TYPE_EDIT = 'EDIT';
export const TYPE_DESTROY = 'DESTROY';
export const TYPE_CHANGE_STATUS = 'CHANGE_STATUS';
export const TYPE_CHANGE_TODO = 'CHANGE_TODO';
export const TYPE_CANCEL = 'CANCEL';
export const TYPE_ADD_NEW_TODO = 'ADD_NEW_TODO';
export const TYPE_TOGGLE_ALL = 'TOGGLE_ALL';

export const clearCompleted = () => ({type: TYPE_CLEAR_COMPLETED});
export const editTodo = (id: number) => ({type: TYPE_EDIT, id});
export const destroyTodo = (id: number) => ({type: TYPE_DESTROY, id});
export const toggleTodo = (id: number, completed: boolean) => ({type: TYPE_CHANGE_STATUS, id, completed});
export const saveTodo = (id: number, text: string) => ({type: TYPE_CHANGE_TODO, id, text});
export const cancelTodo = (id: number) => ({type: TYPE_CANCEL, id});
export const newTodo = (value: string) => ({type: TYPE_ADD_NEW_TODO, value});
export const toggleAll = (completed: boolean) => ({type: TYPE_TOGGLE_ALL, completed});

export const destroyTodoAction = (id: number) =>
    (dispatch: Dispatch, getState: () => void) => {
        const state: any = getState();
        const {todo} = state.todo;
        api.destroyTodo(todo, id)
            .then((response: Response) => {
                console.log(response.status);
                dispatch(destroyTodo(id));
            })
    };

export const toggleTodoAction = (id: number, completed: boolean) =>
    (dispatch: Dispatch, getState: () => void) => {
        const state: any = getState();
        const {todo} = state.todo;
        api.toggleTodo(todo, id, completed)
            .then((response: Response) => {
                console.log(response.status);
                dispatch(toggleTodo(id, completed));
            })
    };

export const editTodoAction = (id: number, title: string) =>
    (dispatch: Dispatch, getState: () => void) => {
        const state: any = getState();
        const {todo} = state.todo;
        api.editTodo(todo, id, title)
            .then((response: Response) => {
                console.log("edit");
                console.log(response);
                console.log(response.status);
                dispatch(saveTodo(id, title));
            })
    };

export const addTodoAction = (title: string) =>
    (dispatch: Dispatch, getState: () => void) => {
        const state: any = getState();
        const {todo} = state.todo;
        api.addTodo(todo, title)
            .then((response: Response) => {
                console.log(response.status);
                dispatch(newTodo(title));
            });
    };

export const initData = () =>
    (dispatch: Dispatch, getState: () => void) => {
        api.initApp()
            .then((response: Response) => response.json())
            .then((json: any) => {
                let todo = json.identifier;
                todo = "61561d91-14b5-478b-8dd4-bd560fba28d1";
                dispatch({type: "init", todo});
                return api.initData(todo)
            }).then((response: Response) => response.json())
            .then((items: any) => {
                dispatch({type: "init-data", items});
                console.log(getState());
            })
        ;
    };