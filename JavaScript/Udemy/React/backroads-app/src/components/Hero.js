import {FakeParagraph} from "./MockData";

const Hero = () => {
    return (
        <section className="hero" id="home">
            <div className="hero-banner">
                <h1>Backroads app</h1>
                <FakeParagraph/>
                <a href="#tours" className="btn hero-btn">explore tours</a>
            </div>
        </section>
    )
}

export default Hero;