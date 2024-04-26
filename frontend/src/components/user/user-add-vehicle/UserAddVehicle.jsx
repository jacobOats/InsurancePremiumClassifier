import { Navbar2 } from '../../navbar1/Navbar1.jsx';
import styles from "./UserAddVehicle.module.css";
import { HomeLinkButton, MultipurposeButton } from '../../commonButton/CommonButton.jsx';
import Vehicle from '../../../models/Vehicle.js';
import { Link, useParams } from 'react-router-dom';
import React, { useState, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import VehicleService from '../../../services/VehicleService.js';
const UserAddVehicle = () => {
  const navigate = useNavigate();
    const [vehicle, setVehicles] = useState(new Vehicle('', '', '', '', '')); // Initialize with empty client
    const [errorMessage, setErrorMessage] = useState('');

    const handleChange = (e) => {
        const { id, value } = e.target;
        setVehicles(prevClient => ({
            ...prevClient,
            [id]: value
        }));
    };

    const handleSubmit =useCallback(async (e) => {
        e.preventDefault();
        try {
            const vehicleService = new VehicleService();
            await vehicleService.addVehicle(vehicle);
            
            const storedVehicles = JSON.parse(localStorage.getItem('vehicles'));
            storedVehicles.push(vehicle);
            localStorage.setItem('vehicle', storedVehicles);

            navigate('../vehicles')
        } catch (error) {
            setErrorMessage('Registration failed. Please try again.');
        }
    }, [vehicle]);


  return (
    <div>
      <Navbar2 />
      <div className={styles.pinkElipse}></div>
      <div className={styles.blueCircle}></div>
      <div className={styles.head}>Add a Vehicle</div>
      <form onSubmit={handleSubmit}>
        <div className={styles.container}>
          <div className={styles.inputContainer}>
            <label htmlFor="vin" className={styles.whiteText}>VIN:</label>
            <input type="text" id="vin" value={vehicle.vin} className={styles.infoholder} placeholder="Enter VIN" required onChange={handleChange}/>
          </div>
          <div className={styles.inputContainer}>
            <label htmlFor="year" className={styles.whiteText}>Year:</label>
            <input type="text" id="year" value={vehicle.year} className={styles.infoholder} placeholder="Enter Year" required onChange={handleChange} />
          </div>
          <div className={styles.inputContainer}>
            <label htmlFor="make" className={styles.whiteText}>Make:</label>
            <input type="text" id="make" value={vehicle.make} className={styles.infoholder} placeholder="Enter Make" required onChange={handleChange} />
          </div>
          <div className={styles.inputContainer}>
            <label htmlFor="model" className={styles.whiteText}>Model:</label>
            <input type="text" id="model" value={vehicle.model} className={styles.infoholder} placeholder="Enter Model" required onChange={handleChange} />
          </div>
          <div className={styles.inputContainer}>
            <label htmlFor="mileage" className={styles.whiteText}>Mileage:</label>
            <input type="text" id="miles" value={vehicle.miles} className={styles.infoholder} placeholder="Enter Mileage" required onChange={handleChange} />
          </div>
          <div className={styles.inputContainer}>
            <label htmlFor="mileage" className={styles.whiteText}>License Plate:</label>
            <input type="text" id="plate" value={vehicle.plate} className={styles.infoholder} placeholder="Enter Plate" required onChange={handleChange} />
          </div>
        </div>
        <div className={styles.buttonRow}>
          <HomeLinkButton />
          <MultipurposeButton type="submit">Add Vehicle</MultipurposeButton>
        </div>
      </form>
    </div>
  );
}

export default UserAddVehicle;
