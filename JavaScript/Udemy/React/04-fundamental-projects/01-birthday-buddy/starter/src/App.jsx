import data from "./data.js"

const App = () => {

    const getBirthdaysCount = () => {
        const count = data.length;
        return count > 1 ? count + " birthdays" : (count === 0 ? "no birthday" : count + " birthday");
    }

    return <div>
        <h2>{getBirthdaysCount()} today</h2>
        {data.map((personData) => {
            return <div key={personData.id}>
                <Person {...personData}/>
            </div>
        })}
        <button className={"btn btn-block"}>clear all</button>
    </div>
};

const Person = ({name, age, image}) => {
    return <div>
        <img src={image} style={{width: "56px", height: "56px"}}/>
        <h5>{name}</h5>
        <p>{age} {age > 1 ? "years" : "year"}</p>
    </div>
}
export default App;
