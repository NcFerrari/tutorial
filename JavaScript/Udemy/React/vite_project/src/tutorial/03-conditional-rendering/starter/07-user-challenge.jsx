import {useState} from "react";

const UserChallenge = () => {

    const [logged, setLogged] = useState(false);

    const users = [
        {name: "vegan food truck"},
        {name: "Lubor"},
        {name: "Luboš"},
        {name: "Roman"},
        {name: "Radek"},
        {name: "Pavel"},
        {name: "Kulík"},
    ]

    return <div>
        {logged ? <LoggedForm user={users[Math.floor(Math.random() * users.length)]}/> : <LoginForm/>}
        <button className={"btn"} onClick={() => setLogged(!logged)}>
            {logged ? "logout" : "login"}
        </button>
    </div>
};

const LoggedForm = ({user}) => {
    return <div>
        <h4>hello there, {user.name}</h4>
    </div>
}

const LoginForm = () => {
    return <div>
        <h4>Please Login</h4>
    </div>
}

export default UserChallenge;
