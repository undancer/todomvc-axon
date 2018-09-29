import * as React from 'react';
// import './App.css';
import 'todomvc-app-css/index.css';
import Footer from "./Footer";
import Header from "./Header";
import TodoList from "./TodoList";

class App extends React.Component {
    public render() {
        return (
            <section className="todoapp">
                <Header/>
                <section className="main">
                    <input id="toggle-all" className="toggle-all" type="checkbox"/>
                    <label htmlFor="toggle-all">Mark all as complete</label>
                    <TodoList/>
                </section>
                <Footer/>
            </section>
        );
    }
}

export default App;
