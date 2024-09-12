import img1 from "./images/tour-1.jpeg"
import img2 from "./images/tour-2.jpeg"
import img3 from "./images/tour-3.jpeg"
import img4 from "./images/tour-4.jpeg"
import img5 from "./images/tour-5.jpeg"
import img6 from "./images/tour-6.jpeg"
import {FakeParagraph} from "./components/MockData";

export const pageLinks = [
    {
        id: 0,
        href: "#home",
        text: "home"
    },
    {
        id: 1,
        href: "#about",
        text: "about"
    },
    {
        id: 2,
        href: "#services",
        text: "services"
    },
    {
        id: 3,
        href: "#tours",
        text: "tours"
    },
]

export const media = [
    {id: 0, href: "https://www.facebook.com", icon: "fab fa-facebook"},
    {id: 1, href: "https://www.twitter.com", icon: "fab fa-twitter"},
    {id: 2, href: "https://www.squarespace.com", icon: "fab fa-squarespace"}
]

export const services = [
    {
        id: 0,
        icon: "fas fa-wallet fa-fw",
        title: "saving money",
        text: <FakeParagraph/>
    },
    {
        id: 1,
        icon: "fas fa-tree fa-fw",
        title: "endless hiking",
        text: <FakeParagraph/>
    },
    {
        id: 2,
        icon: "fas fa-socks fa-fw",
        title: "amazing comfort",
        text: <FakeParagraph/>
    }
]

export const tours = [
    {
        id: 0,
        image: img1,
        date: "august 26th, 2020",
        title: "Tibet Adventure",
        text: <FakeParagraph/>,
        country: "china",
        days: 6,
        price: 2100
    },
    {
        id: 1,
        image: img2,
        date: "october 1th, 2020",
        title: "best of java",
        text: <FakeParagraph/>,
        country: "indonesia",
        days: 11,
        price: 1400
    },
    {
        id: 2,
        image: img3,
        date: "september 15th, 2020",
        title: "explore hong kong",
        text: <FakeParagraph/>,
        country: "hong kong",
        days: 8,
        price: 5000
    },
    {
        id: 3,
        image: img4,
        date: "december 5th, 2019",
        title: "kenya highlights",
        text: <FakeParagraph/>,
        country: "kenya",
        days: 20,
        price: 3300
    },
    {
        id: 4,
        image: img5,
        date: "?",
        title: "?",
        text: <FakeParagraph/>,
        country: "?",
        days: 0,
        price: 0
    },
    {
        id: 5,
        image: img6,
        date: "?",
        title: "?",
        text: <FakeParagraph/>,
        country: "?",
        days: 0,
        price: 0
    }
]