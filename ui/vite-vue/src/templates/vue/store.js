/* jshint unused:false */

(function (exports) {
  'use strict'

  const STORAGE_KEY = 'todos-vuejs'

  exports.todoStorage = {
    fetch() {
      return JSON.parse(localStorage.getItem(STORAGE_KEY) || '[]')
    },
    save(todos) {
      localStorage.setItem(STORAGE_KEY, JSON.stringify(todos))
    },
  }
})(window)
