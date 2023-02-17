import { createPinia } from 'pinia'
import { useMainStore } from './main'

const stores = createPinia()

export { stores, useMainStore }
