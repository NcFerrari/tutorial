import {useEffect, useState} from 'react';

const url = 'https://api.github.com/users/QuincyLarson';

const MultipleReturnsFetchData = () => {

    const [loading, setLoading] = useState(true)
    const [user, setUser] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const resp = await fetch(url);
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
        return <div>Loading...</div>
    }
    return <div>
        <img style={{width: "150px", borderRadius: "25px"}} src={user.avatar_url} alt={user.name}/>
        <h2>{user.name}</h2>
        <h4>works at {user.company}</h4>
        <p>{user.bio}</p>
    </div>
};
export default MultipleReturnsFetchData;
