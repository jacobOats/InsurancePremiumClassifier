import { Link,useParams } from 'react-router-dom';
import { Navbar2 } from '../../navbar1/Navbar1.jsx';
import styles from "./ViewAllUsers.module.css";
import ClientService from '../../../services/ClientService';
import Client from '../../../models/Client';
import React, { useState, useEffect } from 'react';

const DisplayItem = ({client}) => {
    return (
        <>
            <div className={styles.display}>
                <p className={styles.UserID}>{client.id}</p>
                <p className={styles.UserName}>{client.firstName}</p>
                <p className={styles.Lname}>{client.lastName}</p>
                <p className={styles.PaymentStatus}>{client.email}</p>
                <p className={styles.PaymentStatus}>{client.address}</p>
                <p className={styles.PaymentStatus}>{client.dob}</p>
            </div>
        </>
    )

}

const ViewAllUsers= () =>{
    const [clients, setClients] = useState([]);
    const params = useParams();
    useEffect(() => {
        const fetchClients= async () => {
            try{
                const clientService = new ClientService();
                const data = await clientService.getAllClients();
                const clientList = data.map(client => new Client(client.id,client.address,client.firstName,client.lastName,client.email,client.dob,client.password));
                setClients(clientList);
            }
            catch(error) {
                console.error('Error fetching Clients:', error);
            }
        }

       fetchClients();
    }, [params]);
    return (
        
        <>
         <div className={styles.pagecontainer}>
                <Navbar2 />
                <div className={styles.pinkElipse}></div>
                <div className={styles.blueCircle}></div>
                <div className={styles.head}>All Users</div>
                <div className={styles.contentContainer}>
                    <div className={styles.search}>
                        <input className={styles.searchbar}
                            onChange={() => { }}
                        />
                        <button className={styles.searchButton}>Search</button>
                    </div>
                    <div className='resultsContainer'>
                     
                       
                       {
                        clients.map(client => (
                            <DisplayItem  client = {client} />
                        ))
                       }
 
                       
                    </div>
                </div>
            </div>
            
        
        
        </>



    )


}

export default ViewAllUsers