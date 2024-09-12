import PropTypes from "prop-types";

const Title = ({firstName, secondName}) => {
    return (
        <div className="section-title">
            <h2>{firstName} <span>{secondName}</span></h2>
        </div>
    )
}

//validation

Title.propTypes = {
    firstName: PropTypes.string.isRequired,
    secondName: PropTypes.string.isRequired
}

export default Title