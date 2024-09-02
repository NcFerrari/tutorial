const Person = ({name, nickName = "shakeAndBake", images}) => {

    const img = images?.[0]?.small?.url || "/src/assets/default-avatar.svg";

    return <div>
        <img src={img} alt={name} style={{width: "50px"}}/>
        <h4>{name}</h4>
        <p>Nickname : {nickName}</p>
    </div>
}

export default Person