import { createContext, useContext, useState } from "react"
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService"
import { clientURL } from "../api/ApiClient"

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

function AuthProvider({ children }) {

    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUserName] = useState(null)
    const [token, setToken] = useState(null)

    // function login(username, password) {
    //     if (username === 'in28Minutes' & password === 'dummy' || (username === 'admin' & password === 'admin')) {
    //         setAuthenticated(true)
    //         setUserName(username)
    //         return true
    //     } else {
    //         setAuthenticated(false)
    //         setUserName(null)
    //         return false
    //     }
    // }

    async function login(username, password) {

        const baToken = 'Basic ' + window.btoa(username + ":" + password)

        try {
            const response = await executeBasicAuthenticationService(baToken)

            if (response.status === 200) {
                setAuthenticated(true)
                setUserName(username)
                setToken(baToken)

                clientURL.interceptors.request.use((config) => {
                    config.headers.Authorization=baToken
                    return config
                });

                return true
            } else {
                logout()
                return false
            }
        } catch (error) {
            logout()
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
        setUserName(null)
        setToken(null)
    }

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout, username, token }}>
            {children}
        </AuthContext.Provider >
    )
}

export default AuthProvider