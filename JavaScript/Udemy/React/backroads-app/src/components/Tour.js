import PropTypes from "prop-types";

const Tour = ({image, date, title, text, country, days, price}) => {
    return <article className="tour-card">
        <div className="tour-img-container">
            <img src={image} className="tour-img" alt={title} title={title.toUpperCase()}/>
            <p className="tour-date">{date}</p>
        </div>
        <div className="tour-info">
            <div className="tour-title">
                <h4>{title}</h4>
            </div>
            <p>{text}</p>
            <div className="tour-footer">
                <p>
                    <span><i className="fas fa-map"></i></span> {country}
                </p>
                <p>{days} days</p>
                <p>From ${price}</p>
            </div>
        </div>
    </article>
}
// validation
Tour.propTypes = {
    image: PropTypes.string.isRequired,
    date: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    text: PropTypes.object.isRequired,
    country: PropTypes.string.isRequired,
    days: PropTypes.number.isRequired,
    price: PropTypes.number.isRequired
}

export default Tour