import {people} from "/src/data.js"
import Person from "./Person.jsx";

const List = () => {

    return <div>
        {people.map((person) => {
            return <Person key={person.id} {...person}/>
        })}
    </div>
}

export default List