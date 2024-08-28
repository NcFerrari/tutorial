import {useState} from "react";

const ToggleChallenge = () => {

    const [toggle, setToggle] = useState(false);

    return <div>
        <button className={"btn"} onClick={() => setToggle(!toggle)}>toggle alert</button>
        {toggle && <Alert/>}
    </div>
};

const Alert = () => {
    return <div className={"alert alert-danger"}>
        hello world
    </div>
}

export default ToggleChallenge;
