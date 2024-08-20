import React, {useState} from 'react';
import {keyWords} from "./keyWords.jsx"
import ReactDOM from 'react-dom/client'

let textInTextArea;

const Formular = () => {
    return <>
        <TextArea/>
        <br/>
        <Button/>
    </>
}

const TextArea = () => {
    const [text, setText] = useState('');

    const handleKeyDown = (e) => {
        if (e.key === 'Tab') {
            e.preventDefault();
            const start = e.target.selectionStart;
            const end = e.target.selectionEnd;

            textInTextArea = text.substring(0, start) + "    " + text.substring(end);
            setText(textInTextArea);

            setTimeout(() => {
                e.target.selectionStart = e.target.selectionEnd = start + 4;
            }, 0);
        }
    };

    const handleKeyUp = () => {
        textInTextArea = text;
    }

    return (<textarea
        value={text}
        onChange={(e) => setText(e.target.value)}
        onKeyDown={handleKeyDown}
        onKeyUp={handleKeyUp}
        style={{width: '75%', height: '200px'}}
    />);
}

const Button = () => {
    function code() {
        keyWords.map((word) => {
            let regex = new RegExp(`\\b${word}\\b`, 'g');
            textInTextArea = textInTextArea.replaceAll(regex, `<${"kw"}>${word}</${"kw"}>`);
        })

        let newText = "";
        textInTextArea.split('"').map((block, index) => {
            if (index % 2 == 0) {
                newText += block + '<text>"'
            } else {
                newText += block + '"</text>'
            }
        })
        textInTextArea = newText.slice(0, -1);

        textInTextArea = textInTextArea.replaceAll(/\d+/g, '<number>$&</number>');

        document.getElementById("output").innerHTML = textInTextArea;
    }

    return <input type={"button"} value={"Formatuj"} onClick={code}/>
}

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <Formular/>
    </React.StrictMode>,
)