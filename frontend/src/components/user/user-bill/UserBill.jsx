import styles from './UserBill.module.css';
import {Navbar2} from '../../navbar1/Navbar1.jsx';
import {HomeLinkButton, MultipurposeButton} from '../../commonButton/CommonButton.jsx';
import { useState, useEffect } from 'react';

const UserBill = () => {
    const [bills, setBills] = useState([]);

    useEffect(() => {
        const getBills = async () => {
            const response = await fetch('http://localhost:8080/api/payments', {
                credentials: 'include'
            })

            if (response.status >= 200 && response.status < 400) {
                const receivedBills = await response.json();
                setBills(receivedBills);
            }
        }

        getBills();
    }, [])

    return (
        <div>
            <Navbar2/>
            <div className={styles.pinkElipse}></div>
            <div className={styles.blueCircle}></div>

            {bills.length == 0 ? (
                <h1>No bills to show</h1>
            ) : (
                <>
                    <div className = {styles.head}>Your Vehicles</div>
                    <div className={styles.userCarRow}>
                        {bills.map((car, carIndex) => (
                            <div className={styles.valueRow} key={carIndex}>
                            {Object.values(car).map((value, index) => (
                                <div key={index}>
                                {value}
                                </div>
                            ))}
                            </div>
                        ))}
                        <div className={styles.total}>
                            <div> Total</div>
                            <div> $Amount</div>
                        </div>
                        <input type="number" className={styles.payAmt} placeholder="Payment Amount" />
                    </div>
                    
                    <div className={styles.buttonRow}>
                        <HomeLinkButton/>
                        <MultipurposeButton>Pay Now</MultipurposeButton>
                    </div>
                </>
            )}
        </div>
    );
}

export default UserBill;