import Client from '../../../models/Client.js';
import ClientService from '../../../services/ClientService';
import { Navbar2 } from '../../navbar1/Navbar1.jsx';
import styles from "./UserProfile.module.css";
import { HomeLinkButton } from '../../commonButton/CommonButton.jsx';
import { useState, useEffect, useCallback } from 'react';
import { useParams } from 'react-router-dom';


const UserProfile = () => {
    const [message, setMessage] = useState('');
    const [newPassword, setNewPassword] = useState('');
    const [reenteredPassword, setReenteredPassword] = useState('');
    const [client, setClient] = useState(new Client());
    const params = useParams();

    useEffect(() => {
        const fetchClients= async () => {
        try{
            const clientService = new ClientService();
            const client  = await clientService.getClientInfo();
            setClient(client);
            localStorage.setItem('clientId', client.id);
            }
            catch(error) {
                console.error('Error fetching Clients:', error);
            }
        }
        fetchClients();
    }, [params]);

    const handleNewPasswordChange = (event) => {
        setNewPassword(event.target.value);
    }

    const handleReenteredPasswordChange = (event) => {
        setReenteredPassword(event.target.value);
    }

    const handleClick = useCallback(async (event) => {
        event.preventDefault();

        if (newPassword === reenteredPassword) {
            const response = await fetch('http://localhost:8080/api/password', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Password': newPassword
                },
                credentials: 'include'
            })
            
            if (response.status >= 200 && response.status < 200) {
                setMessage('Password successfully changed.');
            }
        }
    }, [newPassword, reenteredPassword]);

    return (
    <div>
        <Navbar2 />
        <div className={styles.pinkElipse}></div>
        <div className={styles.blueCircle}></div>
        <div className={styles.head}>Your Profile</div>

        <div className={styles.container}>
        <div className={styles.registrationForm}>
            <div>
            <label>First Name:</label>
            <input type="text" className={styles.inputField} placeholder="First Name" value={client.firstName} />
            </div>
            <div>
            <label>Last Name:</label>
            <input type="text" className={styles.inputField} placeholder="Last Name" value={client.lastName}  />
            </div>
            <div>
            <label>Date of Birth:</label>
            <input type="text" className={styles.inputField} placeholder="Date of Birth" value={client.dob}/>
            </div>
            <div>
            <label>Email:</label>
            <input type="email" className={styles.inputField} placeholder="Email" value={client.email}/>
            </div>
            <HomeLinkButton />
        </div>
        <div className={styles.registrationForm}>
            {message.length === 0 ? null : <p>{message}</p>}
            <div className={styles.text}>Change Password</div>
            <label>
            New Password:
            <input 
                className={styles.password} 
                type="password" 
                placeholder='New Password' 
                onChange={handleNewPasswordChange}
                value={newPassword}
            />
            </label>

            <div className={styles.passwordStrength}>
                <div className={styles.indicatorText}></div>
            </div>

            <label>
            Re-enter Password:
            <input 
                className={`${styles.password} ${styles.pass3}`} 
                type="password" 
                placeholder='Re-enter Password' 
                onChange={handleReenteredPasswordChange}
                value={reenteredPassword}
            />
            </label>
            
            <input type="submit" value="Submit" onClick={handleClick}/>
        </div>
        </div>
    </div>
    )
}

export default UserProfile;
