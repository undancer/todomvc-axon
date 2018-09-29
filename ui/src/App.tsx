import * as React from 'react';
// import './App.css';
import 'todomvc-app-css/index.css';
import Footer from "./Footer";
import Header from "./Header";
import TodoList from "./TodoList";
import {RouteComponentProps, withRouter} from "react-router";
import TogglePanel from "./TogglePanel";

class App extends React.Component<RouteComponentProps> {
    public render() {
        return (
            <section className="todoapp">
                <Header/>
                <section className="main">
                    <TogglePanel/>
                    <TodoList/>
                </section>
                <Footer/>
            </section>
        );
    }
}

export default withRouter(App);
