/* eslint-disable react/prop-types */
import DataContext from "./DataContext";
import { useState, useEffect } from "react";

const DataContextProvider = ({children}) => {
    const [types, setTypes] = useState([]);
    const [makes, setMakes] = useState([]);
    const [usages, setUsages] = useState([]);

    useEffect(() => {
        const loadData = async () => {
            const types = await getData('http://localhost:8080/api/quote/types');
            const makes = await getData('http://localhost:8080/api/quote/makes');
            const usages = await getData('http://localhost:8080/api/quote/usages');
            
            setTypes(types.sort().map(type => type.trim()));
            setMakes(makes.sort().map(make => make.trim()));
            setUsages(usages.sort().map(usage => usage.trim()));
        }
        
        loadData();
    }, []);

    const data = {
        types: types,
        makes: makes,
        usages: usages
    }

    return (
        <DataContext.Provider value={data}>
            {children}
        </DataContext.Provider>
    )
}

async function getData(url) {
    const response = await fetch(url);
    return await response.json();
}

export default DataContextProvider