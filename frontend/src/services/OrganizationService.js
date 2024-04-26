// services/ClientService.js
import axios from 'axios';
class OrganizationService {
  constructor() {
    this.employees = [];
  }

  addOrganization(org) {
      return axios.post('http://localhost:8080/api/organization/org', org)
            .then(response => response.data)
            .catch(error => {
                console.error('Error adding Organization:', error);
                throw error; // Propagate error to caller
            });
  }

  getOrganizationById(id) {
    return axios.get(`http://localhost:8080/api/organizaiton/org/${id}`)
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching organization by ID:', error);
            throw error; // Propagate error to caller
        });
}
  getAllOrganization() {
    return axios.get('http://localhost:8080/api/organization/org')
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching Organization:', error);
            throw error; // Propagate error to caller
        });
}
}

export default OrganizationService;
