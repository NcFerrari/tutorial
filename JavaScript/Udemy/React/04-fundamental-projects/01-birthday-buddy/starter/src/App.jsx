import users from "./data.js"
import {useState} from "react";

const App = () => {

    const [data, setData] = useState(users);

    return <main>
        <div className={"container"}>
            <h2>{data.length === 0 ? "no" : data.length} birthday{data.length > 1 ? "s" : ""} today</h2>
            <List data={data}/>
            <button type={"button"} className={"btn btn-block"} onClick={() => setData([])}>clear all</button>
        </div>
    </main>
};

const List = ({data}) => {
    return <div>
        {data.map((personData) => {
            return <div key={personData.id}>
                <Person {...personData}/>
            </div>
        })
        }</div>
}

const Person = ({name, age, image}) => {
    return <article className={"person"}>
        <img src={image}/>
        <h4>{name}</h4>
        <p>{age} year{age > 1 ? "s" : ""}</p>
    </article>
}
export default App;
