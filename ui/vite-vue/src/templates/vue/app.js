/* global Vue, todoStorage */

(function (exports) {
  'use strict'

  const filters = {
    all(todos) {
      return todos
    },
    active(todos) {
      return todos.filter((todo) => {
        return !todo.completed
      })
    },
    completed(todos) {
      return todos.filter((todo) => {
        return todo.completed
      })
    },
  }

  exports.app = new Vue({

    // the root element that will be compiled
    el: '.todoapp',

    // a custom directive to wait for the DOM to be updated
    // before focusing on the input field.
    // http://vuejs.org/guide/custom-directive.html
    directives: {
      'todo-focus': function (el, binding) {
        if (binding.value)
          el.focus()
      },
    },

    // app initial state
    data() {
      return {
        todos: todoStorage.fetch(),
        newTodo: '',
        editedTodo: null,
        visibility: 'all',
      }
    },

    // computed properties
    // http://vuejs.org/guide/computed.html
    computed: {
      filteredTodos() {
        return filters[this.visibility](this.todos)
      },
      remaining() {
        return filters.active(this.todos).length
      },
      allDone: {
        get() {
          return this.remaining === 0
        },
        set(value) {
          this.todos.forEach((todo) => {
            todo.completed = value
          })
        },
      },
    },

    // watch todos change for localStorage persistence
    watch: {
      todos: {
        deep: true,
        handler: todoStorage.save,
      },
    },

    // methods that implement data logic.
    // note there's no DOM manipulation here at all.
    methods: {

      pluralize(word, count) {
        return word + (count === 1 ? '' : 's')
      },

      addTodo() {
        const value = this.newTodo && this.newTodo.trim()
        if (!value)
          return

        // TODO: Use a proper UUID instead of `Date.now()`.
        this.todos.push({ id: Date.now(), title: value, completed: false })
        this.newTodo = ''
      },

      removeTodo(todo) {
        const index = this.todos.indexOf(todo)
        this.todos.splice(index, 1)
      },

      editTodo(todo) {
        this.beforeEditCache = todo.title
        this.editedTodo = todo
      },

      doneEdit(todo) {
        if (!this.editedTodo)
          return

        this.editedTodo = null
        todo.title = todo.title.trim()
        if (!todo.title)
          this.removeTodo(todo)
      },

      cancelEdit(todo) {
        this.editedTodo = null
        todo.title = this.beforeEditCache
      },

      removeCompleted() {
        this.todos = filters.active(this.todos)
      },
    },
  })
})(window)
