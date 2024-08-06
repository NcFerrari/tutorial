import {media, pageLinks} from "../data"
import PropTypes from 'prop-types';

const Links = ({ulLinkStyle, ulIconStyle, liLinkStyle, liIconStyle}) => {
    return <>
        <ul className={ulLinkStyle}>
            {pageLinks.map((link) => {
                return <Menu key={link.id} {...link} style={liLinkStyle}/>
            })}
        </ul>
        <ul className={ulIconStyle}>
            {media.map((link) => {
                return <Icons key={link.id} {...link} style={liIconStyle}/>
            })}
        </ul>
    </>
}

const Menu = ({href, text, style}) => {
    return <li>
        <a href={href} className={style}>{text}</a>
    </li>

}

const Icons = ({href, icon, style}) => {
    return <li>
        <a href={href} target={"_blank"} className={style}>
            <i className={icon}></i>
        </a>
    </li>
}

//validation

Links.propTypes = {
    ulLinkStyle: PropTypes.string.isRequired,
    ulIconStyle: PropTypes.string.isRequired,
    liLinkStyle: PropTypes.string.isRequired,
    liIconStyle: PropTypes.string.isRequired
}
Menu.propTypes = {
    href: PropTypes.string.isRequired,
    text: PropTypes.string.isRequired,
    style: PropTypes.string.isRequired
}
Icons.propTypes = {
    href: PropTypes.string.isRequired,
    icon: PropTypes.string.isRequired,
    style: PropTypes.string.isRequired
}

export default Links