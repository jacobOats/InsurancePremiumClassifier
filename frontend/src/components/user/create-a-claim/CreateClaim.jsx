import {Navbar2} from '../../navbar1/Navbar1.jsx';
import styles from "./CreateClaim.module.css";
import {HomeLinkButton, MultipurposeButton} from '../../commonButton/CommonButton.jsx';

const CreateClaim= () => {
    const vehicles = JSON.parse(localStorage.getItem('vehicle'));

    return (
        <div>
            <Navbar2/>
            <div className={styles.pinkElipse}></div>
            <div className={styles.blueCircle}></div>

            <div className={styles.userCarRow}>
                {vehicles === null ? (
                    <>
                        <h1>No Vehicles to Show</h1>
                    </>
                ) : (
                    <>
                        <div className={styles.headingRow}>
                            {Object.keys(vehicles[0]).map((property, index) => (
                            <div key={index}>
                                {property}
                            </div>
                            ))}
                            <div>Claim</div>
                        </div>
                        
                        <div>
                            {vehicles.map((car, carIndex) => (
                                <div className={styles.valueRow} key={carIndex}>
                                    {Object.values(car).map((value, index) => (
                                        <div key={index}>
                                            {value}
                                        </div>
                                    ))}
                                <div>
                                    <input className={styles.checkbox} type="checkbox" id="carCheckbox"/>
                                </div>
                                </div>
                            ))}
                        </div>

                        <div className={styles.buttonRow}>
                            <HomeLinkButton className={styles.btn}></HomeLinkButton>
                            <MultipurposeButton className={styles.btn}>Create a Claim</MultipurposeButton>
                        </div>
                    </>
                )}
            </div>
        </div>
    );
}

export default CreateClaim