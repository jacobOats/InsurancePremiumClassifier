import {Navbar1} from '../../navbar1/Navbar1.jsx';
import styles from './Register.module.css';
import { useNavigate } from 'react-router-dom';
import Client from '../../../models/Client';
import ClientService from '../../../services/ClientService';
import { useState } from 'react';

const Register = () => {
    const navigate = useNavigate();
    const [client, setClient] = useState(new Client('', '', '', '', '', '', '')); // Initialize with empty client
    const [errorMessage, setErrorMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setClient(prevClient => ({
            ...prevClient,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const clientService = new ClientService();
            await clientService.addClient(client);
            navigate('/user/dashboard')
        } catch (error) {
            setErrorMessage('Registration failed. Please try again.');
        }
    };

    return (
        <div className="div">
            <Navbar1/>
            <div className={styles.pinkElipse}></div>
            <div className={styles.blueCircle}></div>
            <div className={styles.registerContainer}>
                <form onSubmit={handleSubmit} className={styles.registrationForm}>
                    {errorMessage ? <p>{errorMessage}</p> : null}
                    <div>
                        <label>First Name:</label>
                        <input type="text" name="firstName" value={client.firstNames} className={styles.inputField} placeholder="First Name" onChange={handleChange} />
                    </div>
                    <div>
                        <label>Last Name:</label>
                        <input type="text"  name="lastName" value={client.lastName} className={styles.inputField} placeholder="Last Name" onChange={handleChange} />
                    </div>
                    <div>
                        <label>Email:</label>
                        <input type="email"  name="email" value={client.email} className={styles.inputField} placeholder="Email" onChange={handleChange} />
                    </div>
                    <div>
                        <label>Address:</label>
                        <input type="text"  name="address" value={client.address} className={styles.inputField} placeholder="Last Name" onChange={handleChange} />
                    </div>
                    <div>
                        <label>Date of Birth:</label>
                        <input type="date"  name="dob" value={client.dob} className={styles.inputField} placeholder="Date of Birth" onChange={handleChange} />
                    </div>
                    <div>
                        <label>Password:</label>
                        <input type="password"  name="password" value={client.password} className={styles.inputField} placeholder="Password" onChange={handleChange} />
                    </div>
                    <div>
                        <label>Confirm Password:</label>
                        <input type="password" className={styles.inputField} placeholder="Confirm Password" />
                    </div>
                    <div style={{ color:'white' }}>
                    * Must be at least 16 characters <br />
                    * Must contain an upper case character <br />
                    * Must contain a lower case character <br />
                    * Must contain at least one number <br />
                    * Must contain at least one special character
                    </div>

                    <button type="submit" className={styles.next}>Register</button>
                </form>
            </div>
        </div>
    )
}

export default Register;