// services/ClientService.js
import axios from 'axios';
class ClaimService {
  constructor() {
    this.employees = [];
  }

  addClaim(claim) {
      return axios.post('http://localhost:8080/api/claims/claim', claim)
            .then(response => response.data)
            .catch(error => {
                console.error('Error adding claim:', error);
                throw error; // Propagate error to caller
            });
  }

  getClaimById(id) {
    return axios.get(`http://localhost:8080/api/claims/claims/${id}`)
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching claim by ID:', error);
            throw error; // Propagate error to caller
        });
}

  getAllClaims() {
    return axios.get('http://localhost:8080/api/claims/claim')
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching claim:', error);
            throw error; // Propagate error to caller
        });
}
}

export default ClientService;
