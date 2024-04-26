import {Navbar2} from '../../navbar1/Navbar1.jsx';
import styles from "./UserVehicleQuote.module.css";
import {HomeLinkButton, MultipurposeButton} from '../../commonButton/CommonButton.jsx';

const UserVehicleQuote= () =>{
    return (
        <div>
        <Navbar2/>
        <div className={styles.pinkElipse}></div>
        <div className={styles.blueCircle}></div>
        <div className = {styles.head}>Vehicle Information</div>
        <div className={styles.container}>
        <input type="text" className={styles.infoholder} placeholder="Placeholder" />
        <input type="text" className={styles.infoholder} placeholder="Placeholder" />
        <input type="text" className={styles.infoholder} placeholder="Placeholder" />
        <input type="text" className={styles.infoholder} placeholder="Placeholder" />
        <input type="text" className={styles.infoholder} placeholder="Placeholder" />
        </div>
        <div className={styles.buttonRow}>
        <HomeLinkButton/>
        <MultipurposeButton>Next</MultipurposeButton>
        </div>
        </div> 
    )

}

export default UserVehicleQuote