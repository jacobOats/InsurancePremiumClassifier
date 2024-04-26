import CreateClaim from './create-a-claim/CreateClaim'
import UserAddVehicle from './user-add-vehicle/UserAddVehicle'
import UserBill from './user-bill/UserBill'
import UserDashboard from './user-dashboard/UserDashboard'
import UserInfoQuote from './user-info-quote/UserInfoQuote'
import UserProfile from './user-profile/UserProfile'
import UserQuoteResult from './user-quote-result/UserQuoteResult'
import UserVehicleQuote from './user-vehicle-quote/UserVehicleQuote'
import UserVehicles from './user-vehicles/UserVehicles'
import UserContext from '../../stores/UserContext'
import { useContext, useEffect } from 'react'
import { useNavigate, Routes, Route } from 'react-router-dom'

const User = () => {
    const navigate = useNavigate();
    const userContext = useContext(UserContext);

    useEffect(() => {
        if (!userContext.loggedIn) {
            navigate('/login');
        }
    })
    
    return (
        <>
            {!userContext.loggedIn ? (
                null
            ) : (
                <Routes>
                    <Route path='create-claim' element={<CreateClaim/>} />
                    <Route path='add-vehicle' element={<UserAddVehicle/>} />
                    <Route path='bill' element={<UserBill/>} />
                    <Route path='dashboard' element={<UserDashboard/>} />
                    <Route path='info-quote' element={<UserInfoQuote/>} />
                    <Route path='profile' element={<UserProfile/>} />
                    <Route path='quote-result' element={<UserQuoteResult/>} />
                    <Route path='vehicle-quote' element={<UserVehicleQuote/>} />
                    <Route path='vehicles' element={<UserVehicles/>} />
                </Routes>
            )} 
        </>
    )
}

export default User