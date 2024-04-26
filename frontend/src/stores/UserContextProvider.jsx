import { useState, useEffect } from "react"
import UserContext from "./UserContext"

const UserContextProvider = ({children}) => {
    const [loggedIn, setLoggedIn] = useState(false);

    useEffect(() => {
        const checkIfLoggedIn = async () => {
            const response = await fetch('http://localhost:8080/api/logged-in',{ 
                credentials: 'include'
                });

            if (response.status >= 200 && response.status < 400) {
                const dto = await response.json();

                if (dto.message.toLowerCase() === 'true') {
                    setLoggedIn(true);
                }
            }
            
        }
        checkIfLoggedIn();
    }, []);

    const login = async (formData) => {
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: formData,credentials: 'include'
        });
        
        if (!response.url.includes('error')&&response.status >= 200 && response.status < 400) {
            setLoggedIn(true);
            return [true];
        } else {
            return [false, "Username or password not correct."];
        }
    }
     

    const logout = async () => {
        const response = await fetch("http://localhost:8080/logout", {
            method: 'POST'
        });

        if (response.status >= 200 && response.status < 400) {
            setLoggedIn(false);
            return [true];
        } else {
            return [false, 'Could not logout.'];
        }
    }

    const data = {
        loggedIn: loggedIn,
        login: login,
        logout: logout
    }

    return (
        <UserContext.Provider value={data}>
            {children}
        </UserContext.Provider>
    )
}

export default UserContextProvider;