import { Link,useParams } from 'react-router-dom';
import { Navbar2 } from '../../navbar1/Navbar1.jsx';
import styles from "./ViewAllVehicles.module.css";
import VehicleService from '../../../services/VehicleService';
import Vehicle from '../../../models/Vehicle';
import React, { useState, useEffect } from 'react';

const title = {User_Id: "User Id", UserName: "Username",  Make: "Make", Model: "Model", Year: "Year", Mileage: "Mileage"}

const DisplayItem = ({vehicle}) => {
    return (
        <>
            <div className={styles.display}>
                <p className={styles.Make}>{vehicle.make}</p>
                <p className={styles.Model}>{vehicle.model}</p>
                <p className={styles.Year}>{vehicle.year}</p>
                <p className={styles.Mileage}>{vehicle.miles}</p>
            </div>
        </>
    )

}

const ViewAllVehicles= () =>{
    const [vehicles, setVehicles] = useState([]);
    const params = useParams();

    useEffect(() => {
        const fetchVehicles= async () => {
        try{
            const vehicleService = new VehicleService();
            const data = await vehicleService.getAllVehicles();
            const vehiclesList = data.map(vehicle  => new Vehicle(vehicle.id,vehicle.vin,vehicle.make,vehicle.model,vehicle.year,vehicle.miles,vehicle.plate));
            setVehicles(vehiclesList );
            }
            catch(error) {
                console.error('Error fetching vehicles :', error);
            };
        }
        fetchVehicles();
    }, [params]);
    
    return (
        
        <>
        
        <div className={styles.pagecontainer}>
                <Navbar2 />
                <div className={styles.pinkElipse}></div>
                <div className={styles.blueCircle}></div>
                <div className={styles.head}>Registered Vehicles</div>
                <div className={styles.contentContainer}>
                    <div className={styles.search}>
                        <input className={styles.searchbar}
                            onChange={() => { }}
                        />
                        <button className={styles.searchButton}>Search</button>
                    </div>
                    <div className='resultsContainer'>
                       <b> <DisplayItem vehicle = {title} /></b>
                       
                       {
                        vehicles.map(vehicle => (
                            <DisplayItem key={vehicle.id} vehicle={vehicle} />
                        ))
                       }

                       
                    </div>
                </div>
            </div>
        
        
        
        </>



    )


}

export default ViewAllVehicles