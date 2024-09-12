import {useEffect, useState} from 'react';

const MultipleReturnsBasics = () => {
    const [text, setText] = useState("Loading...");

    useEffect(() => {
        setTimeout(() => {
            setText("My App")
        }, 3000)
    }, []);

    return <h2>{text}</h2>;
};
export default MultipleReturnsBasics;
