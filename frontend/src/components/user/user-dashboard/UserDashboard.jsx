import {Navbar2} from '../../navbar1/Navbar1.jsx';
import styles from "./UserDashboard.module.css"
import {LinkButton} from '../../commonButton/CommonButton.jsx';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import ClientService from '../../../services/ClientService';

const UserDashboard = () => {
    const [clientInfo, setClientInfo] = useState([]);
    const params = useParams();

    useEffect(() => {
        const fetchClients= async () => {
            try{
                const clientService = new ClientService();
                const clientInfo = await clientService.getClientInfo();
                setClientInfo(clientInfo);
                const vehiclesString = JSON.stringify(clientInfo.vehicles);
                console.log('vehicles', vehiclesString);
                localStorage.setItem('vehicle', vehiclesString);
            }
            catch(error) {
                console.error('Error fetching Clients:', error);
            }
        }   

        fetchClients();
    }, [params]);

    return (
        <div>
            <Navbar2/>
            <div className={styles.pinkElipse}></div>
                <div className={styles.blueCircle}></div>

                {clientInfo ? (
                    <div className={styles.welcome}>Welcome, {clientInfo.firstName}</div>
                ) : (
                    <div className={styles.welcome}>Welcome back!</div>
                )}
                

                <div className={styles.mainContainer}>
                    <div className={styles.row1}>
                        <LinkButton to = "../create-claim" className= {styles.claim}>Claim</LinkButton>
                        <LinkButton to="../bill" className= {styles.bills}>Bills</LinkButton>
                        <LinkButton to="../vehicles" className= {styles.vehicles}>Vehicles</LinkButton>
                    </div>

                    <div className={styles.row2}>
                    <LinkButton to ="/quote" className= {styles.quote} >Quote</LinkButton>
                    <LinkButton to ="../profile" className= {styles.profile}>Profile</LinkButton>
                </div>
            </div>
        </div>
    )            
}

export default UserDashboard