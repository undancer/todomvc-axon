import {combineReducers} from "redux";
import {
    TYPE_ADD_NEW_TODO,
    TYPE_CANCEL,
    TYPE_CHANGE_STATUS,
    TYPE_CHANGE_TODO,
    TYPE_CLEAR_COMPLETED,
    TYPE_DESTROY,
    TYPE_EDIT,
    TYPE_TOGGLE_ALL
} from "../actions";
import {addToList, deleteItem, getAll, updateStatus, updateText} from "../utils/data";

interface TodoState {
    items: Todo[]
}

const initState: TodoState = {
    items: getAll()
};

const todo = (state: TodoState = initState, action: any) => {
    switch (action.type) {
        case TYPE_EDIT: {
            return {...state, editing: action.id}
        }
        case TYPE_CANCEL : {
            return {...state, editing: null}
        }
        case TYPE_ADD_NEW_TODO: {
            const updatedList = addToList(state.items, {title: action.value, completed: false});
            return {...state, items: updatedList};
        }
        case TYPE_CHANGE_STATUS: {
            const updatedList = updateStatus(state.items, action.id, action.completed);
            return {...state, items: updatedList};
        }
        case TYPE_CHANGE_TODO: {
            const updatedList = updateText(state.items, action.id, action.text);
            return {...state, items: updatedList, editing: null};
        }
        case TYPE_DESTROY: {
            const updatedList = deleteItem(state.items, action.id);
            return {...state, items: updatedList}
        }
        case TYPE_TOGGLE_ALL: {
            const updatedList = state.items.map((item: any) => ({...item, completed: action.completed}));
            return {...state, items: updatedList}
        }
        case TYPE_CLEAR_COMPLETED: {
            const updatedList = state.items.filter((item: any) => item.completed === false);
            return {...state, items: updatedList};
        }
        default: {
            console.log(action);
            return state;
        }
    }
};

export default combineReducers({
    todo
});