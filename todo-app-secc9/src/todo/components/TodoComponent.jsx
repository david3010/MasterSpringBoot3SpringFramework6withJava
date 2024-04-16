import { useEffect, useState } from 'react'
import { createTodo, retrieveTodoByUsernameAndId, updateTodoByUsernameAndId } from '../api/TodoApiService'
import { useAuth } from '../security/AuthContext'
import { useParams } from 'react-router-dom'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import { useNavigate } from 'react-router-dom'
import moment from 'moment'

export const TodoComponent = () => {

  let authContext = useAuth()

  let navigate = useNavigate();

  const { id } = useParams()

  let [description, setDescription] = useState('')
  let [targetDate, setTargetDate] = useState(null)

  useEffect(() => refreshTodo(), [id])

  function refreshTodo() {
    if (id !== -1) {
      retrieveTodoByUsernameAndId(authContext.username, id).then(response => {
        setDescription(response.data.description)
        setTargetDate(response.data.targetDate)
      })
    }
  }

  function onSubmit(values) {
    let todoObject = {
      id: id,
      description: values.description,
      targetDate: values.targetDate,
      isDone: false,
      username: authContext.username
    }
    console.log(todoObject);

    if (id === '-1') {
      createTodo(authContext.username, todoObject).then(response => {
        navigate(`/todos`)
      })
    }
    else {
      updateTodoByUsernameAndId(authContext.username, id, todoObject).then(response => {
        navigate(`/todos`)
      })
    }
  }

  function validate(values) {
    let errors = {}

    if (values.description.length < 10) {
      errors.description = 'Enter atleast 10 characters'
    }

    if (moment(values.targetDate).diff(moment()) < 0
      || values.targetDate === ''
      || values.targetDate === null
    ) {
      errors.targetDate = 'Enter a future date'
    }

    return errors
  }

  return (
    <div>
      <h1>Todo</h1>
      <Formik
        initialValues={{
          description,
          targetDate
        }}
        enableReinitialize
        validateOnBlur={false}
        validateOnChange={false}
        onSubmit={onSubmit}
        validate={validate}
      >
        <Form>

          <ErrorMessage name='description' component="div" className="alert alert-warning" />
          <ErrorMessage name='targetDate' component="div" className="alert alert-warning" />

          <label htmlFor="description">Description</label>
          <Field className="form-control" type="text" id="description" name="description" placeholder="description" />

          <label htmlFor="targetDate">Target Date</label>
          <Field className="form-control" type="date" id="targetDate" name="targetDate" placeholder="targetDate" />

          <button type="submit" className="btn btn-success mt-2">Submit</button>
        </Form>
      </Formik>
    </div>
  )
}
