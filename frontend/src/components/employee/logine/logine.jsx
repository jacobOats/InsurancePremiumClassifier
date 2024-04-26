import {Navbar1} from '../../navbar1/Navbar1.jsx';
import styles from "./logine.module.css";
import UserContext from '../../../stores/UserContext.jsx';
import { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';

const Logine = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const userContext = useContext(UserContext);
  const navigate = useNavigate();

  const handleEmailChange  = (event) => {
    setEmail(event.target.value);
  }

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  }

  const handleClickLogin = async () => {
    const formData = new URLSearchParams();
    formData.append('email', email);
    formData.append('password', password);

    const result = await userContext.login(formData);
    if (result[0]) {
      navigate('/employee/dashboard')
    }
  };
  
  return (
      <div className="div">
        <Navbar1/>
        <div className={styles.pinkElipse}></div>
        <div className={styles.blueCircle}></div>

        <form className={styles.loginForm}>
          <div>
            <label>Email:</label>
            <input 
              type="email" 
              className={styles.inputField} 
              placeholder="Email" 
              value={email}
              onChange={handleEmailChange}
            />
          </div>
          
          <div>
            <label>Password:</label>
            <input 
              type="password" 
              className={styles.inputField} 
              placeholder="Password" 
              value={password}
              onChange={handlePasswordChange}
            />
          </div>
          
          <button type="button" className={styles.loginButton} onClick={handleClickLogin} >Login</button>
        </form>
      </div>
  );
}

export default Logine;
