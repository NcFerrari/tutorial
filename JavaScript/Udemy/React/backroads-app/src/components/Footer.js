import Links from "./Links";

const Footer = () => {
    return <footer className="section footer">
        <Links ulLinkStyle="footer-links" ulIconStyle="footer-icons" liLinkStyle="footer-link"
               liIconStyle="footer-icon"/>

        <p className="copyright">
            copyright &copy; Backroads travel tours company <span id="date">{new Date().getFullYear()}</span> all rights
            reserved
        </p>
    </footer>
}

export default Footer