import styles from './BottomSection.module.css';
import bottomCar from '../../../Images/bottom-car.jpg'

const BottomSection = () => {
    return (
        <div className = {styles.Container}>
            <div className= {styles.InfoBlurb}>
                <h2 className={styles.BlurbTitle}>Car insurance</h2>
              
                <p>Make a plan for the emergence of life. We protect your most precious assets, allowing you to devote your time and energy
                    to more essential things in life.
                </p>
                <p>Discover the most appropriate fit for you and your Family.</p>
            </div>
            <div className= {styles.PictureContainer}>
                <div className={styles.BackgroundSquare}></div>
               
                <div className={styles.picture}>
                    <img src ={bottomCar} />
                </div>
                <div className={styles.BackgroundSquareOutline}></div>
            </div>
        </div>
    )
}

export default BottomSection