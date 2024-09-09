import {useState} from "react";

const ControlledInputs = () => {

    const [name, setName] = useState("")
    const [email, setEmail] = useState("")

    const logging = (evt) => {
        setName(evt.target.value);
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(name, email);
    }

    return <div>
        <form className={"form"} onSubmit={handleSubmit}>
            <h4>controlled inputs</h4>
            <Input title="name" callback={logging}/>
            <Input title="email" typ={"email"} callback={(evt) => setEmail(evt.target.value)}/>
            <button type={"submit"} className={"btn btn-block"}>Submit</button>
        </form>
    </div>
};

const Input = ({title = "EmptyName", typ = "text", callback}) => {
    return <div className={"form-row"}>
        <label htmlFor={title} className={"form-label"}>{title}</label>
        <input type={typ} className={"form-input"} id={title} onChange={callback}/>
    </div>
}
export default ControlledInputs;
