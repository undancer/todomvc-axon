import * as React from 'react';
// import './App.css';
import 'todomvc-app-css/index.css';
import Footer from "./Footer";
import Header from "./Header";
import {Route, RouteComponentProps, Switch, withRouter} from "react-router";
import TogglePanel from "./TogglePanel";
import FilteredList from "./FilteredList";

class App extends React.Component<RouteComponentProps> {
    public render() {
        return (
            <section className="todoapp">
                <Header/>
                <section className="main">
                    <TogglePanel/>
                    <Switch>
                        <Route exact path="/">
                            <FilteredList filter="all"/>
                        </Route>
                        <Route path="/active">
                            <FilteredList filter="active"/>
                        </Route>
                        <Route path="/completed">
                            <FilteredList filter="completed"/>
                        </Route>
                    </Switch>
                </section>
                <Footer/>
            </section>
        );
    }
}

export default withRouter(App);
