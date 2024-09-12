import users from "./data.js"
import {useState} from "react";

const App = () => {

    const [data, setData] = useState(users);

    const getBirthdaysCount = () => {
        const count = data.length;
        return count > 1 ? count + " birthdays" : (count === 0 ? "no birthday" : count + " birthday");
    }

    const removeData = () => {
        setData([])
    }

    return <div>
        <h2>{getBirthdaysCount()} today</h2>
        <List data={data}/>
        <button className={"btn btn-block"} onClick={removeData}>clear all</button>
    </div>
};

const List = ({data}) => {
    return <div>{data.map((personData) => {
        return <div key={personData.id}>
            <Person {...personData}/>
        </div>
    })
    }</div>
}

const Person = ({name, age, image}) => {
    return <div>
        <img src={image} style={{width: "56px", height: "56px"}}/>
        <h5>{name}</h5>
        <p>{age} {age > 1 ? "years" : "year"}</p>
    </div>
}
export default App;
