import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/home/Home'
import Loginc from './components/user/loginc/Loginc'
import Logine from './components/employee/logine/logine'
import Register from './components/user/register/Register'
import User from './components/user/User';
import Employee from './components/employee/Employee';
import Contact from './components/home/Contact';
import './App.css'
import Quote from './components/quote/Quote';


function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/login' index element={<Loginc />} />
        <Route path='/quote' element={<Quote />} />
        <Route path='/logine' index element={<Logine />} />
        <Route path='/sign-up' element={<Register />} />
      
        <Route path="/user/*" element={<User />} />
        <Route path="/employee/*" element={<Employee />} />
        <Route path= '/contact' element ={<Contact />} />
      </Routes>
    </Router>
  )
}

export default App
