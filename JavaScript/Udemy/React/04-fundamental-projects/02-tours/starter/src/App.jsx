import {useEffect, useState} from "react";
import {Tours, Loading} from "./components/";

const url = 'https://www.course-api.com/react-tours-project';

const App = () => {

    const [isLoading, setLoading] = useState(true);
    const [tours, setTours] = useState([]);

    const fetchTours = async () => {
        setLoading(true)
        try {
            const response = await fetch(url);
            const tours = await response.json();
            setTours(tours);
        } catch (error) {
            console.log(error)
        } finally {
            setLoading(false)
        }
    }

    const removeTour = (id) => {
        const newTours = tours.filter((tour) => {
            return tour.id !== id;
        });
        setTours(newTours);
    }

    useEffect(() => {
        fetchTours();
    }, [])

    if (isLoading) {
        return <main>
            <Loading/>
        </main>
    }

    if (tours.length === 0) {
        return <main>
            <div className={"title"}>
                <h2>no tours left</h2>
                <button className={"btn btn-block"} onClick={() => fetchTours()}>refresh</button>
            </div>
        </main>
    }

    return <main>
        <Tours tours={tours} removeTour={removeTour}/>
    </main>
};
export default App;
