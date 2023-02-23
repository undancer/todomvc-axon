const server_url = 'http://localhost:8080'

const get = (url: String) => {
  return fetch(server_url + url, { method: 'GET' })
}

const post = (url: String) => {
  return fetch(server_url + url, { method: 'POST' })
}

const put = (url: String) => {
  return fetch(server_url + url, { method: 'PUT' })
}

const del = (url: String) => {
  return fetch(server_url + url, { method: 'DELETE' })
}

export {
  get, put, post, del,
}
