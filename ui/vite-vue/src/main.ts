import { createApp } from 'vue-demi'
// import './style.css'
import App from './App.vue'
import { router } from './routes'
import { stores } from './stores'
// import 'virtual:windi.css'

const app = createApp(App)
app.use(stores)
app.use(router)
app.mount('#app')
