import * as React from 'react';
// import './App.css';
import 'todomvc-app-css/index.css';
import Footer from "./Footer";
import Header from "./Header";
import {Route, RouteComponentProps, Switch, withRouter} from "react-router";
import TogglePanel from "./TogglePanel";
import FilteredList from "./FilteredList";
import {Dispatch} from "redux";
import {connect} from "react-redux";
import {initData} from "./actions";

const mapStateToProps = (state: any) => ({});

const mapDispatchToProps = (dispatch: Dispatch) => ({
// @ts-ignore
    initData: () => dispatch(initData())
});

interface AppProps {
    initData: () => void
}

class App extends React.Component<AppProps & RouteComponentProps> {

    componentDidMount() {
        const {initData} = this.props;
        initData();
    }

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

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
