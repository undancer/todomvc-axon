import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './App';
// import './index.css';
import registerServiceWorker from './registerServiceWorker';
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
registerServiceWorker();
