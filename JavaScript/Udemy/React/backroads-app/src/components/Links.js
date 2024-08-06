import {media, pageLinks} from "../data"

const Links = ({ulLinkStyle, ulIconStyle, liLinkStyle, liIconStyle}) => {
    return <>
        <ul className={ulLinkStyle}>
            {pageLinks.map((link) => {
                return <Menu id={link.id} href={link.href} text={link.text} style={liLinkStyle}/>
            })}
        </ul>
        <ul className={ulIconStyle}>
            {media.map((link) => {
                return <Icons id={link.id} href={link.href} icon={link.icon} style={liIconStyle}/>
            })}
        </ul>
    </>
}

const Menu = ({id, href, text, style}) => {
    return <li key={id}>
        <a href={href} className={style}>{text}</a>
    </li>

}

const Icons = ({id, href, icon, style}) => {
    return <li key={id}>
        <a href={href} target={"_blank"} className={style}>
            <i className={icon}></i>
        </a>
    </li>
}

export default Links