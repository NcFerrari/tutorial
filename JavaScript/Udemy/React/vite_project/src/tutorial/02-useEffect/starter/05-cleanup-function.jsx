import {useEffect, useState} from "react"

const CleanupFunction = () => {

    const [toggle, setToggle] = useState(false);
    return <>
        <button className={"btn"} onClick={() => setToggle(!toggle)}>toggle component</button>
        {toggle && <Thread/>}
    </>
};

const Thread = () => {
    useEffect(() => {
        const loop = setInterval(() => {
            console.log("hello from interval")
        }, 1000);
        return () => clearInterval(loop);
    }, []);
    return <div>
        <h1>hello there</h1>
    </div>
}

export default CleanupFunction;
