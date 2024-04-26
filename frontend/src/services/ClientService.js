// services/ClientService.js
import axios from 'axios';
import Client from '../models/Client';

class ClientService {
    constructor() {
        this.employees = [];
    }

    async addClient(client) {
        return axios.post('http://localhost:8080/api/clients/client', client)
        .then(response => response.data)
        .catch(error => {
            console.error('Error adding user:', error);
            throw error; // Propagate error to caller
        });
    }

    async getClientById(id) {
        return axios.get(`http://localhost:8080/api/clients/client/${id}`)
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching client by ID:', error);
            throw error; // Propagate error to caller
        });
    }

    async getClientInfo() {
        const response = await fetch('http://localhost:8080/api/logged-in/info',{ 
            credentials: 'include'
        });

        if (response.status >= 200 && response.status < 400) {
            const dto = await response.json();
            const client = new Client(dto.id, 
                                      dto.address, 
                                      dto.firstName,
                                      dto.lastName,
                                      dto.email,
                                      dto.password,
                                      dto.dob,
                                      dto.employee,
                                      dto.vehicles,
                                      dto.payments);
            return client;
        } else {
            return null;
        }
    }

    async getAllClients() {
        const response = await fetch('http://localhost:8080/api/clients/client', {
            credentials: 'include'
        });
        
        if (response.status >= 200 && response.status < 400) {
            return await response.json();
        } else {
            return [];
        }
    }
}

export default ClientService;
