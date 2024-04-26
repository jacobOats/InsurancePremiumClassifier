import { createContext } from "react";

const UserContext = createContext({
    loggedIn: false,

    login: async (formData) => {},
    logout: async () => {}
})

export default UserContext;