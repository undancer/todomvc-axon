import { defineStore } from 'pinia'

const STORAGE_KEY = 'todos-vuejs'
const useMainStore = defineStore('app', {
  actions: {
    fetch() {
      console.log('fetch !!')
      return JSON.parse(localStorage.getItem(STORAGE_KEY) || '[]')
    },
    save(todos: any) {
      localStorage.setItem(STORAGE_KEY, JSON.stringify(todos))
    },
  },
})

export { useMainStore }
