<script setup lang="ts">
import { ref } from 'vue-demi'
import TodoItem from './TodoItem.vue'

const items = ref([
  {
    id: 1,
    completed: true,
    checked: true,
    title: 'Taste JavaScript',
    desc: 'Create a TodoMVC template',
  },
  {
    id: 2,
    completed: false,
    checked: false,
    title: 'Buy a unicorn',
    desc: 'Rule the web',
  },
])
</script>

<template>
  <ul class="todo-list">
    <!-- These are here just to show the structure of the list items -->
    <!-- List items should get the class `editing` when editing and `completed` when marked as completed -->
    <TodoItem
      v-for="item in items"
      :id="item.id"
      :key="item.id"
      :completed="item.completed"
      :checked="item.checked"
      :title="item.title"
      :desc="item.desc"
    />
  </ul>
</template>
