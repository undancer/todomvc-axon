<script lang="ts" setup>
</script>

<template>
  <section class="todoapp">
    <header class="header">
      <slot name="header" />
    </header>
    <section class="main">
      <slot name="default" />
    </section>
    <!-- This footer should be hidden by default and shown when there are todos -->
    <footer class="footer">
      <slot name="footer" />
    </footer>
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
