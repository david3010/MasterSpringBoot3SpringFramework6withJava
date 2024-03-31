function ListTodosComponent() {
    const today = new Date()
    let targetDate = new Date(today.getFullYear() + 1, today.getMonth(), today.getDate())
    const todos = [
        { id: 1, description: 'Learn Spring Boot', targetDate, done: false },
        { id: 2, description: 'Learn Spring Boot', targetDate, done: false },
        { id: 3, description: 'Learn Spring Boot', targetDate, done: false },
        { id: 4, description: 'Learn Spring Boot', targetDate, done: false }
    ]
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
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(todo => {
                                return <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.targetDate.toDateString()}</td>
                                    <td>{todo.done | Boolean}</td>
                                    <td>
                                        
                                    </td>
                                    <td>
                                        
                                    </td>
                                </tr>
                            })
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ListTodosComponent;