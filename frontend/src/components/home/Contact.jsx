import { Link } from 'react-router-dom';
import { Navbar1 } from '../navbar1/Navbar1';
import styles from './Contact.module.css'

const Contact  = () => {
    return (
        <>
        <div className={styles.pinkEllipse}></div>
        <div className={styles.blueCircle}></div>
        <Navbar1 />
        <h1>Email: realHumanBeing@gmail.com</h1>
        <h1>Phone: 637-482-7463</h1>
        </>
    )
}
export default Contact;