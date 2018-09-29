import {combineReducers} from "redux";
import {TYPE_TOGGLE_ALL} from "../actions";

interface TodoState {
    items: Todo[]
}

const initState: TodoState = {
    items: [
        {
            id: 1,
            text: 'Taste JavaScript',
            completed: true,
        },
        {
            id: 2,
            text: 'Buy a unicorn',
            completed: false,
        },
    ]
};

const todo = (state: TodoState = initState, action: any) => {
    switch (action.type) {
        case TYPE_TOGGLE_ALL: {
            const {items} = state;
            return {...state, items};
        }
        default:
            return state;
    }
};

export default combineReducers({
    todo
});