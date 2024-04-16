
import { Link, useParams } from "react-router-dom";
import { retrieveHelloWorldBean, retrieveHelloWorldBeanPathVariable } from "../api/HelloWorldApiService";
import { useAuth } from "../security/AuthContext";


function WelcomeComponent() {
    const { username } = useParams()

    const authContext = useAuth();

    function callHelloWorldRestApi() {
        retrieveHelloWorldBean(authContext.token).then(response => console.log(response));
        retrieveHelloWorldBeanPathVariable(username, authContext.token).then(response => console.log(response));
    }

    return (<>
        <div className="WelcomeComponent">
            <h1>Wellcome {username}</h1>
            <p>
                Manage your todos - <Link to="/todos">Go here</Link>
            </p>
            <button className="btn btn-outline-success" onClick={callHelloWorldRestApi}>
                Call HelloWorld Rest API
            </button>
        </div>
    </>)
}

export default WelcomeComponent;