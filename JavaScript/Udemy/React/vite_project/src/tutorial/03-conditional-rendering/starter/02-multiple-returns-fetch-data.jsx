import {useEffect, useState} from 'react';

const url = 'https://api.github.com/users/QuincyLarson';

const MultipleReturnsFetchData = () => {

    const [loading, setLoading] = useState(true)
    const [user, setUser] = useState(null);
    const [isError, setIsError] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const resp = await fetch(url);
                if (!resp.ok) {
                    setIsError(true);
                    setLoading(false)
                    return
                }
                const user = await resp.json();
                setUser(user)
                setLoading(false)
            } catch (exp) {
                console.log(exp)
            }
        }
        fetchData();
    }, [])

    if (loading) {
        return <h2>Loading...</h2>
    } else if (isError) {
        return <h2>there was an error...</h2>
    }
    return <div>
        <img style={{width: "150px", borderRadius: "25px"}} src={user.avatar_url} alt={user.name}/>
        <h2>{user.name}</h2>
        <h4>works at {user.company}</h4>
        <p>{user.bio}</p>
    </div>
};
export default MultipleReturnsFetchData;
