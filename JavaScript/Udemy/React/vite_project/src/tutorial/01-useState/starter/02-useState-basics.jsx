import {useState} from "react";

const UseStateBasics = () => {
    const [value, increaseValue] = useState(0);
    const actionListener = () => {
        increaseValue(value + 1)
    }

    return <>
        <h4>You Clicked {value} Times</h4>
        <button type={"button"} className={"btn"} onClick={actionListener}>
            click me
        </button>
    </>
};

export default UseStateBasics;
