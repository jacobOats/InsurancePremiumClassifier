import {Navbar2} from '../../navbar1/Navbar1.jsx';
import styles from "./UserInfoQuote.module.css";
import { useNavigate } from 'react-router-dom';
import {HomeLinkButton, MultipurposeButton} from '../../commonButton/CommonButton.jsx';

const UserInfoQuote= () => {
  const navigateVehicleQuote = useNavigate();
  const handleVehicleQuote=() =>
  {
    navigateVehicleQuote('vehicle-quote');
  }
return (
    <div>
    <Navbar2/>
    <div className={styles.pinkElipse}></div>
    <div className={styles.blueCircle}></div>
    <div className = {styles.head}>User Information</div>
    <div className={styles.container}>
    <input type="text" className={styles.infoholder} placeholder="Placeholder" />
<input type="text" className={styles.infoholder} placeholder="Placeholder" />
<input type="text" className={styles.infoholder} placeholder="Placeholder" />
<input type="text" className={styles.infoholder} placeholder="Placeholder" />
<input type="text" className={styles.infoholder} placeholder="Placeholder" />
    </div>
    <div className={styles.buttonRow}>
    <HomeLinkButton/>
    <MultipurposeButton onClick={handleVehicleQuote}>Next</MultipurposeButton>
    </div>
    </div>
  );
}

export default UserInfoQuote