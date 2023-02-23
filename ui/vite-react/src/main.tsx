import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import {Provider} from "react-redux";
import {store} from "./stores";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
// import './index.css'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
        <Provider store={store}>
            <Router>
                <Routes>
                    <Route path="/*" element={<App/>}/>
                </Routes>
            </Router>
        </Provider>
    </React.StrictMode>,
)
