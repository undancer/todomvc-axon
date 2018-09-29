import * as React from 'react';
import './App.css';

import logo from './logo.svg';

class App extends React.Component {

    handleClick = () => {
        console.log("click me");
        fetch("/foo").then(value => {
            console.log("get");
            console.log(value);
        });
    };

    public render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to React</h1>
                </header>
                <p className="App-intro">
                    To get started, edit <code>src/App.tsx</code> and save to reload.
                </p>
                <button onClick={this.handleClick}>按钮</button>
            </div>
        );
    }
}

export default App;
