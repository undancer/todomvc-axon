import * as cli from './client'

export const destroyTodo = (todo: string, id: number) => {
  return cli.del(`/todo?todo=${todo}&id=${id}`)
}

export const toggleTodo = (todo: string, id: number, completed: boolean) => {
  return cli.put(`/todo?todo=${todo}&id=${id}&completed=${completed}`)
}

export const editTodo = (todo: string, id: number, title: string) => {
  return cli.put(`/todo?todo=${todo}&id=${id}&title=${title}`)
}

export const addTodo = (todo: string, title: string) => {
  return cli.post(`/todo?todo=${todo}&title=${title}`)
}

export const initApp = () => {
  return cli.post('/todo')
}

export const initData = (todo: string) => {
  return cli.get(`/todo?todo=${todo}`)
}
