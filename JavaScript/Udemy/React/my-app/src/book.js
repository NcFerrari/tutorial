function Book() {
    return (
        <article className={"book"}>
            <Image/>
            <Title/>
            <Author/>
        </article>
    )
}

const Image = () => {
    // return <img src={"https://images-na.ssl-images-amazon.com/images/I/81ytGlIkLoL._AC_UL900_SR900,600_.jpg"}
    return <img src={"./images/book.jpg"}
                alt={"Hillbilly Elegy: A Memoir of a Family and Culture in Crisis"}/>
}

const Title = () => {
    return <h2>Hillbilly Elegy: A Memoir of a Family and Culture in Crisis</h2>
}

const Author = () => {
    return <h4 style={{color: '#617d98', fontSize: '0.75', marginTop: '0.5rem'}}>J. D. Vance</h4>
}

// druhý zápis stylu. Protože ty druhé složené závorky = objekt, můžeme si jej nejdřív připravit
const Author2 = () => {
    const inlineStyle = {
        color: '#617d98',
        fontSize: '0.75',
        marginTop: '0.5rem'
    }
    return <h4 style={inlineStyle}>J. D. Vance</h4>
}

export default Book