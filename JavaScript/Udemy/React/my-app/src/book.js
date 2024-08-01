const Book = (props) => {
    const {image, title, author, number} = props
    return (
        <article className={"book"}>
            <span className={"number"}>{number + 1}</span>
            <Image image={image} title={title}/>
            <Title title={title}/>
            <Author author={author}/>
            {props.children}
        </article>
    )
}

const Image = (props) => {
    // return <img src={"https://images-na.ssl-images-amazon.com/images/I/81ytGlIkLoL._AC_UL900_SR900,600_.jpg"}
    return <img src={props.image} alt={props.title}/>
}

const Title = (props) => {
    return <h2>{props.title}</h2>
}

const Author = (props) => {
    return <h4 style={{color: '#617d98', fontSize: '0.75', marginTop: '0.5rem'}}>{props.author}</h4>
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

const pow = (x, y) => {
    let sum = x;
    for (let i = 1; i < y; i++) {
        sum *= x;
    }
    console.log(sum)
}

pow(3, 2)

export default Book