import {useState} from "react";
import {data} from "../../../data.js"

const UserChallenge = () => {

    const [users, setUsers] = useState(data);
    const [newName, setNewName] = useState("");

    const removeUser = (userId) => {
        setUsers(users.filter((user) => user.id !== userId));
    }

    const addUserToList = (evt) => {
        evt.preventDefault();
        if (newName) {
            setUsers([...users, {name: newName, id: Date.now()}])
            setNewName("")
        }
    }

    return (<div>
        <form className='form' onSubmit={addUserToList}>
            <h4>Add User</h4>
            <div className='form-row'>
                <label htmlFor='name' className='form-label'>
                    name
                </label>
                <input type='text' value={newName} className='form-input' id='name'
                       onChange={(evt) => setNewName(evt.target.value)}/>
            </div>

            <button type='submit' className='btn btn-block'>
                submit
            </button>
        </form>
        <Users users={users} callback={removeUser}/>
    </div>);
};

const Users = ({users, callback}) => {
    return <>
        <h2>Users</h2>
        {users.map((user) => {
            return <User key={user.id} {...user} removeUser={callback}/>
        })}
    </>
}

const User = ({name, id, removeUser}) => {
    return <div>
        <h4>{name}</h4>
        <button className={"btn"} onClick={() => removeUser(id)}>Remove</button>
    </div>
}
export default UserChallenge;
