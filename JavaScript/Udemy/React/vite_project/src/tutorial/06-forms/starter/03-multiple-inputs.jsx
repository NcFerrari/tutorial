import {useState} from "react";

const formElements = [
    {id: 0, title: "Name", type: "text"},
    {id: 1, title: "Email", type: "email"},
    {id: 2, title: "Password", type: "password"},
]

const DefaultForm = ({title, type, callback}) => {
    const id = Date.now();
    return <div className={"form-row"}>
        <label className={"form-label"} htmlFor={title?.toLowerCase() + id}>{title}</label>
        <input className={"form-input"} name={title?.toLowerCase()} type={type} id={title?.toLowerCase() + id}
               onChange={callback}/>
    </div>
}

const MultipleInputs = () => {

    const [user, setUser] = useState({
        name: "",
        email: "",
        password: ""
    })

    const handleChange = (evt) => {
        setUser({...user, [evt.target.name]: evt.target.value})
    }

    return <div>
        <form className='form'>
            <h4>Multiple Inputs</h4>
            {formElements.map((element) => {
                return <DefaultForm key={element.id} {...element} callback={handleChange}/>
            })}
            <button type='submit' className='btn btn-block'>
                submit
            </button>
        </form>
    </div>
};

export default MultipleInputs;
