import styles from "./Navbar1.module.css"
import { Link } from 'react-router-dom';
import { useContext } from "react";
import UserContext from "../../stores/UserContext";

export const Navbar1 = () => {
    return (
      <nav className={styles.navbar}>
        <Link to="/" className={styles.white}>IPC</Link>
        <div className={styles.navLinks}>
          <Link to="/user/create-claim" className={styles.white} >Claim</Link>
          <Link to="/quote" className={styles.white} >Quote</Link>
          <Link to="/login" className= {styles.white} >Login</Link>
        </div>
      </nav>
    )
};
export const Navbar2 = () => {
  const userContext = useContext(UserContext);

  const handleLogout = async () => {
    userContext.logout();
  }

  return (
    <nav className={styles.navbar2}>
      <Link to="/" className={styles.white}>IPC</Link>
      <Link to="/" className={`${styles.navLink} ${styles.logout} ${styles.white}`} onClick={handleLogout}>Logout</Link>
    </nav>
  )
};

export const Navbar3 = () => {
  return (
    <nav className={styles.navbar3}>

    <div className={styles.navLinks}>
      <Link to="/user/create-claim" className={styles.white2} >Claim</Link>
      <Link to="/quote" className={styles.white2} >Quote</Link>
      <Link to="/login" className= {styles.white2} >Login</Link>
      <Link to="/contact" className= {styles.white2}>Contact Us</Link>
    </div>
    </nav>
  )
};
