const ErrorExample = () => {
    let count = 0;

    const clickListener = () => {
        count++;
        console.log(count);
    }

    return <>
        <h2>{count}</h2>
        <button type={"button"} onClick={clickListener}>increase</button>
    </>
};

export default ErrorExample;
