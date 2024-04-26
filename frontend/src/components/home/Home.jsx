import { Link,useParams } from 'react-router-dom';
import styles from './Home.module.css';
import drivingImg from '../../../Images/people-driving-car.jpg'
import { Navbar1, Navbar3 } from '../navbar1/Navbar1.jsx';
import BottomSection from './BottomSection.jsx';
import EmployeeService from '../../services/EmployeeService';
import Employee from '../../models/Employee';
import { useState, useEffect } from 'react';

const Home = () => {
    const [employees, setEmployees] = useState([]);
    const params = useParams();
    useEffect(() => {
        const fetchEmployees = async () => {
        try{
            const employeeService = new EmployeeService();
            const data = await employeeService.getAllEmployees();
            const employeeList = data.map(employee => new Employee(employee.id, employee.firstName, employee.lastName,employee.manager,employee.organizaiton));
            setEmployees(employeeList);
            console.log(employeeList+"adssadadsads");
            }
            catch(error) {
                console.error('Error fetching Employees:', error);
            }
        }
       fetchEmployees();
    }, [params]);


    return (
        <div className = {styles.page}>
            <div className={styles.pinkEllipse}></div>
            <div className={styles.blueCircle}></div>
            <Navbar3 />
            <div className = {styles.imgContainer}>
                <img src={drivingImg} className= {styles.topPicture} />
            </div>
            <div className ={styles.leftBlurb}>
                <h1>We provide the best value <b>insurance</b></h1>
                <p>Simple Steps You Can Take to Improve Your Financial Well-Being for the rest of Your Life</p>
            </div>
            <div className = {styles.quoteForm}>
                <form className= {styles.Form}>
                <h2>Get a Quote</h2>
                    <input type = "text" placeholder = "Your name" className={styles.formField}></input>
                    <input type = "text" placeholder = "Phone" className={styles.formField}></input>
                    <input type = "text" placeholder = "Email" className={styles.formField}></input>
                    <input type = "submit" value = "Get a quote" className= {styles.submitButton} />
                </form>

                <div>
                <h2>User List</h2>
                <ul>
                    {employees.map(employee => (
                        <li key={employee.id}>
                            <strong>Name:</strong> {employee.firstName}
                        </li>
                    ))}
                </ul>
                </div>
            </div>
            
            <BottomSection />
        </div>

        
    )
}

export default Home