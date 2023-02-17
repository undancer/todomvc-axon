<script setup lang="ts">
import TodoItem from './TodoItem.vue'
</script>

<template>
  <ul class="todo-list">
    <!-- These are here just to show the structure of the list items -->
    <!-- List items should get the class `editing` when editing and `completed` when marked as completed -->
    <li class="completed">
      <div class="view">
        <input checked class="toggle" type="checkbox">
        <label>Taste JavaScript</label>
        <button class="destroy" />
      </div>
      <input class="edit" value="Create a TodoMVC template">
    </li>
    <TodoItem />
  </ul>
</template>
