import {applyMiddleware, createStore} from "redux";
import reducer from '../reducers';
import thunk from "redux-thunk";
import {createLogger} from "redux-logger";


const logger = createLogger({
    // ...options
});

const store = createStore(
    reducer,
    applyMiddleware(thunk, logger),
);

export {store}