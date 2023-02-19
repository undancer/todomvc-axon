<script lang="ts" setup>
import { defineProps, withDefaults } from 'vue-demi'
import TodoList from './TodoList.vue'

withDefaults(defineProps<{
  filter?: string
}>(), {
  filter: 'all',
})
</script>

<template>
  <TodoList />
</template>
