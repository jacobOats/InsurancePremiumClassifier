import styles from "./CommonButton.module.css";
import { Link } from 'react-router-dom';

export const LinkButton = ({to, children, className }) => {
  return (
    <Link to={to} className={`${styles.commonButton} ${className}`} >
      {children}
    </Link>
  );
};
export const HomeLinkButton = ({ className}) => {
  return (
    <Link to = '/user/dashboard' className={`${styles.homeLinkButton} ${className}`} >
      Home
    </Link>
  );
};
export const MultipurposeButton = ({ children, onClick, className }) => {
  return (
    <button onClick={onClick} className={`${styles.multipurposeButton} ${className}`}>
      {children}
    </button>
  );
}

