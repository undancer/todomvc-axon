import type { RouteRecordRaw } from 'vue-router'
import { createRouter, createWebHistory } from 'vue-router'

const routes: RouteRecordRaw[] = []
const history = createWebHistory()
const router = createRouter({ routes, history })
export { router }
