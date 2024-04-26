import EmployeeDashboard from './employee-dashboard/EmployeeDashboard'
import UserMissedPayments from './users-missed-payments/UserMissedPayments'
import ViewAllUsers from './view-all-users/ViewAllUsers'
import ViewAllVehicles from './view-all-vehicles/ViewAllVehicles'
import UserContext from '../../stores/UserContext'
import { useContext,useEffect } from 'react'
import { useNavigate, Routes, Route } from 'react-router-dom'

const Employee = () => {
    const navigate = useNavigate();
    const userContext = useContext(UserContext);

    useEffect(() => {
        if (!userContext.loggedIn) {
            navigate('/logine');
        }
    })

    return (
        <>
            {!userContext.loggedIn ? (
                null
            ) : (
                <Routes>
                    <Route path='dashboard' element={<EmployeeDashboard/>} />
                    <Route path='users-missed-payments' element={<UserMissedPayments/>} />
                    <Route path='view-all-users' element={<ViewAllUsers/>} />
                    <Route path='view-all-vehicles' element={<ViewAllVehicles/>} />
                </Routes>
            )}
        </>
    )
}

export default Employee