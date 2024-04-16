import { clientURL } from './ApiClient'

export const retrieveAllTodos = (username) => clientURL.get(`/users/${username}/todos`)

export const retrieveTodoByUsernameAndId = (username, id) => clientURL.get(`/users/${username}/todos/${id}`)

export const deleteTodoByUsernameAndId = (username, id) => clientURL.delete(`/users/${username}/todos/${id}`)

export const updateTodoByUsernameAndId = (username, id, todo) => clientURL.put(`/users/${username}/todos/${id}`, todo)

export const createTodo = (username, todo) => clientURL.post(`/users/${username}/todos`, todo)