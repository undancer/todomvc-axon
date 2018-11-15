import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
// import './index.css';
import * as serviceWorker from './serviceWorker';
import {Provider} from "react-redux";
import {store} from "./stores";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

ReactDOM.render(
    (
        <Provider store={store}>
            <Router>
                <Switch>
                    <Route component={App}/>
                </Switch>
            </Router>
        </Provider>
    ),
    document.getElementById('root') as HTMLElement
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
