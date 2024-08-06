import logo from "../images/logo.svg"

import Links from "./Links";

const Navbar = () => {
    return <nav className="navbar">
        <div className="nav-center">
            <div className="nav-header">
                <img src={logo} className="nav-logo" alt="backroads"/>
                <button type="button" className="nav-toggle" id="nav-toggle">
                    <i className="fas fa-bars"></i>
                </button>
            </div>

            <Links ulLinkStyle="nav-links" ulIconStyle="nav-icons" liLinkStyle="nav-link" liIconStyle="nav-icon"/>
        </div>
    </nav>
}

export default Navbar