import { Link } from 'react-router-dom';
import {Navbar2} from '../../navbar1/Navbar1.jsx';
import styles from "./EmployeeDashboard.module.css";
import { useNavigate } from 'react-router-dom';
import { useContext } from 'react';
import UserContext from '../../../stores/UserContext.jsx'

const EmployeeDashboard= () =>{
    const navigate = useNavigate();
    const sendToView = () => {
    navigate('/employee/view-all-users');
    };
    const sendToVehicle = () => {
        navigate('/employee/view-all-vehicles');
        };
    const sendToMissed = () => {
            navigate('/employee/users-missed-payments');
            };
    return (
        
        <>
        <div>
         <Navbar2/>
            <div className={styles.pinkElipse}></div>
            <div className={styles.blueCircle}></div>
         <div className = {styles.head}>Hello Employee</div>
         <div className = {styles.container}>
         <div className = {styles.claims}>
               <h2>Missed Payments</h2>
                <p className = {styles.numValue}>0</p>
            </div>
            <div className = {styles.claims}>
               <h2>Claims</h2>
                <p className = {styles.numValue}>0</p>
            </div>
         </div>
            <div className = {styles.buttons}>
                <button type = "button" className = {styles.button} onClick = {sendToView}>View all users</button>
                <button type = "button"  className = {styles.button} onClick = {sendToVehicle}>View all vehicles</button>
                <button type = "button"  className = {styles.button} onClick = {sendToMissed}>View all users with missed payments</button>
            </div>
         
        </div>
        
        
        
        </>



    )


}

export default EmployeeDashboard