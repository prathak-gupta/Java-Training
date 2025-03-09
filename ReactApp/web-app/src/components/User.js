import { useParams } from "react-router-dom";

function User()
{
    let {username} = useParams();
    return(
        <h1>Welcome, {username}</h1>
    )
}

export default User;