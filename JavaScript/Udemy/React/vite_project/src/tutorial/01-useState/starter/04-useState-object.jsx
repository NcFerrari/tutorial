import {useState} from 'react';

let index = 1;

const UseStateObject = () => {

    const persons = [
        {
            name: "peter",
            age: 24,
            hobby: "read books"
        },
        {
            name: "john",
            age: 28,
            hobby: "scream at the computer"
        },
        {
            name: "lubor",
            age: 34,
            hobby: "kdo ví"
        },
    ]

    const [person, setPerson] = useState(persons[0])

    const displayPerson = () => {
        setPerson(persons[index++])
        if (index === persons.length) {
            index = 0;
        }
    }

    return <>
        <h3>{person.name}</h3>
        <h3>{person.age}</h3>
        <h4>Enjoys: {person.hobby}</h4>
        <button className={"btn"} onClick={displayPerson}>Show {persons[index].name}</button>
    </>
};

export default UseStateObject;
