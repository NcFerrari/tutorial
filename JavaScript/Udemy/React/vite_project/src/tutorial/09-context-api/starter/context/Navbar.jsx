import {useState, createContext} from "react";
import {NavLinks} from "./index.jsx";

export const NavbarContext = createContext();

const Navbar = () => {

    const [user, setUser] = useState({name: "Lubor"});

    function logout() {
        setUser(null)
    }

    return <NavbarContext.Provider value={{user, logout}}>
        <nav className={"navbar"}>
            <h5>CONTEXT API</h5>
            <NavLinks/>
        </nav>
    </NavbarContext.Provider>
}

export default Navbar;