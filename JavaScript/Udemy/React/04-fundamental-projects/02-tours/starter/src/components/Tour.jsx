import {useState} from "react";

const Tour = ({id, name, info, image, price, removeTour}) => {
    const [isFullText, setFullText] = useState(false);
    return <article className={"single-tour"}>
        <img src={image} alt={name} className={"img"}/>
        <span className={"tour-price"}>${price}</span>
        <div className={"tour-info"}>
            <h5>{name}</h5>
            <p>{isFullText ? info : `${info.substring(0, 255)}...`}
                <button type={"button"} className={"info-btn"}
                        onClick={() => setFullText(!isFullText)}>{isFullText ? "show less" : "read more"}</button>
            </p>
            <button type='button' className={"btn btn-block"} onClick={() => removeTour(id)}>Remove tour</button>
        </div>
    </article>
}

export default Tour;