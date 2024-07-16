import React from 'react';
import ReactDom from 'react-dom/client';
import Test from './alfa';

const Alfa = () => {
    return <h1 className={"style"}>My First Component</h1>
}

const Beta = () => {
    return React.createElement("a", {href: "https://youtube.com"}, "test")
}

const Gama = () => {
    return (
        <div>
            <div>
                <h2>Test</h2>
            </div>
        </div>
    )
}

// Musíme v komponentně vždy vracet jeden element
const Delta = () => {
    return (
        <div>
            <h3>List of fruits</h3>
            <ul>
                <li>Apple</li>
                <li>Orange</li>
                <li>Banana</li>
            </ul>
        </div>
    )
}

const Epsilon = () => {
    return (
        <div>
            <h1>Test</h1>
            <input type="text"/>
            <button onClick={null}>test</button>
        </div>
    )
}

const Zeta = () => {
    return <ZetaComponent></ZetaComponent>
}

const ZetaComponent = () => <h2>text pro zétu</h2>


const root = ReactDom.createRoot(document.getElementById('root'))
root.render(<Alfa></Alfa>)
root.render(<Beta></Beta>)
root.render(<Gama></Gama>)
root.render(<Delta></Delta>)
root.render(<Epsilon></Epsilon>)
root.render(<Zeta></Zeta>)