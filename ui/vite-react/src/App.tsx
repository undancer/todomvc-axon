import * as React from 'react'
// import './App.css';
import 'todomvc-app-css/index.css'
import type { Dispatch } from 'redux'
import { connect } from 'react-redux'
import { Route, Routes } from 'react-router-dom'
import Footer from './Footer'
import Header from './Header'
import TogglePanel from './TogglePanel'
import FilteredList from './FilteredList'
import { initData } from './actions'
import { withRouter } from './routes'

const mapStateToProps = (state: any) => ({})

const mapDispatchToProps = (dispatch: Dispatch) => ({
// @ts-expect-error
  initData: () => dispatch(initData()),
})

interface AppProps {
  initData: () => void
}

class App extends React.Component<AppProps> {
  componentDidMount() {
    const { initData } = this.props
    initData()
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
    )
  }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App))
