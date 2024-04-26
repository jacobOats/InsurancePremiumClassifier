import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import UserContextProvider from './stores/UserContextProvider.jsx'
import DataContextProvider from './stores/DataContextProvider.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <UserContextProvider>
    <DataContextProvider>
        <App />
    </DataContextProvider>
  </UserContextProvider>,
)
