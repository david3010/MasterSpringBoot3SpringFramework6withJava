import './TodoApp.css'
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'

// components
import FooterComponent from './components/FooterComponent'
import LoginComponent from "./components/LoginComponent";
import WelcomeComponent from "./components/WelcomeComponent";
import ListTodosComponent from "./components/ListTodosComponent";
import LogoutComponent from "./components/LogoutComponent";
import NotFoundComponent from "./components/NotFoundComponent";
import HeaderComponent from "./components/HeaderComponent";

// security
import AuthProvider, { useAuth } from './security/AuthContext';
import { TodoComponent } from './components/TodoComponent';

function AuthenticatedRoute({ children }) {
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;
    if (isAuthenticated) {
        return children;
    } else {
        return <Navigate to="/" />
    }
}

function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/dashboard/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListTodosComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='/todo/:id' element={
                            <AuthenticatedRoute>
                                <TodoComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='/logout' element={<LogoutComponent />} />

                        <Route path='/*' element={<NotFoundComponent />} />
                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}

export default TodoApp