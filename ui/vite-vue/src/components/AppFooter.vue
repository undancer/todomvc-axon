<script lang="ts" setup>
import { ref } from 'vue-demi'

const routes = ref([{
  name: 'All',
  path: '/',
}, {
  name: 'Active',
  path: '/active',
}, {
  name: 'Completed',
  path: '/completed',
}])
</script>

<template>
  <!-- This should be `0 items left` by default -->
  <span class="todo-count"><strong>0</strong> item left</span>
  <!-- Remove this if you don't implement routing -->
  <ul class="filters">
    <li
      v-for="({ name, path }, index) in routes"
      :key="index"
    >
      <RouterLink active-class="selected" :to="path">
        {{ name }}
      </RouterLink>
    </li>
  </ul>
  <!-- Hidden if no completed items are left ↓ -->
  <button class="clear-completed">
    Clear completed
  </button>
</template>
