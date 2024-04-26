import { Link,useParams } from 'react-router-dom';
import { Navbar2 } from '../../navbar1/Navbar1.jsx';
import styles from "./UserMissedPayments.module.css";

const users = [
    { User_Id: "0001", UserName: "Space_Cowboy",Fname : "Spike", Lname: "Spiegel", amount: 5000 },
    { User_Id: "0002", UserName: "ExCop", Fname: "Jet", Lname: "Black", amount: 500 },
    { User_Id: "0003", UserName: "noMem", Fname: "Fae", Lname: "Valentine", amount: 10000000 }
];

const title = {User_Id: "User Id", UserName: "Username",Fname : "Fname", Lname: "Lname", amount: "Amount Owed"}

const DisplayItem = ({user}) => {
    return (
        <>
            <div className={styles.display}>
                <p className={styles.UserID}>{user.User_Id}</p>
                <p className={styles.UserName}>{user.UserName}</p>
                <p className={styles.Fname}>{user.Fname}</p>
                <p className={styles.Lname}>{user.Lname}</p>
                <p className={styles.Ammount}>{user.amount}</p>
            </div>
        </>
    )

}

const UserMissedPayments = () => {

    return (

        <>
        
            <div className={styles.pagecontainer}>
                <Navbar2 />
                <div className={styles.pinkElipse}></div>
                <div className={styles.blueCircle}></div>
                <div className={styles.head}>All Users With Missed Payments</div>
                <div className={styles.contentContainer}>
                    <div className={styles.search}>
                        <input className={styles.searchbar}
                            onChange={() => { }}
                        />
                        <button className={styles.searchButton}>Search</button>
                    </div>
                    <div className='resultsContainer'>
                        <b><DisplayItem user = {title} /></b>
                       
                       {
                        users.map(user => (
                            <DisplayItem user = {user} />
                        ))
                       }
                    </div>
                </div>
            </div>

        </>



    )


}

export default UserMissedPayments