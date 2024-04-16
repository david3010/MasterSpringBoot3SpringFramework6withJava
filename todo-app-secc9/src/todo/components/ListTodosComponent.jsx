import { useEffect, useState } from "react"
import { retrieveAllTodos, deleteTodoByUsernameAndId, retrieveTodoByUsernameAndId } from "../api/TodoApiService"
import { useAuth } from "../security/AuthContext";
import { useNavigate } from 'react-router-dom'

function ListTodosComponent() {

    let authContext = useAuth();

    const navigate = useNavigate()

    let [todos, setTodos] = useState([])

    useEffect(() => refreshTodos(), [])

    function refreshTodos() {
        retrieveAllTodos(authContext.username).then(response => {
            setTodos(response.data)
        })
    }

    function handleTodoDetailsClick(username, id) {
        navigate(`/todo/${id}`)
    }

    function handleTodoDeleteClick(username, id) {
        deleteTodoByUsernameAndId(username, id).then(response => {
            refreshTodos()
        })
    }

    function addNewTodo() {
        navigate('/todo/-1')
    }

    return (
        <div className='container'>
            <h1>Things you have todo</h1>
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Description</th>
                            <th scope="col">Target Date</th>
                            <th scope="col">Its Done</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => {
                                return <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.targetDate}</td>
                                    <td>{todo.done | Boolean}</td>
                                    <td>
                                        <button className="btn btn-outline-success" onClick={() => handleTodoDetailsClick(todo.username, todo.id)}>Ver</button>
                                        <button className="btn btn-outline-danger ms-3" onClick={() => handleTodoDeleteClick(todo.username, todo.id)}>Eliminar</button>
                                    </td>
                                </tr>
                            })
                        }
                    </tbody>
                </table>
                <button className="btn btn-outline-primary" onClick={addNewTodo}>Add New Todo</button>
            </div>
        </div>
    )
}

export default ListTodosComponent