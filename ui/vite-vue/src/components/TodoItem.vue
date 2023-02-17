<script lang="ts" setup>
import { defineProps, withDefaults } from 'vue-demi'

withDefaults(defineProps<{
  id?: number
  title?: string
  desc?: string
  checked?: boolean
  completed?: boolean
  editing?: boolean
}>(), {
  title: 'default title',
  desc: 'default desc',
  checked: false,
  completed: false,
  editing: false,
})
</script>

<template>
  <li :class="{ completed }">
    <div class="view">
      <input :checked="checked" class="toggle" type="checkbox">
      <label>{{ title || 'Buy a unicorn' }}</label>
      <button class="destroy" />
    </div>
    <input class="edit" value="{{desc || 'Rule the web'}}">
  </li>
</template>
