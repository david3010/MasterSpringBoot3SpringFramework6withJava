import { Link, useParams } from "react-router-dom";


function WelcomeComponent() {
    const { username } = useParams()

    return (<>
        <div className="WelcomeComponent">
            <h1>Wellcome {username}</h1>
            <p>
                Manage your todos - <Link to="/todos">Go here</Link>
            </p>
        </div>
    </>)
}

export default WelcomeComponent;