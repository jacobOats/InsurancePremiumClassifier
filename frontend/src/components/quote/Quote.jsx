/* eslint-disable react/prop-types */
import { Navbar1 } from "../navbar1/Navbar1"
import DataContext from "../../stores/DataContext"
import { Link } from "react-router-dom"
import style from './Quote.module.css'
import { useContext, useState } from "react"

const defaultQuote = {
    sex: "",
    insuranceBegin: "",
    insuranceEnd: "",
    insuredValue: "",
    prodYear: "",
    numSeats: 0,
    type: "",
    make: "",
    usage: ""
}

const Quote = () => {
    const [price, setPrice] = useState(0);
    const [retrieved, setRetrieved] = useState(false);
    const [retrieving, setRetrieving] = useState(false);
    const [quote, setQuote] = useState(defaultQuote);
    
    const handleChange = (event) => {
        const target = event.target;
        const id = target.id;
        const value = target.value;
        setQuote(prevQuote => ({...prevQuote, [id]: value}));
    }

    const handleSubmit = async (event) => {
        setRetrieving(true);

        event.preventDefault();
        if (readyToSubmit(quote)) {
            const dto = {...quote};
            dto.insuranceBegin = convertDate(dto.insuranceBegin);
            dto.insuranceEnd = convertDate(dto.insuranceEnd);

            const response = await fetch('http://localhost:8080/api/quote', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dto)
            })

            if (response.status >= 200 && response.status < 400) {
                const price = await response.json();
                setRetrieving(false);
                setRetrieved(true);
                setPrice(Math.round(price.premium));
            } else {
                
            }
        }
    }

    const handleNewQuote = () => {
        setRetrieved(false);
        setRetrieving(false);
        setQuote(defaultQuote);
        setPrice(0);       
    }

    let Component = null;
    if (!retrieved && retrieving) {
        Component = <Loading />
    } else if (retrieved && !retrieving) {
        Component = (
            <Display price={price} onClick={handleNewQuote}/>
        )
    } else {
        Component = (
            <Form 
                quote={quote} 
                handleChange={handleChange}
                handleSubmit={handleSubmit}
            />
        )
    }
    
    return (
        <main>
            <Navbar1/>

            {Component}
        </main>
    )
}

function readyToSubmit(quote) {
    let readyToSubmit = true;
    for (let entry of Object.entries(quote)) {
        if (entry[1].length === 0) {
            readyToSubmit = false;
            break;
        }
    }

    return readyToSubmit;
}

const months = ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'];

function convertDate(date) {
    const components = date.split("-");
    let year = components[0];
    let month = components[1];
    let day = components[2];

    year = year.substring(2);
    month = months[Number.parseInt(month) - 1];

    return `${day}-${month}-${year}`;
}

const Loading = () => {
    return (
        <div className={style.animationContainer}>
            <div className={style.ballContainer}>
                <div className={style.first}></div>
                <div className={style.second}></div>
                <div className={style.third}></div>
            </div>
        </div>
    )
}

const Form = ({quote, handleChange, handleSubmit}) => {
    const dataContext = useContext(DataContext);

    return (
        <form className={style.container}>
            <div>
                <label htmlFor='sex'>Sex:</label>
                <select id='sex' value={quote.sex} onChange={handleChange}>
                    <option hidden>Choose a sex</option>
                    <option value='0'>Female</option>
                    <option value='1'>Male</option>
                </select>
            </div>

            <div>
                <label htmlFor='insuranceBegin'>Insurance Start Date:</label>
                <input id='insuranceBegin' type='date' value={quote.insuranceBegin} onChange={handleChange}/> 
            </div>

            <div>
                <label htmlFor='insuranceEnd'>Insurance End Date:</label>
                <input id='insuranceEnd' type='date' value={quote.insuranceEnd} onChange={handleChange}/>
            </div>

            <div>
                <label htmlFor='insuredValue'>Insured Value:</label>
                <input id='insuredValue' type='number' value={quote.insuredValue} min={1} max={1000000} onChange={handleChange}/>
            </div>

            <div>
                <label htmlFor='usage'>Usage:</label>
                <select id='usage' value={quote.usage} onChange={handleChange}>
                    <option hidden>Choose a usage</option>
                    {dataContext.usages.map(usage => (
                        <option key={usage} value={usage}>{usage}</option>
                    ))}
                </select>
            </div>

            <div>
                <label htmlFor='make'>Make:</label>
                <select id='make' value={quote.make} onChange={handleChange}>
                    <option hidden>Choose a make</option>
                    {dataContext.makes.map(make => (
                        <option key={make} value={make}>{make}</option>
                    ))}
                </select>
            </div>

            <div>
                <label htmlFor='type'>Type:</label>
                <select id='type' value={quote.type} onChange={handleChange}>
                    <option hidden>Choose a type</option>
                    {dataContext.types.map(type => (
                        <option key={type} value={type}>{type}</option>
                    ))}
                </select>
            </div>

            <div>
                <label htmlFor='prodYear'>Production Year:</label>
                <input id='prodYear' type='text' value={quote.prodYear} onChange={handleChange}/>
            </div>

            <div>
                <label htmlFor='numSeats'>Num Seats:</label>
                <input id='numSeats' type='number' max={8} min={2} value={quote.numSeats} onChange={handleChange}/>
            </div>

            <input type='submit' value='Get Quote' onClick={handleSubmit}/>
        </form>
    )
}

const Display = ({price, onClick}) => {
    
    return (
        <div>
            <h1>Premium: ${price}</h1>
            <div className={style.options}>
                <Link to='/'>
                    <button>Home</button>
                </Link>

                <button onClick={onClick}>New Quote</button>
            </div>
        </div>
    )
}

export default Quote