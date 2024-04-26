import styles from "./UserQuoteResult.module.css";
import {Navbar2} from '../../navbar1/Navbar1.jsx';
import {HomeLinkButton, MultipurposeButton} from '../../commonButton/CommonButton.jsx';

const UserQuoteResult = () => {
  return (
      <div>
        <Navbar2/>
        <div className={styles.pinkElipse}></div>
        <div className={styles.blueCircle}></div>
        <div className={`${styles.head} ${styles.distance}`}>Your Quote</div>
        <div className = {styles.head}>Num</div>
        <div className={styles.buttonSet}>
        <div className={styles.buttonRow}>
          <MultipurposeButton className={styles.green}>Accept</MultipurposeButton>
          <MultipurposeButton className={styles.red}>Decline</MultipurposeButton>
          </div>
          <div className={styles.buttonRow}>
          <HomeLinkButton />
        </div>
        </div>
        </div>
  );
}

export default UserQuoteResult;
