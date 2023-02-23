import * as React from 'react';
// import './App.css';
import 'todomvc-app-css/index.css';
import Footer from "./Footer";
import Header from "./Header";
import TogglePanel from "./TogglePanel";
import FilteredList from "./FilteredList";
import {Dispatch} from "redux";
import {connect} from "react-redux";
import {initData} from "./actions";
import {Route, Routes} from 'react-router-dom';
import {withRouter} from './routes';

const mapStateToProps = (state: any) => ({});

const mapDispatchToProps = (dispatch: Dispatch) => ({
// @ts-ignore
    initData: () => dispatch(initData())
});

interface AppProps {
    initData: () => void
}

class App extends React.Component<AppProps> {

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
                    <Routes>
                        <Route path="/" element={<FilteredList filter="all"/>}/>
                        <Route path="/active" element={<FilteredList filter="active"/>}/>
                        <Route path="/completed" element={<FilteredList filter="completed"/>}/>
                    </Routes>
                </section>
                <Footer/>
            </section>
        );
    }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
