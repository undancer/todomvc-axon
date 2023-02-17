import type { RouteRecordRaw } from 'vue-router'
import { createRouter, createWebHistory } from 'vue-router'
import App from '../components/App.vue'

const routes: RouteRecordRaw[] = [
  { path: '/', component: App },
]
const history = createWebHistory()
const router = createRouter({ routes, history })
export { router }
