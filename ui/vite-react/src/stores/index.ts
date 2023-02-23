import { applyMiddleware, createStore } from 'redux'
import thunk from 'redux-thunk'
import { createLogger } from 'redux-logger'
import reducer from '../reducers'

const logger = createLogger({
  // ...options
})

const store = createStore(
  reducer,
  applyMiddleware(thunk, logger),
)

export { store }
