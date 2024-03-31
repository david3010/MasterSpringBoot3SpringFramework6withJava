import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { useAuth } from '../security/AuthContext';

function LoginComponent() {

    let authContext = useAuth();

    let [username, setUsername] = useState('')
    let [password, setPassword] = useState('')
    const [showErrorMessage, setShowErrorMessage] = useState(false)

    const navigate = useNavigate()

    function handleUserNameChange(e) {
        setUsername(e.target.value)
    }

    function handlePasswordChange(e) {
        setPassword(e.target.value)
    }

    function submitForm() {
        if (authContext.login(username, password)) {
            navigate(`/dashboard/${username}`)
        } else {
            setShowErrorMessage(true)
        }
    }

    return (
        <div className="Login">

            <h1>Login</h1>
            {showErrorMessage && <div className="errorMessage">Authentication failed. Please check your credentials.</div>}

            <div className="LoginForm">
                <div>
                    <label>Username</label>
                    <input type="text" name="username" id="username" value={username} onChange={handleUserNameChange} />
                </div>
                <div>
                    <label>password</label>
                    <input type="password" name="password" id="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button className="btn btn-success" type="button" onClick={submitForm}>Submit</button>
                </div>
            </div>
        </div>
    )
}

export default LoginComponent;