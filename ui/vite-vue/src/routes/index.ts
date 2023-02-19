import type { RouteRecordRaw } from 'vue-router'
import { createRouter, createWebHistory } from 'vue-router'
import FilteredList from '../components/FilteredList.vue'
import NotFound from '../components/NotFound.vue'

const routes: RouteRecordRaw[] = [
  { path: '/:pathMatch(.*)*', name: 'NotFound', component: NotFound },
  { path: '/', component: FilteredList, props: { filter: 'all' } },
  { path: '/active', component: FilteredList, props: { filter: 'active' } },
  { path: '/completed', component: FilteredList, props: { filter: 'completed' } },
]
const history = createWebHistory()
const router = createRouter({ routes, history })
export { router }
