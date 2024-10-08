import img from "../images/about.jpeg"
import Title from "./Title";
import {FakeParagraph} from "./MockData";

const About = () => {
    return (
        <section className="section" id="about">
            <Title firstName={"about"} secondName={"us"}/>

            <div className="section-center about-center">
                <div className="about-img">
                    <img
                        src={img}
                        className="about-photo"
                        alt="awesome beach"
                    />
                </div>
                <article className="about-info">
                    <h3>explore the difference</h3>
                    <p><FakeParagraph/></p>
                    <p><FakeParagraph/></p>
                    <div className="btn">read more</div>
                </article>
            </div>
        </section>
    )
}

export default About