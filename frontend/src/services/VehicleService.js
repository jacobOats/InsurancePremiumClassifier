// services/ClientService.js
import axios from 'axios';
class VehicleService {
  constructor() {
    this.employees = [];
    this.instance = axios.create({
      withCredentials: true})
  }

  addVehicle(vehicle) {
    console.log(vehicle);
      return this.instance.post('http://localhost:8080/api/vehicles/vehicle', vehicle)
            .then(response => response.data)
            .catch(error => {
                console.error('Error adding Vehicle:', error);
                throw error; // Propagate error to caller
            });
  }

  getVehicleById(id) {
    return axios.get(`http://localhost:8080/api/vehicles/vehicle/${id}`)
        .then(response => response.data)
        .catch(error => {
            console.error('Error fetching Vehicle by ID:', error);
            throw error; // Propagate error to caller
        });
}

  async getAllVehicles() {
    const response = await fetch('http://localhost:8080/api/vehicles/vehicle', {
        credentials: 'include'
    })
    
    if (response.status >= 200 && response.status < 400) {
        const vehicles = await response.json();
        console.log(vehicles);
        return vehicles;
    } else {
        return [];
    }
}
}

export default VehicleService;
