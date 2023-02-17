<!--
<script lang="ts" setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div>
    <a href="https://vitejs.dev" target="_blank">
      <img alt="Vite logo" class="logo" src="/vite.svg">
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img alt="Vue logo" class="logo vue" src="./assets/vue.svg">
    </a>
  </div>
  <HelloWorld msg="Vite + Vue" />
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
}

.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
-->

<script lang="ts" setup>
import { useMainStore } from './stores'
import AppFooter from './components/AppFooter.vue'
import AppHeader from './components/AppHeader.vue'

const mainStore = useMainStore()
mainStore.fetch()
</script>

<template>
  <section class="todoapp">
    <AppHeader />
    <section class="main">
      <router-view />
    </section>
    <AppFooter />
  </section>
  <footer class="info">
    <p>Double-click to edit a todo</p>
    <!-- Remove the below line ↓ -->
    <p>Template by <a href="http://sindresorhus.com">Sindre Sorhus</a></p>
    <!-- Change this out with your name and url ↓ -->
    <p>Created by <a href="http://todomvc.com">you</a></p>
    <p>Part of <a href="http://todomvc.com">TodoMVC</a></p>
  </footer>
</template>

<style lang="scss">
@import "todomvc-common/base.css";
@import "todomvc-app-css/index.css";
</style>

<style lang="scss" scoped>

</style>
