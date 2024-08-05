const Title = ({firstName, secondName}) => {
    return (
        <div className="section-title">
            <h2>{firstName} <span>{secondName}</span></h2>
        </div>
    )
}

export default Title