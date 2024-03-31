import { useNavigate } from "react-router-dom";

function NotFoundComponent() {

    const navigate = useNavigate()

    function handleBackButton() {
        navigate('/')
    }

    return (
        <div className="container">
            <h1>Not found page!!!</h1>
            <button className="btn btn-primary" onClick={handleBackButton}>Go back</button>
        </div>
    )
}

export default NotFoundComponent;