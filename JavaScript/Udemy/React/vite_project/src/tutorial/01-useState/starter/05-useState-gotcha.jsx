import {useState} from "react";

const UseStateGotcha = () => {
    const [value, setValue] = useState(0);

    const metoda = () => {
        setTimeout(() => {
            setValue(value + 1)
        }, 3000)
    }

    const metoda2 = () => {
        setTimeout(() => {
            setValue((currentValue) => {
                return currentValue + 1
            })
        }, 3000)
    }

    return <>
        <h1>{value}</h1>
        <button className={"btn"} onClick={metoda}>increase</button>
        <button className={"btn"} onClick={metoda2}>increase all</button>
    </>
};

export default UseStateGotcha;
