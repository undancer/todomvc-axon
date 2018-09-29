import {combineReducers} from "redux";

interface TodoState {

}

const initState: TodoState = {};

const todo = (state: TodoState = initState, action: {}) => {
    return state;
};

export default combineReducers({
    todo
});