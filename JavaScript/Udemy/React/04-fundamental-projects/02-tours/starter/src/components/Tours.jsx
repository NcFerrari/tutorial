import Tour from "./Tour.jsx";

const Tours = ({tours, removeTour}) => {
    const buttons = Array.from({length: 10});
    return <div>
        <h2>our tours</h2>
        {tours.sort((a, b) => a.price.localeCompare(b.price)).map((tour) => {
            return <Tour key={tour.id} {...tour} removeTour={removeTour}/>
        })}
        {buttons.map((nothing, index) => {
            return <p style={{margin: "5px 0"}} key={index}>
                <button className={"test"}>test</button>
            </p>
        })}
    </div>
}

export default Tours;