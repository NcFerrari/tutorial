import {useState} from 'react';

const ShortCircuitExamples = () => {
    // falsy
    const [text, setText] = useState('');
    // truthy
    const [name, setName] = useState('susan');
    const [user, setUser] = useState({name: "john"});
    const [isEditing, setIsEditing] = useState(false);

    return <div>
        <h2>{text || "default value"}</h2>
        {user && <UserComponent name={user.name}/>}
        <div>
            <h2 style={{margin: "1rem 0"}}>Ternary Operator</h2>
            <button className={"btn"}>{isEditing ? "edit" : "add"}</button>
            {user ? <div>
                <h4>hello there user {user.name}</h4>
            </div> : <div><h2>please login</h2></div>}
        </div>
    </div>
};

const UserComponent = ({name}) => {
    return <div>
        <h2>whatever return</h2>
        <h2>{name}</h2>
    </div>
}

const TernaryComponent = () => {
    return
}

export default ShortCircuitExamples;
