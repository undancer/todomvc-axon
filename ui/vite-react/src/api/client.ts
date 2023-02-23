const server_url = 'http://localhost:8080'

const get = (url: String) => {
  // @ts-expect-error
  return fetch(server_url + url, { method: 'GET' })
}

const post = (url: String) => {
  // @ts-expect-error
  return fetch(server_url + url, { method: 'POST' })
}

const put = (url: String) => {
  // @ts-expect-error
  return fetch(server_url + url, { method: 'PUT' })
}

const del = (url: String) => {
  // @ts-expect-error
  return fetch(server_url + url, { method: 'DELETE' })
}

export {
  get, put, post, del,

}
