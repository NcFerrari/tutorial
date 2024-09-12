import {data} from "../../../data.js";
import React from "react";

const UseStateArray = () => {

    const [people, setPeople] = React.useState(data);

    const removeItem = (id) => {
        setPeople(people.filter((person) => person.id !== id))
    }

    function clearItems() {
        setPeople([])
    }

    function resetItems() {
        setPeople([...data])
    }

    return <div>
        {people.map((person) => {
            const {id, name} = person
            return <div key={id}>
                <h4>{name}</h4>
                <button
                    onClick={() => removeItem(id)}>
                    remove
                </button>
            </div>
        })}
        <button
            style={{marginTop: "2rem"}}
            className={"btn"}
            onClick={clearItems}>
            clear items
        </button>
        <button
            style={{marginLeft: "2rem"}}
            className={"btn"}
            onClick={resetItems}>
            reset items
        </button>
    </div>
}

export default UseStateArray;
